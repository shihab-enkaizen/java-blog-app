package com.example.blogspringboot;

import com.example.blogspringboot.dao.billingaddress.BillingAddressRepository;
import com.example.blogspringboot.dto.blog.BlogCreateDTO;
import com.example.blogspringboot.dto.comment.CommentCreateDTO;
import com.example.blogspringboot.dto.reaction.BlogReactionDTO;
import com.example.blogspringboot.dto.reaction.CommentReactionDTO;
import com.example.blogspringboot.dto.user.UserCreateDTO;
import com.example.blogspringboot.entity.*;
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


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        blog.setTitle("New Blog 5");
        blog.setDescription("Dummy Description");
        blog.setPublishDate(OffsetDateTime.of(1990,11,7, 0,0,0,0, ZoneOffset.UTC));
        blog.setUserID(1L);

        mockMvc.perform(post("/api/blogs")
                        .content(objectMapper.writeValueAsString(blog))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Blog 5"));
    }

    @Test
    public void approveBlog() throws Exception {
        BlogCreateDTO blog = new BlogCreateDTO();
        blog.setUserID(1L);

        mockMvc.perform(put("/api/blogs/1/approve-blog")
                        .content(objectMapper.writeValueAsString(blog))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Blog 5"));
    }

    @Test
    public void addBlogReaction() throws Exception {
        BlogReactionDTO dto = new BlogReactionDTO();
        dto.setBlogId(1L);
        dto.setReactionType(ReactionType.LIKE);
        dto.setUserId(1L);

        mockMvc.perform(post("/api/reactions/blog-reaction")
                        .content(objectMapper.writeValueAsString(dto))
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void updateBlogReaction() throws Exception {
        BlogReactionDTO dto = new BlogReactionDTO();
        dto.setBlogId(1L);
        dto.setReactionType(ReactionType.HAHA);
        dto.setUserId(1L);

        mockMvc.perform(put("/api/reactions/blog-reaction/1")
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteBlogReaction() throws Exception {
        mockMvc.perform(delete("/api/reactions/blog-reaction/1"));
    }


    @Test
    public void addComment() throws Exception {
        CommentCreateDTO dto = new CommentCreateDTO();
        dto.setBlogId(1L);
        dto.setComment("This is a nice blog");
        dto.setUserId(1L);

        mockMvc.perform(post("/api/comments")
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.comment").value("This is a nice blog"));
    }

    @Test
    public void updateComment() throws Exception {
        CommentCreateDTO dto = new CommentCreateDTO();
        dto.setComment("This is a nice blog updated");

        mockMvc.perform(put("/api/comments/1")
                        .content(objectMapper.writeValueAsString(dto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.comment").value("This is a nice blog updated"));
    }

    @Test
    public void deleteComment() throws Exception {
        mockMvc.perform(delete("/api/comments/1"));
    }

    @Test
    public void addCommentReaction() throws Exception {
        CommentReactionDTO dto = new CommentReactionDTO();
        dto.setCommentId(1L);
        dto.setReactionType(ReactionType.ANGRY);
        dto.setUserId(1L);

        mockMvc.perform(post("/api/reactions/comment-reaction")
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void updateCommentReaction() throws Exception {
        CommentReactionDTO dto = new CommentReactionDTO();
        dto.setCommentId(1L);
        dto.setReactionType(ReactionType.LOVE);
        dto.setUserId(1L);

        mockMvc.perform(put("/api/reactions/comment-reaction")
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON));
    }


    @Test
    public void deleteCommentReaction() throws Exception {
        mockMvc.perform(delete("/api/reactions/comment-reaction/1"));
    }



}
