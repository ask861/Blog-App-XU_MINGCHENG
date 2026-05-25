package com.example.blogapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {

	 // 主キー
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ブログタイトル
    private String title;
    
    // ブログ内容
    @Column(length = 1000)
    private String content;
    
    // ID取得
    public Long getId() {
        return id;
    }
    
    // ID設定
    public void setId(Long id) {
        this.id = id;
    }
    
    // タイトル取得
    public String getTitle() {
        return title;
    }

    // タイトル設定
    public void setTitle(String title) {
        this.title = title;
    }
    
    // 内容取得
    public String getContent() {
        return content;
    }
    
    // 内容設定
    public void setContent(String content) {
        this.content = content;
    }

    // コンストラクタ
	public Blog(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	 // デフォルトコンストラクタ
	public Blog() {
		super();
	}
}