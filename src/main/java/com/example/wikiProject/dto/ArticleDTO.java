package com.example.wikiProject.dto;
import com.example.wikiProject.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ArticleDTO {
    private Long articleId;
    private String articleName;
    private String url;
    private String description;
    private User user;

    private Instant createdDate;
}
