package com.lisovski.mrmuscule.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
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

    @OneToMany(targetEntity = Order.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id",referencedColumnName = "id")
    private List<Order> ordersList;
}
