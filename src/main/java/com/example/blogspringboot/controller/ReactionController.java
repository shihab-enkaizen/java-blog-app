package com.example.blogspringboot.controller;

import com.example.blogspringboot.dto.blog.BlogCreateDTO;
import com.example.blogspringboot.dto.blog.BlogResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reactions")
public class ReactionController {
//    @PostMapping
//    public BlogResponseDTO createBlog(@RequestBody BlogCreateDTO dto) {
//        return new BlogResponseDTO(service.createBlog(dto));
//    }
}
