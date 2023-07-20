package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Entity(name="comments")
@NoArgsConstructor
@Data
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private OffsetDateTime createdAt;

    @ManyToOne
    private Blogs blog;

    @ManyToOne
    private ProUser user;

    @OneToMany
    private List<CommentReaction> commentReactions;
}
