package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.models.Order;
import com.lisovski.mrmuscule.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public int addOrder(Order order){
       return orderRepository.saveOrder(order.getDate(),
               order.getCost(),
               order.getDescription(),
               order.getUser_id(),
               order.getStatus().toString());
    }

    public void deleteOrderByUserId(int userId){
        orderRepository.deleteByUser_id(userId);
    }
}
