package com.example.blogspringboot.service.comment;

import com.example.blogspringboot.dto.comment.CommentCreateDTO;
import com.example.blogspringboot.entity.Comment;

public interface CommentService {
    Comment createComment(CommentCreateDTO dto) throws Exception;

    Comment updateComment(CommentCreateDTO dto) throws Exception;

    void deleteComment(Long id) throws Exception;

    Comment getComment(Long id) throws Exception;
}
