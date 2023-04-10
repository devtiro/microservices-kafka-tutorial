package com.devtiro.book.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookPublisherApplication.class, args);
	}

}
