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
public class RegisterControllerTest {

    // 画面へのリクエストを疑似的に実行する
    @Autowired
    private MockMvc mockMvc;

    // ユーザー登録画面初期表示テスト
    @Test
    public void testRegisterPageDisplay() throws Exception {
        // /registerへGETリクエストを実行する
        mockMvc.perform(get("/register"))
                // 正常に画面が表示されることを確認する
                .andExpect(status().isOk())
                // register.htmlが表示されることを確認する
                .andExpect(view().name("register"));
    }

    // ユーザー登録成功テスト
    @Test
    public void testRegisterSuccess() throws Exception {
        // 登録情報を指定してPOSTリクエストを実行する
        mockMvc.perform(post("/register")
                .param("username", "testuser")
                .param("email", "testuser@gmail.com")
                .param("password", "test1234"))
                // 登録成功後、ログイン画面などへリダイレクトされることを確認する
                .andExpect(status().is3xxRedirection());
    }

    // ユーザー名未入力テスト
    @Test
    public void testRegisterFailureByEmptyUsername() throws Exception {
        // usernameを空欄にしてPOSTリクエストを実行する
        mockMvc.perform(post("/register")
                .param("username", "")
                .param("email", "testuser@gmail.com")
                .param("password", "test1234"))
                // 登録画面に戻ることを確認する
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    // メールアドレス未入力テスト
    @Test
    public void testRegisterFailureByEmptyEmail() throws Exception {
        // emailを空欄にしてPOSTリクエストを実行する
        mockMvc.perform(post("/register")
                .param("username", "testuser")
                .param("email", "")
                .param("password", "test1234"))
                // 登録画面に戻ることを確認する
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    // パスワード未入力テスト
    @Test
    public void testRegisterFailureByEmptyPassword() throws Exception {
        // passwordを空欄にしてPOSTリクエストを実行する
        mockMvc.perform(post("/register")
                .param("username", "testuser")
                .param("email", "testuser@gmail.com")
                .param("password", ""))
                // 登録画面に戻ることを確認する
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    // 入力欄表示確認テスト
    @Test
    public void testRegisterFormDisplay() throws Exception {
        // /registerへGETリクエストを実行する
        mockMvc.perform(get("/register"))
                // 正常に表示されることを確認する
                .andExpect(status().isOk())
                // username入力欄があることを確認する
                .andExpect(content().string(containsString("username")))
                // email入力欄があることを確認する
                .andExpect(content().string(containsString("email")))
                // password入力欄があることを確認する
                .andExpect(content().string(containsString("password")));
    }
}