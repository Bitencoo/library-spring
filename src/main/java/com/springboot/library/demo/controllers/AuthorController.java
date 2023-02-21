package com.springboot.library.demo.controllers;

import com.springboot.library.demo.entities.Author;
import com.springboot.library.demo.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        super();
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return new ResponseEntity<Author>(authorService.createAuthor(author), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        return new ResponseEntity<Author>(authorService.updateAuthor(author), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("{id}")
    public Author getAuthorById(@PathVariable("id") UUID id) {
        return authorService.getAuthorById(id);
    }

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable("id") UUID id) {
        authorService.deleteAuthor(id);
    }
}
