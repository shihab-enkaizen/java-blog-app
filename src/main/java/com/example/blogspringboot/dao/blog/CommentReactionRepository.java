package com.example.blogspringboot.dao.blog;

import com.example.blogspringboot.entity.Comment;
import com.example.blogspringboot.entity.CommentReaction;
import com.example.blogspringboot.entity.ProUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentReactionRepository extends JpaRepository<CommentReaction, Long> {
    CommentReaction findAllByCommentAndUsers(Comment comment, ProUser user);
}
