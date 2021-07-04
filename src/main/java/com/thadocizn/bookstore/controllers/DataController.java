package com.thadocizn.bookstore.controllers;

import com.thadocizn.bookstore.model.Book;
import com.thadocizn.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/data/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {
    @Autowired
    private BookRepository bookRepo;

    @PutMapping("/books/{bookid}")
    public Book updateBookById(@RequestBody Book newBook, @PathVariable long bookid) throws URISyntaxException {
       Optional<Book> updateBook = bookRepo.findById(bookid);
        if (updateBook.isPresent()) {
            newBook.setBookid(bookid);
            return newBook;
        }
        return null;
    }

    @PostMapping("/books/{bookid}/authors/{authorid}")
    public String addBookAuthorRelation(@PathVariable("bookid") long bookid, @PathVariable("authorid") long authorid) {
        bookRepo.addBookAuthorRelation(bookid, authorid);
        return "Added book " + bookid + "to author " + authorid;
    }

    @DeleteMapping("/books/{bookid}")
    public Book deleteBookById(@PathVariable long bookid) {
        var foundBook = bookRepo.findById(bookid);
        if (foundBook.isPresent()) {
            bookRepo.deleteById(bookid);
            return (Book) foundBook.get();
        }
        return null;
    }
}