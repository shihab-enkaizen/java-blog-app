package com.example.blogspringboot;

import com.example.blogspringboot.dao.billingaddress.BillingAddressRepository;
import com.example.blogspringboot.dao.role.RoleRepository;
import com.example.blogspringboot.entity.BillingAddress;
import com.example.blogspringboot.entity.Role;
import com.example.blogspringboot.entity.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class BlogApplication implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final BillingAddressRepository billingAddressRepository;

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(roleRepository.count() == 0) {
            Role role1 = new Role();
            role1.setRoleType(RoleType.ADMIN);
            roleRepository.save(role1);

            Role role2 = new Role();
            role2.setRoleType(RoleType.BLOGGER);
            roleRepository.save(role2);

            Role role3 = new Role();
            role3.setRoleType(RoleType.COMMENTER);
            roleRepository.save(role3);
        }

        if(billingAddressRepository.count() == 0) {
            billingAddressRepository.save(new BillingAddress(1L, "Dhaka", "Mirpur"));
            billingAddressRepository.save(new BillingAddress(2L, "Rangpur", "Mulatol"));
            billingAddressRepository.save(new BillingAddress(3L, "Sylhet", "Abc"));
        }


    }
}
