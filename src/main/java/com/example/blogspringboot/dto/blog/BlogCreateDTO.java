package com.example.blogspringboot.dto.blog;

import com.example.blogspringboot.entity.ProUser;
import com.example.blogspringboot.entity.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
@Data
@NoArgsConstructor
public class BlogCreateDTO {
    @JsonIgnore
    private Long Id;
    private String title;
    private Status status;
    private String description;
    private OffsetDateTime publishDate;
    private Long userID;

}
