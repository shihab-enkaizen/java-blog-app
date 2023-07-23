package com.example.blogspringboot.dto.user;

import com.example.blogspringboot.entity.ProUser;
import com.example.blogspringboot.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class UserResponseDTO {
    private String username;
    private String email;
    private OffsetDateTime dateOfBirth;
    private String firstName;
    private String lastName;
    private List<Role> roles;

    public UserResponseDTO(ProUser user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.dateOfBirth = user.getDateOfBirth();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.roles = user.getRoles();
    }
}
