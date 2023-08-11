package com.lisovski.mrmuscule.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders_products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrdersProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name="order_id")
    private int orderId;

    @NotNull
    @Column(name="product_id")
    private int productId;
}
