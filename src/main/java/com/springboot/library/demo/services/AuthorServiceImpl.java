package com.springboot.library.demo.services;

import com.springboot.library.demo.entities.Author;
import com.springboot.library.demo.repositories.AuthorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        super();
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        Author oldAuthor = authorRepository.findById(author.getId()).orElseThrow();
        BeanUtils.copyProperties(author, oldAuthor);
        return authorRepository.save(oldAuthor);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(UUID authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }

    @Override
    public void deleteAuthor(UUID authorId) {
        authorRepository.deleteById(authorId);
    }
}
