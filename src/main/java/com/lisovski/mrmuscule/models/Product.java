package com.lisovski.mrmuscule.models;

import com.lisovski.mrmuscule.enums.ProductType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Pattern(regexp = ".{0,256}")
    @Column(name="name")
    private String name;

    @Pattern(regexp = ".{0,512}")
    @Column(name="description")
    private String description;

    @NotNull
    @Min(0)
    @Max(2147483647)
    @Column(name="price")
    private int price;

    @NotBlank
    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Column(name="photo_path")
    private String photoPath;

    @Column(name = "bonuses")
    private int bonuses;
}
