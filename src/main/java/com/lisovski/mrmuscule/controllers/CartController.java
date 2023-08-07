package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.models.Cart;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
@AllArgsConstructor
public class CartController {

    private CartService cartService;

    @GetMapping("getCart/{userId}")
    public List<Product> getCart(@PathVariable(name="userId")int userId) {
        return cartService.getAllProductsFromCartByUserId(userId);
    }

    @PostMapping("addProduct")
    public void addProduct(@RequestBody Cart cart){
        cartService.addProduct(cart);
    }

    @DeleteMapping("deleteProduct")
    public void deleteProduct(@RequestBody Cart cart){
        cartService.deleteProduct(cart);
    }

    @DeleteMapping("clearCart/{userId}")
    public void clearCart(@PathVariable(name="userId")int userId){
        cartService.clearCart(userId);
    }
}
