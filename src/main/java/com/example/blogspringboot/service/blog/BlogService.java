package com.example.blogspringboot.service.blog;

import com.example.blogspringboot.dto.blog.BlogCreateDTO;
import com.example.blogspringboot.entity.Blog;
import org.springframework.stereotype.Service;


public interface BlogService {
    Blog createBlog(BlogCreateDTO dto);
}
