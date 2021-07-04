package com.thadocizn.bookstore.controllers;

import com.thadocizn.bookstore.model.User;
import com.thadocizn.bookstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class ManagerController {

    @Autowired
    UserRepository userRepo;

    @GetMapping(value = "/users")
    public List<User> listAllUsers() {
        return userRepo.findAll();
    }

    @SuppressWarnings("Duplicates")
    @DeleteMapping(value = "/user")
    public User deleteUserById(@PathVariable long id) {
        Optional<User> foundUser = userRepo.findById(id);
        if (foundUser.isPresent()) {
            userRepo.deleteById(id);
            return foundUser.get();
        } else {
            return null;
        }
    }

    @PostMapping("/user")
    public User addNewUser(@RequestBody User user) throws URISyntaxException {
        return userRepo.save(user);
    }
}