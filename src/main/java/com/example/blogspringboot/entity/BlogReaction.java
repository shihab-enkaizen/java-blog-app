package com.example.blogspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="blogreaction")
public class BlogReaction extends BaseReaction{
    @OneToOne
    private Blog blog;
    @ManyToOne
    private ProUser users;
}
