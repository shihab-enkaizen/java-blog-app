package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="users")
@NoArgsConstructor
@Data
public class ProUser extends NormalUser {

    @ManyToMany
    private List<BillingAddress> billingAddresses;

    @OneToMany
    private List<CardInformation> cardInformation;
}
