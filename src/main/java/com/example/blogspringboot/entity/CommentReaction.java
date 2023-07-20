package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="commentreactions")
@NoArgsConstructor
@Data
public class CommentReaction extends BaseReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<ProUser> user;

    @ManyToMany
    private List<Blogs> blogs = new ArrayList<>();

}
