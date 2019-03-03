package com.thadocizn.bookstore.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long selectionId;

    private String Name;

    public Section() {
    }

}
