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

    //repository(data bases)->service->controller(url)

    //TODO сделать добавление заказа(Order)
    //public int addOrder(Order order)
    //разобраться и написать метод, который получит с фронта объект Order с продуктами внутри и добавит его в БД
    //тестировать в ARC
    //не забыть создать новую ветку!!!!!!!!!!!
    //Структура объекта с фронта:(Примерчик)
    //{
    //    "id": 1,
    //    "date": "2023-07-17",
    //    "cost": 5300,
    //    "description": "Доставить к двери",
    //    "user_id": 1,
    //    "status": "delivered",
    //    "ordersList": [
    //      {
    //        "id": 2,
    //        "name": "Штанга",
    //        "description": "Современная стальная штанага",
    //        "price": 3500,
    //        "type": "inventory",
    //        "photoPath": "https://photolol.com"
    //      },
    //      {
    //        "id": 3,
    //        "name": "Протеин",
    //        "description": "FoodWay двойной шоколад",
    //        "price": 1800,
    //        "type": "food",
    //        "photoPath": "https://photolol.com"
    //      }
    //    ]
    // }
    //http://localhost:8080/orders/addOrder - URL , который должен работать по итогу на добавление заказа
    //раз добавление происходит в две таблицы за 1 запрос, то подумай насчет применения аннотации @Transactional
}
