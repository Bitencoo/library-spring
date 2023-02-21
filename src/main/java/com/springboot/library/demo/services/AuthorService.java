package com.springboot.library.demo.services;

import com.springboot.library.demo.entities.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    Author createAuthor(Author author);
    Author updateAuthor(Author author);
    List<Author> getAllAuthors();
    Author getAuthorById(UUID authorId);
    void deleteAuthor(UUID authorId);
}
