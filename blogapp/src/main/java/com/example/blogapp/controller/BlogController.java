package com.example.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.repository.BlogRepository;

@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blog")
    public String blogForm(Model model) {

        model.addAttribute("blog", new Blog());

        return "blog-form";
    }

    @PostMapping("/blog/save")
    public String saveBlog(Blog blog) {

        blogRepository.save(blog);

        return "redirect:/blog/list";
    }

    @GetMapping("/blog/list")
    public String blogList(Model model) {

        List<Blog> blogList = blogRepository.findAll();

        model.addAttribute("blogList", blogList);

        return "blog-list";
    }
}