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
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String description;
    private OffsetDateTime publishDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProUser user;

    public void setStatus(Status status) {
        this.status = status;
    }
}
