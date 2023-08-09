package com.example.blogspringboot.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@MappedSuperclass
public class NormalUser  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private OffsetDateTime dateOfBirth;
    private String firstName;
    private String lastName;
    private boolean isActive = false;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();

    @OneToMany
    private List<BlogReaction> blogReactions = new ArrayList<>();

    @OneToMany
    private List<Comment> comments = new ArrayList<>();



}
