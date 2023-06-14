package com.example.wikiProject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private String articleName;
    private String url;
    @Lob
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;
    private Instant createdDate;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories")
    private List<Category> categories;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "articleHistory")
    private List<ArticleHistory> articleHistory;
}
