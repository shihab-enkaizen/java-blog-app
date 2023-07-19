package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity(name="billingaddresses")
@NoArgsConstructor
@Data
public class BillingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String address;

    @ManyToMany
    private List<ProUser> userList = new ArrayList<>();
}
