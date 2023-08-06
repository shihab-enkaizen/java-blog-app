package com.example.blogspringboot.service.blog.impl;

import com.example.blogspringboot.dao.blog.BlogRepository;
import com.example.blogspringboot.dao.user.UserRepository;
import com.example.blogspringboot.dto.blog.BlogCreateDTO;
import com.example.blogspringboot.entity.*;
import com.example.blogspringboot.service.blog.BlogService;
import com.example.blogspringboot.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private final UserRepository userRepository;
    private final BlogRepository blogRepository;

    public BlogServiceImpl(UserRepository userRepository, BlogRepository blogRepository) {
        this.userRepository = userRepository;
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog createBlog(BlogCreateDTO dto) {
        Blog blog = new Blog();
        ProUser user = userRepository.findProUsersById(dto.getUserID());
        if(this.checkRole(user.getRoles(), RoleType.BLOGGER)) {
            blog.setTitle(dto.getTitle());
            blog.setDescription(dto.getDescription());

            if(user.getBillingAddresses() != null) {
                blog.setStatus(Status.ACTIVE);
            }else{
                blog.setStatus(Status.INACTIVE);
            }

            blog.setPublishDate(dto.getPublishDate());
            blog.setUser(user);
        }
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(BlogCreateDTO dto) throws Exception {
        Blog blog = blogRepository.findById(dto.getId()).orElseThrow();
        if(!blog.getStatus().equals(Status.ACTIVE)) {
            ProUser user = userRepository.findProUsersById(dto.getUserID());
            if(this.checkRole(user.getRoles(), RoleType.BLOGGER)) {
                blog.setTitle(dto.getTitle());
                blog.setDescription(dto.getDescription());

                if(this.checkRole(user.getRoles(), RoleType.ADMIN)) {
                    blog.setStatus(Status.ACTIVE);
                }else{
                    blog.setStatus(Status.INACTIVE);
                }

                blog.setPublishDate(dto.getPublishDate());
                blog.setUser(user);
                return blogRepository.save(blog);

            }
            throw new Exception("Role is not blogger");

        }else{
            throw new Exception("Blog is already Active");
        }
    }

    @Override
    public Blog approveBlog(BlogCreateDTO dto) throws Exception {
        ProUser user = userRepository.findProUsersById(dto.getUserID());
        if(this.checkRole(user.getRoles(), RoleType.ADMIN)) {
            Blog blog = blogRepository.findById(dto.getId()).orElseThrow(() -> {
                try {
                    throw new Exception("Blog not found");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            if(!blog.getStatus().equals(Status.ACTIVE)) {
                blog.setStatus(Status.ACTIVE);
                return blogRepository.save(blog);
            }else{
                throw new Exception("Blog is already active");
            }
        }else {
            throw new Exception("Your role must be admin to approve blog");
        }
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
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

    public Blog getBlog(Long id) throws Exception {
        Blog blog = blogRepository.findById(id).orElse(null);
        if(blog != null) {
            return blog;
        }else{
            throw new Exception("Blog not found");
        }
    }
}
