package com.example.wikiProject.mapper;
import com.example.wikiProject.dto.AddArticleToCategory;
import com.example.wikiProject.dto.ArticleRequest;
import com.example.wikiProject.model.Article;
import com.example.wikiProject.model.User;
import com.example.wikiProject.repository.ArticleHistoryRepository;
import com.example.wikiProject.repository.CategoryRepository;
import com.example.wikiProject.service.AuthService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Optional;
@Mapper(componentModel = "spring")
public abstract class ArticleMapper {

    @Autowired
    private AuthService authService;
    @Autowired
    private ArticleHistoryRepository articleHistoryRepository;

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "articleName", source = "articleRequest.articleName")
    @Mapping(target = "description", source = "articleRequest.description")
    @Mapping(target = "user", source = "user")
    public abstract Article map(ArticleRequest articleRequest, User user);

    @Mapping(target = "id", source = "articleId")
    @Mapping(target = "subredditName", source = "subreddit.name")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    public abstract AddArticleToCategory mapToDto(Article article);

    //TODO article history stuff

    Integer categoryCount(Article article) {
        return CategoryRepository.findByArticle(article).size();
    }

    // TODO make work
    //Instant getDuration(Article article) {
    //    return java.time.Instant.now().minus(article.getCreatedDate());
    //}



}
