package com.example.blogspringboot;

import com.example.blogspringboot.dao.role.RoleRepository;
import com.example.blogspringboot.entity.Role;
import com.example.blogspringboot.entity.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BlogApplication implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
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
}
