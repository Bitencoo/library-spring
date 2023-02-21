package com.springboot.library.demo.services;

import com.springboot.library.demo.entities.Book;
import com.springboot.library.demo.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(UUID bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book" + bookId.toString() + "not found!"));
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Book oldBook = bookRepository.findById(book.getId()).orElseThrow();
        BeanUtils.copyProperties(book, oldBook);
        return bookRepository.save(oldBook);
    }

    @Override
    public void deleteBook(UUID bookId) {
        bookRepository.deleteById(bookId);
    }
}
