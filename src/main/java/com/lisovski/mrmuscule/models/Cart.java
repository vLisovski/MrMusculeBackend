package com.lisovski.mrmuscule.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@Builder
@AllArgsConstructor
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
