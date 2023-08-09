package com.example.blogspringboot.service.comment.impl;

import com.example.blogspringboot.dao.comment.CommentRepository;
import com.example.blogspringboot.dto.comment.CommentCreateDTO;
import com.example.blogspringboot.entity.*;
import com.example.blogspringboot.service.blog.BlogService;
import com.example.blogspringboot.service.comment.CommentService;
import com.example.blogspringboot.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final BlogService blogService;
    private final UserService userService;
    private final CommentRepository repository;

    @Override
    public Comment createComment(CommentCreateDTO dto) throws Exception {

        Blog blog = blogService.getBlog(dto.getBlogId());
        ProUser user = userService.getUser(dto.getUserId());

        if(checkRole(user.getRoles(), RoleType.COMMENTER) || blog.getUser().getId().equals(user.getId())) {
            Comment comment = new Comment();
            comment.setCreatedAt(OffsetDateTime.now());
            comment.setComment(dto.getComment());
            comment.setUser(user);
            comment.setBlog(blog);
            return repository.save(comment);
        }else{
            throw new Exception("You are not authorized");
        }
    }

    @Override
    public Comment updateComment(CommentCreateDTO dto) throws Exception {
        Comment comment = repository.findById(dto.getId()).orElse(null);
        if(comment != null) {
            comment.setComment(dto.getComment());
            comment.setUpdatedAt(OffsetDateTime.now());
            return repository.save(comment);
        }else{
           throw new Exception("Comment not exist");
        }
    }

    @Override
    public void deleteComment(Long id) throws Exception {
        Comment comment = repository.findById(id).orElse(null);
        if(comment != null) {
            repository.delete(comment);
        }else{
            throw new Exception("Comment not exist");
        }
    }

    public Comment getComment(Long id) throws Exception {
        Comment comment = repository.findById(id).orElse(null);
        if(comment != null) {
            return comment;
        }else{
            throw new Exception("Comment not found");
        }
    }

    private boolean checkRole(List<Role> roles, RoleType roleType) {
        boolean isContainRole = false;
        for (Role role : roles) {
            if (role.getRoleType().equals(roleType)) {
                isContainRole = true;
                break; // Exit the loop as we have found the role
            }
        }
        return isContainRole;
    }
}
