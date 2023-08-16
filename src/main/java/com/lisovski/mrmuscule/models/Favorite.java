package com.lisovski.mrmuscule.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favorite")
public class Favorite {
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
