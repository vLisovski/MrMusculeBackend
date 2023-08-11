package com.lisovski.mrmuscule.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNull
    @Min(0)
    @Max(2147483647)
    @Column(name = "user_id")
    int userId;

    @NotNull
    @Min(0)
    @Max(2147483647)
    @Column(name = "product_id")
    int productId;
}
