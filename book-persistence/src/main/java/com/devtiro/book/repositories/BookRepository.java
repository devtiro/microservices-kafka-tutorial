package com.devtiro.book.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.devtiro.book.domain.Book;

public interface BookRepository extends CrudRepository<Book, String>,
        PagingAndSortingRepository<Book, String> {
}
