package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.dtos.CartRequestDto;
import com.lisovski.mrmuscule.dtos.CartResponseDto;
import com.lisovski.mrmuscule.services.CartService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
@AllArgsConstructor
@Validated
public class CartController {

    private CartService cartService;

    @GetMapping("getCart")
    public CartResponseDto getCartByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId,
                                           @Min(1) @Max(16) @NotNull @RequestParam int limit,
                                           @Min(0) @Max(2147483631) @NotNull @RequestParam int offset){
        return cartService.getCartProducts(userId, limit, offset);
    }

    @GetMapping("getTotal")
    public int getTotalCartByUserId(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        return cartService.getTotalCart(userId);
    }

    @PostMapping("addProduct")
    public void addProduct(@Valid @RequestBody CartRequestDto cartRequestDto){
        cartService.addProduct(cartRequestDto);
    }

    @DeleteMapping("deleteProduct")
    public void deleteProduct(@Valid @RequestBody CartRequestDto cartRequestDto){
        cartService.deleteProduct(cartRequestDto);
    }

    @DeleteMapping("clearCart")
    public void clearCart(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        cartService.clearCart(userId);
    }
}
