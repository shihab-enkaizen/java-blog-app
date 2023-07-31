package com.example.blogspringboot.dao.user;

import com.example.blogspringboot.entity.ProUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ProUser, Long> {
    ProUser findProUsersById(Long userId);
}
