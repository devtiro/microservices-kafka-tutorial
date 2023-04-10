package com.devtiro.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BookPersistenceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookPersistenceApplication.class, args);
	}
}
