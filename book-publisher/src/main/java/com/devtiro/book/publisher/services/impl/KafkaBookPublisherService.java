package com.devtiro.book.publisher.services.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.devtiro.book.publisher.config.KafkaConfigProps;
import com.devtiro.book.publisher.domain.Book;
import com.devtiro.book.publisher.exceptions.BookPublishException;
import com.devtiro.book.publisher.services.BookPublisherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Publishes books to a Kafka topic.
 */
@Service
public class KafkaBookPublisherService implements BookPublisherService {

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaConfigProps kafkaConfigProps;

    public KafkaBookPublisherService(
            final ObjectMapper objectMapper,
            final KafkaTemplate<String, String> kafkaTemplate,
            final KafkaConfigProps kafkaConfigProps) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigProps = kafkaConfigProps;
    }

    @Override
    public void publish(final Book book) {
        try {
            final String payload = objectMapper.writeValueAsString(book);
            kafkaTemplate.send(kafkaConfigProps.getTopic(), payload);
        } catch (final JsonProcessingException ex) {
            throw new BookPublishException("Unable to publish book", ex, book);
        }
    }

}
