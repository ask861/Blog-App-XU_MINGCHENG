package com.example.blogapp.controller;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.repository.BlogRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    // ブログ一覧表示
    @GetMapping("/blog/list")
    public String blogList(Model model) {
        model.addAttribute("blogList", blogRepository.findAll());
        return "blog-list";
    }
    
    // ブログ登録画面表示
    @GetMapping("/blog/form")
    public String showBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog-form";
    }

    // ブログ登録処理
    @PostMapping("/blog/save")
    public String saveBlog(@ModelAttribute Blog blog) {

        blogRepository.save(blog);

        return "redirect:/blog/list";
    }

    // ブログ更新処理
    @PostMapping("/blog/update")
    public String updateBlog(@ModelAttribute Blog blog) {

        blogRepository.save(blog);

        return "redirect:/blog/list";
    }

    // ブログ削除処理
    @GetMapping("/blog/delete/{id}")
    public String deleteBlog(@PathVariable Long id) {

        blogRepository.deleteById(id);

        return "redirect:/blog/list";
    }
}