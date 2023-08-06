package com.example.blogspringboot.dto.reaction;

import com.example.blogspringboot.entity.Blog;
import com.example.blogspringboot.entity.BlogReaction;
import com.example.blogspringboot.entity.ProUser;
import com.example.blogspringboot.entity.ReactionType;
import lombok.Data;

@Data
public class ReactionResponseDTO {
    private Blog blog;
    private ProUser user;
    private ReactionType reactionType;

    public ReactionResponseDTO(BlogReaction blogReaction) {
        this.blog = blogReaction.getBlog();
        this.user = blogReaction.getUsers();
        this.reactionType = blogReaction.getReaction();
    }
}
