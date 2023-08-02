package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@MappedSuperclass
public class BaseReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReactionType reaction;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
