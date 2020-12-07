package com.codeup.blogspring.repos;

import com.codeup.blogspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
