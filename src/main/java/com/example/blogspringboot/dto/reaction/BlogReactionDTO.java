package com.example.blogspringboot.dto.reaction;

import com.example.blogspringboot.entity.ReactionType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogReactionDTO {
    private ReactionType reactionType;
    private Long blogId;
    private Long userId;
}
