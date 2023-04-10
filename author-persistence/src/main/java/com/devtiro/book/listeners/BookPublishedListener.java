package com.devtiro.book.listeners;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.devtiro.book.domain.Author;
import com.devtiro.book.domain.Notification;
import com.devtiro.book.exceptions.InvalidMessageException;
import com.devtiro.book.services.AuthorService;
import com.devtiro.book.services.NotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("production")
@Slf4j
public class BookPublishedListener {

    private final ObjectMapper objectMapper;

	private final AuthorService authorService;

	private final NotificationService notificationService;

	public BookPublishedListener(
		final ObjectMapper objectMapper,
		final AuthorService booksService,
		final NotificationService notificationService) {
			this.objectMapper = objectMapper;
			this.authorService = booksService;
			this.notificationService = notificationService;
	}

	@KafkaListener(topics = "books.published")
	public String listens(final String in) {
		log.info("Received Book: {}", in);
		try {
			final Map<String, Object> payload = readJsonAsMap(in);

			final Author author = authorFromPayload(payload);
			final Author savedAuthor = authorService.save(author);

			final String message = String.format(
				"Author '%s' [%d] persisted!",
				savedAuthor.getName(),
				savedAuthor.getId()
			);
			notificationService.publishNotification(
				Notification.builder()
					.message(message)
					.timestamp(LocalDateTime.now())
					.service("author-persistence")
				.build());

		} catch(final InvalidMessageException ex) {
			log.error("Invalid message received: {}", in);
		}


		return in;
	}

	private Map<String, Object> readJsonAsMap(final String json) {
		try{
			final TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String,Object>>() {};
			return objectMapper.readValue(json, typeRef);
		} catch(JsonProcessingException ex) {
			throw new InvalidMessageException();
		}
	}

	/**
	 * Note - There are MUCH MUCH MUCH better ways of doing this.
	 * 	      Implemented in this way for brevity.
	 */
	private Author authorFromPayload(final Map<String, Object> payload) {
		final Map<String, Object> authorMap = (HashMap<String, Object>) payload.get("author");
        return Author.builder()
			.id(((Integer)authorMap.get("id")).longValue())
			.name(authorMap.get("name").toString())
			.age((Integer)authorMap.get("age"))
			.build();
	}
}
