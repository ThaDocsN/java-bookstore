package com.thadocizn.bookstore.repositories;

import com.thadocizn.bookstore.model.Wrote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WroteRepository extends JpaRepository<Wrote, Long> {
}