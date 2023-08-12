package com.lisovski.mrmuscule.models;

import com.lisovski.mrmuscule.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="date")
    private Date date;

    @Column(name="cost")
    @NotNull
    @Min(0)
    @Max(2147483647)
    private int cost;

    @Pattern(regexp = ".{0,512}")
    @Column(name="description")
    private String description;

    @NotNull
    @Min(0)
    @Max(2147483647)
    @Column(name="user_id")
    private int userId;

    @NotNull
    @NotBlank
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @NotEmpty
    @ManyToMany
    @JoinTable(
            name="orders_products",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<Product> productList = new ArrayList<>();
}
