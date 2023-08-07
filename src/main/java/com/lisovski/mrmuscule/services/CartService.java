package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.models.Cart;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.repositories.CartRepository;
import com.lisovski.mrmuscule.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {

     private CartRepository cartRepository;
     private ProductRepository productRepository;

     public List<Product> getAllProductsFromCartByUserId(int userId){
        return productRepository.getProductsFromCartByUserId(userId);
     }

     public void deleteProduct(Cart cart){
         cartRepository.delete(cart);
     }

     public void addProduct(Cart cart){
         cartRepository.save(cart);
     }

     public void clearCart(int userId){
         cartRepository.clearCart(userId);
     }
}
