package com.example.blogspringboot.dto.user;

import com.example.blogspringboot.entity.BillingAddress;
import com.example.blogspringboot.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class UserCreateDTO {
    private String username;
    private String email;
    private String password;
    private OffsetDateTime dateOfBirth;
    private String firstName;
    private String lastName;
    private Boolean isProAccount = false;
    private List<Role> roles;
    private List<Long> billingAddressesIdList;

}
