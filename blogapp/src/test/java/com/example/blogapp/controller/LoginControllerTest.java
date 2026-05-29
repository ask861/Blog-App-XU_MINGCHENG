package com.example.blogapp.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// Spring Boot全体を起動してテストを行う
@SpringBootTest
// MockMvcを使用できるようにする
@AutoConfigureMockMvc
public class LoginControllerTest {

    // 画面へのGET/POSTリクエストを疑似的に実行するためのオブジェクト
    @Autowired
    private MockMvc mockMvc;

    // No.1 ログイン画面初期表示テスト
    @Test
    public void testLoginPageDisplay() throws Exception {
        // /loginへGETリクエストを実行する
        mockMvc.perform(get("/login"))
                // ステータスコード200が返ることを確認する
                .andExpect(status().isOk())
                // login.htmlが表示されることを確認する
                .andExpect(view().name("login"));
    }

    // No.2 正常ログインテスト
    @Test
    public void testLoginSuccess() throws Exception {
        // 正しいメールアドレスとパスワードでPOSTリクエストを実行する
        mockMvc.perform(post("/login")
                .param("email", "genasu077@gmail.com")
                .param("password", "Gen4225671"))
                // ログイン成功後、リダイレクトされることを確認する
                .andExpect(status().is3xxRedirection());
    }

    // No.3 未登録メールアドレステスト
    @Test
    public void testLoginFailureByUnknownEmail() throws Exception {
        // 未登録メールアドレスでPOSTリクエストを実行する
        mockMvc.perform(post("/login")
                .param("email", "test@test.com")
                .param("password", "Gen4225671"))
                // ログイン画面に戻ることを確認する
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    // No.4 パスワード誤入力テスト
    @Test
    public void testLoginFailureByWrongPassword() throws Exception {
        // 正しいメールアドレスと誤ったパスワードでPOSTリクエストを実行する
        mockMvc.perform(post("/login")
                .param("email", "genasu077@gmail.com")
                .param("password", "error123"))
                // ログイン失敗となり、ログイン画面に戻ることを確認する
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    // No.5 入力欄表示確認テスト
    @Test
    public void testLoginFormDisplay() throws Exception {
        // /loginへGETリクエストを実行する
        mockMvc.perform(get("/login"))
                // ログイン画面が正常に表示されることを確認する
                .andExpect(status().isOk())
                // メールアドレス入力欄があることを確認する
                .andExpect(content().string(containsString("email")))
                // パスワード入力欄があることを確認する
                .andExpect(content().string(containsString("password")));
    }
}