package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@MappedSuperclass
public class BaseReaction {


    @Enumerated(EnumType.STRING)
    private ReactionType reaction;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
