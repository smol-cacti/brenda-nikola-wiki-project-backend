package com.example.wikiProject.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePostRequest {
    private Long articleId;
    private String articleName;
    @NotBlank(message = "Article Name cannot be empty or Null")
    private String url;
    private String description;
}
