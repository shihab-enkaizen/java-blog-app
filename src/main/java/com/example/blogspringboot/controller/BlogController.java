package com.example.blogspringboot.controller;

import com.example.blogspringboot.dto.blog.BlogCreateDTO;
import com.example.blogspringboot.dto.blog.BlogResponseDTO;
import com.example.blogspringboot.service.blog.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blogs")
public class BlogController {
    private final BlogService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogResponseDTO createBlog(@RequestBody BlogCreateDTO dto) {
        return new BlogResponseDTO(service.createBlog(dto));
    }

    @PutMapping("/{id}")
    public BlogResponseDTO updateBlog(@RequestBody BlogCreateDTO dto) throws Exception {
        return new BlogResponseDTO(service.updateBlog(dto));
    }

    @PutMapping("/{id}/approve-blog")
    public BlogResponseDTO approveBlog(@PathVariable Long id,  @RequestBody BlogCreateDTO dto) throws Exception {
        dto.setId(id);
        return new BlogResponseDTO(service.approveBlog(dto));
    }

}
