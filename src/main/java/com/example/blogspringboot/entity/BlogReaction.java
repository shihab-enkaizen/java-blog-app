package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity(name="blogreactions")
@NoArgsConstructor
@Data
public class BlogReaction extends BaseReaction{
    @ManyToOne
    private ProUser user;

    @ManyToMany
    private List<Blogs> blogs = new ArrayList<>();


}
