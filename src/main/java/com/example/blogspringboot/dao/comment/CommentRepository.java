package com.example.blogspringboot.dao.comment;

import com.example.blogspringboot.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CommentRepository extends JpaRepository<Comment, Long> {
}
