package com.example.wikiProject.service;
import com.example.wikiProject.dto.ArticleDTO;
import com.example.wikiProject.dto.ArticlePostRequest;
import com.example.wikiProject.exceptions.ArticleNotFoundException;
import com.example.wikiProject.exceptions.CategoryNotFoundException;
import com.example.wikiProject.mapper.ArticleMapper;
import com.example.wikiProject.model.Article;
import com.example.wikiProject.model.Category;
import com.example.wikiProject.model.User;
import com.example.wikiProject.repository.ArticleHistoryRepository;
import com.example.wikiProject.repository.ArticleRepository;
import com.example.wikiProject.repository.CategoryRepository;
import com.example.wikiProject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class ArticleService {


    private final ArticleRepository articleRepository;
    private final ArticleHistoryRepository articleHistoryRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final ArticleMapper articleMapper;

    public void save(ArticlePostRequest articlePostRequest) {
        articleRepository.save(articleMapper.map(articlePostRequest, authService.getCurrentUser()));

    }

    @Transactional(readOnly = true)
    public List<ArticleDTO> getArticlesByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId.toString()));
        List<Article> articles = category.getArticles();
        return articles.stream().map(articleMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<ArticleDTO> getArticlesByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        List<Article> articles = articleRepository.findByUser(user);
        return articles.stream().map(articleMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public ArticleDTO getArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id.toString()));
        return articleMapper.mapToDto(article);
    }

    @Transactional(readOnly = true)
    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(articleMapper::mapToDto).collect(toList());
    }
}
