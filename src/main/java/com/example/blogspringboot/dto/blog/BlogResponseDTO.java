package com.example.blogspringboot.dto.blog;

import com.example.blogspringboot.entity.Blog;
import com.example.blogspringboot.entity.BlogReaction;
import com.example.blogspringboot.entity.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class BlogResponseDTO {
    private String title;
    private Status status;
    private String description;
    private OffsetDateTime publishDate;
    private Long userID;

    public BlogResponseDTO(Blog blog) {
        this.title = blog.getTitle();
        this.status = blog.getStatus();
        this.description = blog.getDescription();
        this.publishDate = blog.getPublishDate();
        this.userID = blog.getUser().getId();
    }
}
