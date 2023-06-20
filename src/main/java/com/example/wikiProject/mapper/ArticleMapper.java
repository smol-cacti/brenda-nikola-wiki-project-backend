package com.example.wikiProject.mapper;
import com.example.wikiProject.dto.ArticleDTO;
import com.example.wikiProject.dto.ArticlePostRequest;
import com.example.wikiProject.model.Article;
import com.example.wikiProject.model.ArticleHistory;
import com.example.wikiProject.model.Category;
import com.example.wikiProject.model.User;
import com.example.wikiProject.repository.ArticleHistoryRepository;
import com.example.wikiProject.repository.CategoryRepository;
import com.example.wikiProject.service.AuthService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ArticleMapper {

    @Autowired
    private AuthService authService;
    @Autowired
    private ArticleHistoryRepository articleHistoryRepository;

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "user", source = "user")
    public abstract Article map(ArticlePostRequest articlePostRequest, User user);


    public abstract ArticleDTO mapToDto(Article article);

    //TODO article history stuff

    //Integer categoryCount(Article article) {
    //    return CategoryRepository.findByArticle(article).size();
    //}

    // TODO make work
    //Instant getDuration(Article article) {
    //    return java.time.Instant.now().minus(article.getCreatedDate());
    //}



}
