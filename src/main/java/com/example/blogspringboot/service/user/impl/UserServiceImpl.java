package com.example.blogspringboot.service.user.impl;

import com.example.blogspringboot.dao.billingaddress.BillingAddressRepository;
import com.example.blogspringboot.dao.user.UserRepository;
import com.example.blogspringboot.dto.user.UserCreateDTO;
import com.example.blogspringboot.entity.BillingAddress;
import com.example.blogspringboot.entity.Blog;
import com.example.blogspringboot.entity.ProUser;
import com.example.blogspringboot.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final BillingAddressRepository billingAddressRepository;

    @Override
    public ProUser createUser(UserCreateDTO dto) throws Exception {
        ProUser user = new ProUser();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setRoles(dto.getRoles());
        if(dto.getIsProAccount()) {
            if(this.validateAge(dto.getDateOfBirth())) {
                List<BillingAddress> billingAddressList = new ArrayList<>();

                for (Long id : dto.getBillingAddressesIdList()) {
                    BillingAddress find = billingAddressRepository.findBillingAddressByIdEquals(id);
                    if(find != null) {
                        billingAddressList.add(find);
                    }else{
                        throw new Exception("Billing Id not found");
                    }
                }

                user.setBillingAddresses(billingAddressList);
            }else{
                throw new Exception("Age must be at least 15");
            }
        }
        return repository.save(user);
    }

    private boolean validateAge(OffsetDateTime dob) {
        OffsetDateTime now = OffsetDateTime.now();
        Period period = Period.between(dob.toLocalDate(), now.toLocalDate());
        int ageInYears = period.getYears();
        return ageInYears >= 15;
    }

    @Override
    public ProUser getUser(Long id) throws Exception {
        ProUser user = repository.findById(id).orElse(null);
        if(user != null) {
            return user;
        }else{
            throw new Exception("User not found");
        }
    }

}
