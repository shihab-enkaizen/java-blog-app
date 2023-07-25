package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity(name="billingaddress")
@NoArgsConstructor
@Data
public class BillingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String address;

    @ManyToMany(mappedBy = "billingAddresses")
    private List<ProUser> users = new ArrayList<>();


    public BillingAddress(Long id, String city, String address) {
        this.id = id;
        this.city = city;
        this.address = address;
    }
}
