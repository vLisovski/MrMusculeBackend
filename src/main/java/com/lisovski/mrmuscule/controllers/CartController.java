package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.models.Cart;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.services.CartService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
@AllArgsConstructor
@Validated
public class CartController {

    private CartService cartService;

    @GetMapping("getByUserId")
    public List<Product> getCart(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                                 @Min(0) @Max(2147483631) @NotNull @RequestParam int limit,
                                 @Min(0) @Max(2147483631) @NotNull @RequestParam int offset) {
        return cartService.getAllProductsFromCartByUserId(userId, limit, offset);
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
