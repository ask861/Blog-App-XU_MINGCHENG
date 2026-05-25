package com.example.blogapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogapp.entity.Blog;

public interface BlogRepository
        extends JpaRepository<Blog, Long> {

    // タイトル検索機能
    List<Blog> findByTitleContaining(String keyword);

}