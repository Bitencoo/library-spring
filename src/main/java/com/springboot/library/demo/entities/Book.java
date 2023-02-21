package com.springboot.library.demo.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@JsonSerialize
@Data
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = false, length = 255)
    private String title;
    @Column(nullable = true, unique = false, length = 255)
    private String subtitle;
    @Column(nullable = false, unique = false, length = 100)
    private String country;
    @Column(nullable = false, unique = false, length = 255)
    private String publishingCompany;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private Set<Author> authors = new HashSet<>();
    @Column(nullable = true)
    private String datePublished;
}
