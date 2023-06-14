package com.example.wikiProject.repository;

import com.example.wikiProject.model.Article;
import com.example.wikiProject.model.ArticleHistory;
import com.example.wikiProject.model.Category;
import com.example.wikiProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleHistoryRepository extends JpaRepository<ArticleHistory, Long> {
    List<ArticleHistory> findAllByArticle(Article article);

    List<Article> findByUser(User user);
}
