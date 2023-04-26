package com.example.wikiProject.repository;

import com.example.wikiProject.model.Comment;
import com.example.wikiProject.model.Post;
import com.example.wikiProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
