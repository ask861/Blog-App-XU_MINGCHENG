package com.example.blogapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogapp.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {


}