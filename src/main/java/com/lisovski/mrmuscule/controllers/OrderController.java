package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.models.Order;
import com.lisovski.mrmuscule.models.OrdersProducts;
import com.lisovski.mrmuscule.services.OrderService;
import com.lisovski.mrmuscule.services.OrdersProductsService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private OrdersProductsService ordersProductsService;

    @GetMapping("getOrders")
    public List<Order> getOrdersByUserId() {
        return orderService.getOrders();
    }

    @PostMapping("addOrder")
    @Transactional
    public void addNewOrder(@RequestBody Order order){
        int orderId;
        //операция сохранения заказа в таблицу orders
        orderId = orderService.addOrder(order);
        //здесь собирается лист объектов OrdersProducts
        List<OrdersProducts> ordersProductsList = order.getProductList().stream()
                .map((product)-> OrdersProducts.builder()
                        .orderId(orderId)
                        .productId(product.getId()).build())
                .collect(Collectors.toList());
        ordersProductsService.saveAll(ordersProductsList);
    }

    @DeleteMapping("deleteOrder")
    @Transactional
    public void deleteOrder(Order order){
        List<OrdersProducts> ordersProductsList = order.getProductList().stream()
                .map((product)-> OrdersProducts.builder()
                        .orderId(order.getId())
                        .productId(product.getId()).build())
                .collect(Collectors.toList());
        orderService.deleteOrderByUserId(order.getUser_id());
        ordersProductsService.deleteAll(ordersProductsList);
    }


}
