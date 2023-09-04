package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.models.OrdersProducts;
import com.lisovski.mrmuscule.repositories.OrdersProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class OrdersProductsService {

    OrdersProductsRepository ordersProductsRepository;

    public void addOrderProductPair(OrdersProducts ordersProducts){
        ordersProductsRepository.save(ordersProducts);
    }

    public void saveAll(List<OrdersProducts> ordersProductsList){
        ordersProductsRepository.saveAll(ordersProductsList);
    }

    public void deleteAll(List<OrdersProducts> ordersProductsList){
        ordersProductsRepository.deleteAll(ordersProductsList);
    }
}
