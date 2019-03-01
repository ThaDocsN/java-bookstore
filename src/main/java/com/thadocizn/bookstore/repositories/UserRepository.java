package com.thadocizn.bookstore.repositories;

import com.thadocizn.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
