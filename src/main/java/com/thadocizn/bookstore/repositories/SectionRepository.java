package com.thadocizn.bookstore.repositories;

import com.thadocizn.bookstore.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
