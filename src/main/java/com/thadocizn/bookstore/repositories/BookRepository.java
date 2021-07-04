package com.thadocizn.bookstore.repositories;

import com.thadocizn.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO bookstore.wrote (bookid, authorid) VALUES (:bookid, :authorid)", nativeQuery = true)
    void addBookAuthorRelation(long bookid, long authorid);
}
