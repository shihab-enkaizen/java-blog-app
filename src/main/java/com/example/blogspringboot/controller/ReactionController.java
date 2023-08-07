package com.example.blogspringboot.controller;

import com.example.blogspringboot.dto.reaction.BlogReactionDTO;
import com.example.blogspringboot.dto.reaction.CommentReactionDTO;
import com.example.blogspringboot.dto.reaction.ReactionResponseDTO;
import com.example.blogspringboot.entity.BlogReaction;
import com.example.blogspringboot.entity.CommentReaction;
import com.example.blogspringboot.service.reaction.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reactions")
public class ReactionController {
    private final ReactionService reactionService;

    @PostMapping("/blog-reaction")
    public BlogReaction createBlogReaction(@RequestBody BlogReactionDTO dto) throws Exception {
        return reactionService.blogReaction(dto);
    }

    @PutMapping("/blog-reaction/{blogId}")
    public BlogReaction updateBlogReaction(@PathVariable("blogId") Long id, @RequestBody BlogReactionDTO dto) throws Exception {
        dto.setBlogId(id);
        dto.setUpdatedAt(OffsetDateTime.now());
        return reactionService.blogReaction(dto);
    }

    @DeleteMapping("/blog-reaction/{blogId}")
    public void deleteBlogReaction(@PathVariable("blogId") Long id) throws Exception {
        reactionService.deleteBlogReaction(id);
    }

    @PostMapping("/comment-reaction")
    public CommentReaction createCommentReaction(@RequestBody CommentReactionDTO dto) throws Exception {
        return reactionService.commentReaction(dto);
    }

    @PutMapping("/comment-reaction")
    public CommentReaction updateCommentReaction(@RequestBody CommentReactionDTO dto) throws Exception {
        dto.setUpdatedAt(OffsetDateTime.now());
        return reactionService.commentReaction(dto);
    }

    @DeleteMapping("/comment-reaction/{id}")
    public void deleteCommentReaction(@PathVariable Long id) throws Exception {
        reactionService.deleteCommentReaction(id);
    }
}
