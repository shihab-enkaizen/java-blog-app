package com.example.blogspringboot.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="commentreactions")
@NoArgsConstructor
@Data
public class CommentReaction extends BaseReaction {
}
