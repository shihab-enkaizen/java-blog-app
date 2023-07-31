package com.example.blogspringboot.dto.blog;

import com.example.blogspringboot.entity.ProUser;
import com.example.blogspringboot.entity.Status;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
@Data
@NoArgsConstructor
public class BlogCreateDTO {
    private String title;
    private Status status;
    private String description;
    private OffsetDateTime publishDate;
    private Long userID;

}
