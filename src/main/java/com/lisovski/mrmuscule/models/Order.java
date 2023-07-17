package com.lisovski.mrmuscule.models;

import com.lisovski.mrmuscule.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="date")
    private Date date;

    @Column(name="cost")
    private int cost;

    @Column(name="description")
    private String description;

    @Column(name="user_id")
    private int user_id;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToMany
    @JoinTable(
            name="orders_products",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<Product> ordersList = new ArrayList<>();
}
