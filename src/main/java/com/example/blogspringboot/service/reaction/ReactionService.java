package com.example.blogspringboot.service.reaction;

import com.example.blogspringboot.dto.comment.CommentCreateDTO;
import com.example.blogspringboot.dto.reaction.BlogReactionDTO;
import com.example.blogspringboot.dto.reaction.CommentReactionDTO;
import com.example.blogspringboot.entity.BlogReaction;
import com.example.blogspringboot.entity.CommentReaction;

public interface ReactionService {
    BlogReaction blogReaction(BlogReactionDTO dto) throws Exception;
    void deleteBlogReaction(Long id) throws Exception;
    CommentReaction commentReaction(CommentReactionDTO dto) throws Exception;
    void deleteCommentReaction(Long id) throws Exception;

}
