package com.springboot.library.demo.controllers;

import com.springboot.library.demo.entities.Book;
import com.springboot.library.demo.services.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.createBook(book), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable("id") UUID bookId) {
        return bookService.getBookById(bookId);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable("id") UUID bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping()
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.updateBook(book), HttpStatus.CREATED);
    }
}
