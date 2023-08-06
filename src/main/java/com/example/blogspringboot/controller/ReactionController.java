package com.example.blogspringboot.controller;

import com.example.blogspringboot.dto.reaction.BlogReactionDTO;
import com.example.blogspringboot.dto.reaction.ReactionResponseDTO;
import com.example.blogspringboot.entity.BlogReaction;
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

    @PostMapping("/blog-reaction/{blogId}")
    public BlogReaction createBlog(@PathVariable("blogId") Long id, @RequestBody BlogReactionDTO dto) throws Exception {
        dto.setBlogId(id);
        return reactionService.blogReaction(dto);
    }

    @PutMapping("/blog-reaction/{blogId}")
    public BlogReaction updateBlog(@PathVariable("blogId") Long id, @RequestBody BlogReactionDTO dto) throws Exception {
        dto.setBlogId(id);
        dto.setUpdatedAt(OffsetDateTime.now());
        return reactionService.blogReaction(dto);
    }

    @DeleteMapping("/blog-reaction/{blogId}")
    public void deleteBlog(@PathVariable("blogId") Long id) throws Exception {
        reactionService.deleteBlogReaction(id);
    }
}
