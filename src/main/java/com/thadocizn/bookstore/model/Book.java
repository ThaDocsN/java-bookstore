package com.thadocizn.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookid;

    private String booktitle;
    private String ISBN;
    private int copy;

    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("books")
    private Section section;

    public Book() {
    }


}
