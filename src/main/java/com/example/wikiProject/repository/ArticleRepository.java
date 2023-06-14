package com.example.wikiProject.repository;

import com.example.wikiProject.model.Article;
import com.example.wikiProject.model.Category;
import com.example.wikiProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    //List<Article> findAllByCategory(Category category); call category.getArticles()
    // instead when needed,
    // spring cannot create the bean for this

    List<Article> findByUser(User user);
}
