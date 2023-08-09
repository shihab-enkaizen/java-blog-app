package com.example.blogspringboot.dao.blog;

import com.example.blogspringboot.entity.Blog;
import com.example.blogspringboot.entity.BlogReaction;
import com.example.blogspringboot.entity.ProUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogReactionRepository extends JpaRepository<BlogReaction, Long> {
    BlogReaction findAllByBlogAndUsers(Blog blog, ProUser user);
}
