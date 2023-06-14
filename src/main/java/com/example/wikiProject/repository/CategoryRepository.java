package com.example.wikiProject.repository;

import com.example.wikiProject.model.Article;
import com.example.wikiProject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String category);

    Optional<Category> findByArticle(Article article);
}
