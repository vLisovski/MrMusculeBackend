package com.lisovski.mrmuscule.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @Min(1)
    @Max(2147483647)
    @Column(name = "user_id")
    int userId;

    @NotNull
    @Min(1)
    @Max(2147483647)
    @Column(name = "product_id")
    int productId;
}
