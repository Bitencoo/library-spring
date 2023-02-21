package com.springboot.library.demo.services;

import com.springboot.library.demo.entities.Book;
import com.springboot.library.demo.repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(UUID bookId);
    Book createBook(Book book);
    Book updateBook(Book book);
    void deleteBook(UUID bookId);
}
