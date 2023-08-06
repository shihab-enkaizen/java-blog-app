package com.example.blogspringboot.dao.blog;

import com.example.blogspringboot.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
