package com.example.blogspringboot.dto.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class CommentCreateDTO {
    private Long id;
    private String comment;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Long blogId;
    private Long userId;
}
