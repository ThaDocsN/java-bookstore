package com.thadocizn.bookstore.repositories;

import com.thadocizn.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String id);

    @Transactional
    @Modifying
    @Query(value = "SELECT b.booktitle, b.copy, b.isbn, a.firstname, a.lastname, s.name FROM bookstore.book b, bookstore.author a, bookstore.wrote w, bookstore.section s WHERE b.bookid = w.bookid AND a.authorid = w.authorid AND b.sectionid = s.sectionid", nativeQuery = true)
    List<Object[]> getAllBooks();

    @Transactional
    @Modifying
    @Query(value = "SELECT a.firstname, a.lastname, b.booktitle, b.copy, b.isbn, s.name FROM bookstore.book b, bookstore.author a, bookstore.wrote w, bookstore.section s WHERE b.bookid = w.bookid AND a.authorid = w.authorid AND b.sectionid = s.sectionid", nativeQuery = true)
    List<Object[]> getAllAuthors();

    @Transactional
    @Modifying
    @Query(value = "SELECT s.name, b.booktitle, a.firstname, a.lastname FROM bookstore.book b, bookstore.author a, bookstore.wrote w, bookstore.section s WHERE b.bookid = w.bookid AND a.authorid = w.authorid AND b.sectionid = s.sectionid", nativeQuery = true)
    List<Object[]> getAllSections();
}
