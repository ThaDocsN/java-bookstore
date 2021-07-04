package com.thadocizn.bookstore.repositories;

import com.thadocizn.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
