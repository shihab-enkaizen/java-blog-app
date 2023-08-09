package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="blogreaction")
@Getter
@Setter
public class BlogReaction extends BaseReaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Blog blog;
    @ManyToOne
    private ProUser users;
}
