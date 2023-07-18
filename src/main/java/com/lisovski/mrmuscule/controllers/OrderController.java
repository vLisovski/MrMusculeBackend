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
    //  }
    //http://localhost:8080/orders/addOrder - URL , который должен работать по итогу на добавление заказа
    //раз добавление происходит в две таблицы за 1 запрос, то подумай насчет применения аннотации @Transactional
}
