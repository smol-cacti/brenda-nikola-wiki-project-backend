package com.example.wikiProject.repository;

import com.example.wikiProject.model.Post;
import com.example.wikiProject.model.Subreddit;
import com.example.wikiProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
