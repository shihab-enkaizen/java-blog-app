package com.example.blogspringboot;

import com.example.blogspringboot.dao.billingaddress.BillingAddressRepository;
import com.example.blogspringboot.dto.blog.BlogCreateDTO;
import com.example.blogspringboot.dto.user.UserCreateDTO;
import com.example.blogspringboot.entity.BillingAddress;
import com.example.blogspringboot.entity.Role;
import com.example.blogspringboot.entity.RoleType;
import com.example.blogspringboot.entity.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class BlogSpringBootApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void addNormalUser() throws Exception {
        UserCreateDTO user = new UserCreateDTO();
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(RoleType.ADMIN));
        roles.add(new Role(RoleType.BLOGGER));
        user.setEmail("example@gmail.com");
        user.setPassword("111111");
        user.setUsername("usertest");
        user.setFirstName("User");
        user.setLastName("Test");
        user.setRoles(roles);
        user.setDateOfBirth(OffsetDateTime.of(1993,11,7, 0,0,0,0, ZoneOffset.UTC));

        mockMvc.perform(post("/api/users")
                        .content(objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("usertest"));
    }

    @Test
    public void addProUserWithExistingBillingAddress() throws Exception {
        UserCreateDTO user = new UserCreateDTO();
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(RoleType.ADMIN));
        roles.add(new Role(RoleType.BLOGGER));
        roles.add(new Role(RoleType.COMMENTER));

        List<Long> billingAddresses = new ArrayList<>();

       billingAddresses.add(1L);
       billingAddresses.add(2L);
       billingAddresses.add(3L);

        user.setEmail("pro@gmail.com");
        user.setPassword("111111");
        user.setUsername("prouser");
        user.setFirstName("User Pro");
        user.setLastName("Test");
        user.setRoles(roles);
        user.setIsProAccount(true);
        user.setBillingAddressesIdList(billingAddresses);
        user.setDateOfBirth(OffsetDateTime.of(1990,11,7, 0,0,0,0, ZoneOffset.UTC));

        mockMvc.perform(post("/api/users")
                        .content(objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("prouser"));
    }

    @Test
    public void addNewBlog() throws Exception {
        BlogCreateDTO blog = new BlogCreateDTO();
        blog.setTitle("New Blog 4");
        blog.setDescription("Dummy Description");
        blog.setPublishDate(OffsetDateTime.of(1990,11,7, 0,0,0,0, ZoneOffset.UTC));
        blog.setUserID(2L);

        mockMvc.perform(post("/api/blogs")
                        .content(objectMapper.writeValueAsString(blog))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Blog 4"));
    }

    @Test
    public void approveBlog() throws Exception {
        BlogCreateDTO blog = new BlogCreateDTO();
        blog.setId(1L);

        mockMvc.perform(post("/api/blogs/"+blog.getId()+"/approve-blog")
                        .content(objectMapper.writeValueAsString(blog))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Blog 4"));
    }


}
