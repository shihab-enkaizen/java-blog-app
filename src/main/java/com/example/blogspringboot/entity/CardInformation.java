package com.example.blogspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="cardinformations")
@NoArgsConstructor
@Data
public class CardInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;
    private String expireDate;
    private String cvc;
    private String cardHolderName;

    @ManyToOne
    private ProUser user;
}
