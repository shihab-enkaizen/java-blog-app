package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name="comments")
@NoArgsConstructor
@Data
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private OffsetDateTime createdAt;

    @OneToOne
    private Blogs blog;

    @ManyToMany
    private List<ProUser> user;

    @OneToMany
    private List<CommentReaction> commentReactions;
}
