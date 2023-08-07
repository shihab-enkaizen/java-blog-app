package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    @ManyToOne
    private ProUser user;

    @ManyToOne
    private Blog blog;
}
