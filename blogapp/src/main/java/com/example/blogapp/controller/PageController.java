package com.example.blogapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/blogs")
    public String blogList() {
        return "blog-list";
    }

    @GetMapping("/blogs/new")
    public String blogForm() {
        return "blog-form";
    }

    @GetMapping("/blogs/edit")
    public String blogEdit() {
        return "blog-edit";
    }
}