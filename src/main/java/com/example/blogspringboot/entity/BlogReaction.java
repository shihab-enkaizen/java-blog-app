package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="blogreactions")
@NoArgsConstructor
@Data
public class BlogReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Reaction reaction;
    private OffsetDateTime createdAt;

    @ManyToMany
    private List<ProUser> user;

    @ManyToMany
    private List<Blogs> blogs = new ArrayList<>();


}
