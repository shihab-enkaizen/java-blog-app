package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class NormalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private OffsetDateTime dateOfBirth;
    private String firstName;
    private String lastName;
    private Role role;

    @OneToMany
    private List<Blogs> blogs = new ArrayList<>();

    @OneToMany
    private List<BlogReaction> blogReactions = new ArrayList<>();

    @OneToMany
    private List<Comments> comments = new ArrayList<>();

    @OneToMany
    private List<CommentReaction> commentReactions = new ArrayList<>();
}
