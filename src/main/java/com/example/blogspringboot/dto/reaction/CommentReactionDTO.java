package com.example.blogspringboot.dto.reaction;

import com.example.blogspringboot.entity.ReactionType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
public class CommentReactionDTO {
    private ReactionType reactionType;
    private Long commentId;
    private Long userId;
    private OffsetDateTime updatedAt;
}
