package com.example.blogspringboot.service.role.impl;

import com.example.blogspringboot.dao.role.RoleRepository;
import com.example.blogspringboot.entity.Role;
import com.example.blogspringboot.service.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role createRole(Role role) {
        return repository.save(role);
    }
}
