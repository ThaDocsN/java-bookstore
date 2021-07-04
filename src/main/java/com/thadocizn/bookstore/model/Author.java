package com.thadocizn.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorId;

    private String lastName;
    private String firstName;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnoreProperties("authors")
    private Set<Book> books = new HashSet<>();

    public Author() {
    }
}
