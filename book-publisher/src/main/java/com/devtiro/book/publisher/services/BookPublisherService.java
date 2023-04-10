package com.devtiro.book.publisher.services;

import com.devtiro.book.publisher.domain.Book;

/**
 * Publishes books.
 */
public interface BookPublisherService {

    void publish(Book book);

}
