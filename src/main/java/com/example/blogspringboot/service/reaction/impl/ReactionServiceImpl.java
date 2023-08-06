package com.example.blogspringboot.service.reaction.impl;

import com.example.blogspringboot.BlogApplication;
import com.example.blogspringboot.dao.blog.BlogReactionRepository;
import com.example.blogspringboot.dto.reaction.BlogReactionDTO;
import com.example.blogspringboot.entity.Blog;
import com.example.blogspringboot.entity.BlogReaction;
import com.example.blogspringboot.entity.ProUser;
import com.example.blogspringboot.service.blog.BlogService;
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

    @Override
    public void deleteBlogReaction(Long id) throws Exception {
        BlogReaction blogReaction = repository.findById(id).orElse(null);
        if (blogReaction != null) {
            repository.delete(blogReaction);
        }else{
            throw new Exception("BlogReaction not found");
        }

    }
}
