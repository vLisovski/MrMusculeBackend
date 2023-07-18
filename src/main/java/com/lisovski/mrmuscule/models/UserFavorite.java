package com.lisovski.mrmuscule.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class UserFavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="bonuses")
    private int bonuses;

    @ManyToMany
    @JoinTable(
            name="favorite",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<Product> favoriteList = new ArrayList<>();

}
