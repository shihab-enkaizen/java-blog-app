package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blogs")
@NoArgsConstructor
@Data
public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Status status;
    private String description;
    private OffsetDateTime publishDate;

    @OneToOne
    private ProUser user;

    @OneToMany
    private List<BlogReaction> blogReactions = new ArrayList<>();

    @OneToMany
    private List<Comments> comments = new ArrayList<>();
}
