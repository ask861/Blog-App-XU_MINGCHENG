package com.example.blogapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	// ログイン画面表示
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	// ログイン処理
	@PostMapping("/login")
	public String doLogin() {
	    return "redirect:/blog/list";
	}
	 // ログアウト処理
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}