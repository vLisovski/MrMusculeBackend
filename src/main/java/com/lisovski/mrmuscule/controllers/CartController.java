package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.models.Cart;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.services.CartService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
@AllArgsConstructor
public class CartController {

    private CartService cartService;

    @GetMapping("getCart")
    public List<Product> getCart(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId) {
        return cartService.getAllProductsFromCartByUserId(userId);
    }

    @PostMapping("addProduct")
    public void addProduct(@Valid @RequestBody Cart cart){
        cartService.addProduct(cart);
    }

    @DeleteMapping("deleteProduct")
    public void deleteProduct(@Valid @RequestBody Cart cart){
        cartService.deleteProduct(cart);
    }

    @DeleteMapping("clearCart")
    public void clearCart(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        cartService.clearCart(userId);
    }
}
