package com.example.blogspringboot.controller;

import com.example.blogspringboot.dto.comment.CommentCreateDTO;
import com.example.blogspringboot.dto.comment.CommentResponseDTO;
import com.example.blogspringboot.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponseDTO createComment(@RequestBody CommentCreateDTO dto) throws Exception {
        return new CommentResponseDTO(service.createComment(dto));
    }

    @PutMapping("/{id}")
    public CommentResponseDTO updateComment(@RequestBody CommentCreateDTO dto, @PathVariable Long id) throws Exception {
        dto.setId(id);
        return new CommentResponseDTO(service.updateComment(dto));
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id) throws Exception {
        service.deleteComment(id);
    }

}
