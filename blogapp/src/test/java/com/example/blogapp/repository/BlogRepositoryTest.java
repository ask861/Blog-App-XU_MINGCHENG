package com.example.blogapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.blogapp.entity.Blog;

// JPA関連のテストを行うためのアノテーション
@DataJpaTest
public class BlogRepositoryTest {

    // BlogRepositoryを使用する
    @Autowired
    private BlogRepository blogRepository;

    // タイトル検索テスト
    @Test
    public void testFindByTitleContaining() {

        // テスト用のブログデータを作成する
        Blog blog = new Blog();
        blog.setTitle("Spring Boot学習");
        blog.setContent("練習用のテスト");

        // 作成したブログデータをDBに保存する
        blogRepository.save(blog);

        // タイトルに「Spring」を含むブログを検索する
        List<Blog> result =
                blogRepository.findByTitleContaining("Spring");

        // 検索結果が空ではないことを確認する
        assertThat(result).isNotEmpty();

        // 検索結果のタイトルに「Spring」が含まれていることを確認する
        assertThat(result.get(0).getTitle()).contains("Spring");
    }

    // ブログ登録テスト
    @Test
    public void testSaveBlog() {

        // テスト用のブログデータを作成する
        Blog blog = new Blog();
        blog.setTitle("テストタイトル");
        blog.setContent("テスト内容");

        // ブログデータを保存する
        Blog savedBlog = blogRepository.save(blog);

        // 保存後、IDが自動採番されていることを確認する
        assertThat(savedBlog.getId()).isNotNull();

        // タイトルが正しく保存されていることを確認する
        assertThat(savedBlog.getTitle()).isEqualTo("テストタイトル");

        // 内容が正しく保存されていることを確認する
        assertThat(savedBlog.getContent()).isEqualTo("テスト内容");
    }
}