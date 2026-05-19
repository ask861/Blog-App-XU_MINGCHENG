package com.example.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.blogapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}