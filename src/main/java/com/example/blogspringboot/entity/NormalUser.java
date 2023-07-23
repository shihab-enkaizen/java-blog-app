package com.example.blogspringboot.entity;


import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;


@Data
@MappedSuperclass
public class NormalUser  {
    private String username;
    private String email;
    private String password;
    private OffsetDateTime dateOfBirth;
    private String firstName;
    private String lastName;

    @OneToMany
    private List<Role> roles;

}
