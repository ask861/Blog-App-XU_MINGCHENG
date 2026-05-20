package com.example.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogapp.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
