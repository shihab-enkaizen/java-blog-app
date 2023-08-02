package com.example.blogspringboot.service.reaction;

import com.example.blogspringboot.dto.reaction.BlogReactionDTO;
import com.example.blogspringboot.entity.BlogReaction;

public interface ReactionService {
    BlogReaction blogReaction(BlogReactionDTO dto);
}
