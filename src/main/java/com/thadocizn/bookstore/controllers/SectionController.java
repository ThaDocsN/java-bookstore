package com.thadocizn.bookstore.controllers;

import com.thadocizn.bookstore.model.Section;
import com.thadocizn.bookstore.repositories.SectionRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sections", produces = MediaType.APPLICATION_JSON_VALUE)
public class SectionController
{
    @Autowired
    SectionRepository sectionRepo;

    @ApiOperation(value = "Returns list of all sections.", response = List.class)
    @GetMapping(value = "")
    public List<Section> listAllSections()
    {
        return sectionRepo.findAll();
    }
}