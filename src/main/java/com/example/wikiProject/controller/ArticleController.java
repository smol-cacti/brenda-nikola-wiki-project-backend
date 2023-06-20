package com.example.wikiProject.controller;

import com.example.wikiProject.dto.ArticleDTO;
import com.example.wikiProject.dto.ArticlePostRequest;
import com.example.wikiProject.dto.RegisterRequest;
import com.example.wikiProject.service.ArticleService;
import com.example.wikiProject.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/articles")
@AllArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody ArticlePostRequest articlePostRequest) {
        articleService.save(articlePostRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllPosts() {
        return status(HttpStatus.OK).body(articleService.getAllArticles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getPost(@PathVariable Long id) {
        return status(HttpStatus.OK).body(articleService.getArticle(id));
    }

    @GetMapping("by-category/{id}")
    public ResponseEntity<List<ArticleDTO>> getPostsBySubreddit(Long id) {
        return status(HttpStatus.OK).body(articleService.getArticlesByCategory(id));
    }

    @GetMapping("by-user/{name}")
    public ResponseEntity<List<ArticleDTO>> getPostsByUsername(String username) {
        return status(HttpStatus.OK).body(articleService.getArticlesByUsername(username));
    }

}
