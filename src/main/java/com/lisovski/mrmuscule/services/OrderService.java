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

    public List<Order> getAllByUserId(int userId){
        return orderRepository.findAllByUserId(userId);
    }

    public int addOrder(Order order){
       return orderRepository.saveOrder(order.getDate(),
               order.getCost(),
               order.getDescription(),
               order.getUserId(),
               order.getStatus().toString());
    }

    public void deleteOrderByUserId(int userId){
        orderRepository.deleteByUserId(userId);
    }
}
