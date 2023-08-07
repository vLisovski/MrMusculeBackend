package com.lisovski.mrmuscule.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "user_id")
    int userId;

    @Column(name = "product_id")
    int productId;
}
