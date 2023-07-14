package com.lisovski.mrmuscule.models;

import com.lisovski.mrmuscule.enums.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.lang.annotation.ElementType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private int price;

    @Column(name="type")
    private String type;

    @Column(name="photo_path")
    private String photoPath;

}
