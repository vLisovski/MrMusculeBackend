package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.dateworker.UtilDateWorker;
import com.lisovski.mrmuscule.dtos.OrderRequestDto;
import com.lisovski.mrmuscule.models.Order;
import com.lisovski.mrmuscule.models.OrdersProducts;
import com.lisovski.mrmuscule.services.OrderService;
import com.lisovski.mrmuscule.services.OrdersProductsService;
import com.lisovski.mrmuscule.services.PurchaseService;
import com.lisovski.mrmuscule.services.UserService;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order")
@AllArgsConstructor
@Validated
@Slf4j
public class OrderController {

    private OrderService orderService;
    private UserService userService;
    private OrdersProductsService ordersProductsService;
    private PurchaseService purchaseService;

    @GetMapping("getAll")
    public List<Order> getOrdersByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId) {
        return orderService.getAllByUserId(userId);
    }

    @PostMapping("addOrder")
    @Transactional
    public void addNewOrder(@RequestBody OrderRequestDto orderRequestDto){

        //операция сохранения заказа в таблицу orders
        //присвоение серверного времени заказу
        int orderId;
        Order order = new Order();
        UtilDateWorker currentDate = new UtilDateWorker();
        Date date = new Date(currentDate.getDateInMilis());
        order.setDate(date);
        order.setCost(orderRequestDto.getCost());
        order.setDescription(orderRequestDto.getDescription());
        order.setUserId(orderRequestDto.getUserId());
        order.setStatus(orderRequestDto.getStatus());
        //сохранение заказа в бд
        orderId = orderService.addOrder(order);
        //здесь собирается лист объектов OrdersProducts
        List<OrdersProducts> ordersProductsList = orderRequestDto.getProductIdsList().stream()
                .map((item)-> OrdersProducts.builder()
                        .orderId(orderId)
                        .productId(item).build())
                .collect(Collectors.toList());
        System.out.println("ORDER "+ordersProductsList);
        ordersProductsService.saveAll(ordersProductsList);
        //изменение баланса бонусов
        userService.updateBonusBalance(orderRequestDto.getBonusBalance()-orderRequestDto.getBonusesToBuy(),
                orderRequestDto.getUserId());
        log.info("ADD ORDER "+orderRequestDto);
        //добавление товаров в покупки
//        List<Purchase> purchaseList = orderRequestDto.getProductIdsList().stream()
//                .map((item)-> Purchase.builder()
//                        .userId(orderRequestDto.getUserId())
//                        .productId(item).build())
//                .collect(Collectors.toList());
//        purchaseService.addAllPurchases(purchaseList);
    }

    @DeleteMapping("deleteOrder")
    @Transactional
    public void deleteOrder(@Valid @RequestBody Order order){
        List<OrdersProducts> ordersProductsList = order.getProductList().stream()
                .map((product)-> OrdersProducts.builder()
                        .orderId(order.getId())
                        .productId(product.getId()).build())
                .collect(Collectors.toList());
        orderService.deleteOrderByUserId(order.getUserId());
        ordersProductsService.deleteAll(ordersProductsList);
        log.info("DELETE ORDER "+order);
    }
}
