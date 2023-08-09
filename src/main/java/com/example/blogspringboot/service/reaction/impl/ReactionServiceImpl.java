package com.example.blogspringboot.service.reaction.impl;

import com.example.blogspringboot.BlogApplication;
import com.example.blogspringboot.dao.blog.BlogReactionRepository;
import com.example.blogspringboot.dao.blog.CommentReactionRepository;
import com.example.blogspringboot.dto.comment.CommentCreateDTO;
import com.example.blogspringboot.dto.reaction.BlogReactionDTO;
import com.example.blogspringboot.dto.reaction.CommentReactionDTO;
import com.example.blogspringboot.entity.*;
import com.example.blogspringboot.service.blog.BlogService;
import com.example.blogspringboot.service.comment.CommentService;
import com.example.blogspringboot.service.reaction.ReactionService;
import com.example.blogspringboot.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {
    private final BlogService blogService;
    private final UserService userService;
    private final CommentService commentService;
    private final CommentReactionRepository commentReactionRepository;
    private final BlogReactionRepository repository;

    @Override
    public BlogReaction blogReaction(BlogReactionDTO dto) throws Exception {
        Blog blog = blogService.getBlog(dto.getBlogId());
        ProUser user = userService.getUser(dto.getUserId());
        BlogReaction blogReaction;

        if(user.isActive()) {
            blogReaction = isExistedReaction(blog, user);
            if(blogReaction == null) {
                blogReaction = new BlogReaction();
            }

            if(dto.getUpdatedAt() != null) {
                blogReaction.setUpdatedAt(dto.getUpdatedAt());
            }

            blogReaction.setReaction(dto.getReactionType());
            blogReaction.setBlog(blog);
            blogReaction.setUsers(user);
            blogReaction.setCreatedAt(OffsetDateTime.now());
            return repository.save(blogReaction);
        }else{
            throw new Exception("User is not active");
        }
    }

    private BlogReaction isExistedReaction(Blog blog, ProUser user) {
        return repository.findAllByBlogAndUsers(blog, user);
    }

    private CommentReaction isExistedReaction(Comment comment, ProUser user) {
        return commentReactionRepository.findAllByCommentAndUsers(comment, user);
    }

    @Override
    public void deleteBlogReaction(Long id) throws Exception {
        BlogReaction blogReaction = repository.findById(id).orElse(null);
        if (blogReaction != null) {
            repository.delete(blogReaction);
        }else{
            throw new Exception("BlogReaction not found");
        }

    }

    @Override
    public CommentReaction commentReaction(CommentReactionDTO dto) throws Exception {
        Comment comment = commentService.getComment(dto.getCommentId());
        ProUser user = userService.getUser(dto.getUserId());
        CommentReaction commentReaction;

        if(user.isActive()) {
            commentReaction = isExistedReaction(comment, user);
            if(commentReaction == null) {
                commentReaction = new CommentReaction();
            }

            if(dto.getUpdatedAt() != null) {
                commentReaction.setUpdatedAt(dto.getUpdatedAt());
            }

            commentReaction.setReaction(dto.getReactionType());
            commentReaction.setComment(comment);
            commentReaction.setUsers(user);
            commentReaction.setCreatedAt(OffsetDateTime.now());
            return commentReactionRepository.save(commentReaction);
        }else{
            throw new Exception("User is not active");
        }
    }

    @Override
    public void deleteCommentReaction(Long id) throws Exception {
        CommentReaction commentReaction = commentReactionRepository.findById(id).orElse(null);
        if (commentReaction != null) {
            commentReactionRepository.delete(commentReaction);
        }else{
            throw new Exception("CommentReaction not found");
        }
    }
}
