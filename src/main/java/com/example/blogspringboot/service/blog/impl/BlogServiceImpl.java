package com.example.blogspringboot.service.blog.impl;

import com.example.blogspringboot.dao.blog.BlogRepository;
import com.example.blogspringboot.dao.user.UserRepository;
import com.example.blogspringboot.dto.blog.BlogCreateDTO;
import com.example.blogspringboot.entity.Blog;
import com.example.blogspringboot.entity.ProUser;
import com.example.blogspringboot.entity.RoleType;
import com.example.blogspringboot.entity.Status;
import com.example.blogspringboot.service.blog.BlogService;
import com.example.blogspringboot.service.user.UserService;
import org.springframework.stereotype.Service;

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
        if(user.getRoles().contains(RoleType.BLOGGER)) {
            blog.setTitle(dto.getTitle());
            blog.setDescription(dto.getDescription());

            if(user.getRoles().contains(RoleType.ADMIN)) {
                blog.setStatus(Status.ACTIVE);
            }else{
                blog.setStatus(Status.INACTIVE);
            }

            blog.setPublishDate(dto.getPublishDate());
            blog.setUser(user);
        }


        return blogRepository.save(blog);
    }
}
