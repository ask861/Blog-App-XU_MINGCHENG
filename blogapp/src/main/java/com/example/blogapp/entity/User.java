package com.example.blogapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	
	// 主キー
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ユーザー名
    private String name;
    // メールアドレス
    private String email;
    // パスワード
    private String password;
    

    public User() {
		super();
	}
    
    // デフォルトコンストラクタ
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	 // ID取得
	public Long getId() {
        return id;
    }
	// 名前取得
    public String getName() {
        return name;
    }
    // メールアドレス取得
    public String getEmail() {
        return email;
    }
    // パスワード取得
    public String getPassword() {
        return password;
    }
    // ID設定
    public void setId(Long id) {
        this.id = id;
    }
    // 名前設定
    public void setName(String name) {
        this.name = name;
    }
    // メールアドレス設定
    public void setEmail(String email) {
        this.email = email;
    }
    // パスワード設定
    public void setPassword(String password) {
        this.password = password;
    }
}