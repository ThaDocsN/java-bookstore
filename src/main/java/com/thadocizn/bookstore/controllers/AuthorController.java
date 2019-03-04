package com.thadocizn.bookstore.controllers;

import com.thadocizn.bookstore.model.Author;
import com.thadocizn.bookstore.repositories.AuthorRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController
{
    @Autowired
    AuthorRepository authorRepo;

    @ApiOperation(value = "Returns list of all authors.", response = List.class)
    @GetMapping(value = "")
    public List<Author> listAllAuthors()
    {
        return authorRepo.findAll();
    }
}