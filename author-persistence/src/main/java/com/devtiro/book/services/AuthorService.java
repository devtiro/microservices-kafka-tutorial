package com.devtiro.book.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devtiro.book.domain.Author;

public interface AuthorService {
    Author save(Author book);
    Page<Author> listAuthors(Pageable pageable);
}
