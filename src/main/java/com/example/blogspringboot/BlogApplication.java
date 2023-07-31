package com.example.blogspringboot;

import com.example.blogspringboot.dao.billingaddress.BillingAddressRepository;
import com.example.blogspringboot.dao.role.RoleRepository;
import com.example.blogspringboot.dao.user.UserRepository;
import com.example.blogspringboot.entity.BillingAddress;
import com.example.blogspringboot.entity.ProUser;
import com.example.blogspringboot.entity.Role;
import com.example.blogspringboot.entity.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class BlogApplication implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final BillingAddressRepository billingAddressRepository;
    private final UserRepository userRepository;

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
            billingAddressRepository.save(new BillingAddress("Dhaka", "Mirpur"));
            billingAddressRepository.save(new BillingAddress("Rangpur", "Mulatol"));
            billingAddressRepository.save(new BillingAddress("Sylhet", "Abc"));
        }

        if(userRepository.count() == 0) {
            ProUser user = new ProUser();
            List<Role> roles = new ArrayList<>();
            roles.add(new Role(RoleType.ADMIN));
            roles.add(new Role(RoleType.BLOGGER));
            roles.add(new Role(RoleType.COMMENTER));

            List<Long> billingAddressesId = new ArrayList<>();
            List<BillingAddress> billingAddressList = new ArrayList<>();

            billingAddressesId.add(1L);
            billingAddressesId.add(2L);
            billingAddressesId.add(3L);

            for (Long id : billingAddressesId) {
                BillingAddress find = billingAddressRepository.findBillingAddressByIdEquals(id);
                if(find != null) {
                    billingAddressList.add(find);
                }else{
                    throw new Exception("Billing Id not found");
                }
            }

            user.setEmail("pro@gmail.com");
            user.setPassword("111111");
            user.setUsername("prouser");
            user.setFirstName("User Pro");
            user.setLastName("Test");
            user.setRoles(roles);
            user.setBillingAddresses(billingAddressList);
            user.setDateOfBirth(OffsetDateTime.of(1990,11,7, 0,0,0,0, ZoneOffset.UTC));
            userRepository.save(user);
        }


    }
}
