package com.example.wikiProject.service;
import com.example.wikiProject.dto.ArticleRequest;
import com.example.wikiProject.exceptions.ArticleNotFoundException;
import com.example.wikiProject.exceptions.CategoryNotFoundException;
import com.example.wikiProject.exceptions.SpringWikiException;
import com.example.wikiProject.mapper.ArticleMapper;
import com.example.wikiProject.model.Article;
import com.example.wikiProject.model.Category;
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

    public void save(ArticleRequest articleRequest) {
        articleRepository.save(articleMapper.map(articleRequest, authService.getCurrentUser()));

    }

    @Transactional(readOnly = true)
    public List<Article> getArticlesByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId.toString()));
        List<Article> articles = articleRepository.findAllByCategory(category);
        return articles.stream().map(articleMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<ArticleResponse> getArticlesByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return articleRepository.findByUser(user)
                .stream()
                .map(articleMapper::mapToDto)
                .collect(toList());
    }

}
