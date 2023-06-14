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
public class ArticleHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleHistoryId;
    private String articleName;
    private String url;
    @Lob
    private String description;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    private Instant createdDate;
    private Long changedBytes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articleId", referencedColumnName = "articleId")
    private Article article;

}
