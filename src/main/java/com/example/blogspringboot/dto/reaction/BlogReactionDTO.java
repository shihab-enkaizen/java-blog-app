package com.example.blogspringboot.dto.reaction;

import com.example.blogspringboot.entity.ReactionType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class BlogReactionDTO {
    private ReactionType reactionType;
    private Long blogId;
    private Long userId;
    private OffsetDateTime updatedAt;

}
