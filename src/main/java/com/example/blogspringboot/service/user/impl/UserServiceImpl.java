package com.example.blogspringboot.service.user.impl;

import com.example.blogspringboot.dao.user.UserRepository;
import com.example.blogspringboot.dto.user.UserCreateDTO;
import com.example.blogspringboot.entity.BillingAddress;
import com.example.blogspringboot.entity.ProUser;
import com.example.blogspringboot.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.Period;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public ProUser createUser(UserCreateDTO dto) {
        ProUser user = new ProUser();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());
        user.setDateOfBirth(dto.getDateOfBirth());
//        user.setRoles(dto.getRoles());
        if(dto.getIsProAccount() && this.validateAge(dto.getDateOfBirth())) {
            BillingAddress billingAddress = new BillingAddress();
            billingAddress.setAddress(dto.getBillingAddress());
            billingAddress.setCity(dto.getBillingCity());
            user.setBillingAddresses(new ArrayList<>());
        }
        return repository.save(user);
    }

    private boolean validateAge(OffsetDateTime dob) {
        OffsetDateTime now = OffsetDateTime.now();
        Period period = Period.between(dob.toLocalDate(), now.toLocalDate());
        int ageInYears = period.getYears();
        return ageInYears >= 15;
    }
}
