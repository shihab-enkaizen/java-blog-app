package com.example.blogspringboot.service.user;

import com.example.blogspringboot.dto.user.UserCreateDTO;
import com.example.blogspringboot.entity.ProUser;

public interface UserService {
    ProUser createUser(UserCreateDTO dto) throws Exception;
}
