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
        //операция добавления продуктов, входящих в заказ, в таблицу orders_products
        ordersProductsList.forEach((ordersProducts -> ordersProductsService.addOrderProductPair(ordersProducts)));
    }

    //TODO deleteOrder

    @DeleteMapping("deleteOrder")
    @Transactional
    public void deleteOrder(@RequestBody Order order) {
        int orderId;
        orderId = orderService.deleteOrder(order);
        List<OrdersProducts> ordersProductsList;
        //добавление в лист для дальнейщего удаления
        //удаление нахуй
        ordersProductsList.forEach((ordersProducts -> ordersProductsService.deleteOrderProductPair(ordersProducts)));
    }


}
