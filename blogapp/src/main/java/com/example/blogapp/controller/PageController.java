package com.example.blogapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.repository.BlogRepository;

@Controller
public class PageController {
	 @Autowired
	    private BlogRepository blogRepository;
//    @GetMapping("/")
//    public String index() {
//        return "login";
//    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping("/register")
//    public String register() {
//        return "register";
//    }

    @GetMapping("/blogs")
    public String blogList() {
        return "blog-list";
    }

    @GetMapping("/blogs/new")
    public String blogForm() {
        return "blog-form";
    }

    @GetMapping("/blog/edit/{id}")
    public String blogEdit(@PathVariable Long id, Model model) {
    	Optional<Blog> blogData = blogRepository.findById(id);
    	model.addAttribute("blog", blogData);
    	return "blog-edit";
    }
   
}