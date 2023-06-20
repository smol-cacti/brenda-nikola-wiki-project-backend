package com.example.wikiProject.dto;
import com.example.wikiProject.model.ArticleHistory;
import com.example.wikiProject.model.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePostRequest {
    private Long articleId;
    private String articleName;
    @NotBlank(message = "Article Name cannot be empty or Null")
    private String url;
    private String description;
    List<Category> categories;
    List<ArticleHistory> articleHistory;
}
