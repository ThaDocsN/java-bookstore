package com.thadocizn.bookstore.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "wrote")
public class Wrote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long bookid;

    private long authorid;

    public Wrote() {
    }

}