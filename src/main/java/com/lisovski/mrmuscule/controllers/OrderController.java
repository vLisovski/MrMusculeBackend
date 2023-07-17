package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.models.Order;
import com.lisovski.mrmuscule.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping("getOrders")
    public List<Order> getOrdersByUserId() {
        return orderService.getOrders();
    }
}
