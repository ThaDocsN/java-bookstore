package com.thadocizn.bookstore.services;

import com.thadocizn.bookstore.model.User;

import java.util.List;
public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}