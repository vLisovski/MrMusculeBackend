package com.lisovski.mrmuscule.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@Builder
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Min(0)
    @Max(2147483647)
    @Column(name = "user_id")
    private int userId;

    @NotNull
    @Min(0)
    @Max(2147483647)
    @Column(name = "product_id")
    private int productId;
}
