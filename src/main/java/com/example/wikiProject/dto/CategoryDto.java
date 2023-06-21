package com.example.wikiProject.dto;
import com.example.wikiProject.model.Article;
import com.example.wikiProject.model.ArticleHistory;
import com.example.wikiProject.model.Category;
import com.example.wikiProject.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private Long categoryId;
    private String name;

    List<Article> articles;
    private Integer numberOfArticles;
    private String description;


}
