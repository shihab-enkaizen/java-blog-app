package com.example.blogspringboot.dto.comment;

import com.example.blogspringboot.entity.Blog;
import com.example.blogspringboot.entity.Comment;
import com.example.blogspringboot.entity.ProUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class CommentResponseDTO {
    private String comment;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Blog blog;
    private ProUser user;

    public CommentResponseDTO(Comment comment) {
        this.comment = comment.getComment();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
        this.blog = comment.getBlog();
        this.user = comment.getUser();
    }
}
