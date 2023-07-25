package com.example.blogspringboot.controller;

import com.example.blogspringboot.dto.user.UserCreateDTO;
import com.example.blogspringboot.dto.user.UserResponseDTO;
import com.example.blogspringboot.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody UserCreateDTO dto) throws Exception {
        return new UserResponseDTO(service.createUser(dto));
    }
}
