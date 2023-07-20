package com.example.blogspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.OffsetDateTime;


public abstract class BaseReaction {

    private Reaction reaction;
    private OffsetDateTime createdAt;
}
