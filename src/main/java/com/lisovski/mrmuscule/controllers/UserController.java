package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.dtos.FavoriteProductsResponseDto;
import com.lisovski.mrmuscule.dtos.PurchasedProductsResponseDto;
import com.lisovski.mrmuscule.models.User;
import com.lisovski.mrmuscule.services.UserService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("getById")
    public User getById(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        return userService.getById(userId);
    }

    @GetMapping("getFavorites")
    public FavoriteProductsResponseDto getFavoritesById(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        return userService.getFavoritesByUserId(userId);
    }

    @GetMapping("getPurchases")
    public PurchasedProductsResponseDto getPurchasesById(@Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
        return userService.getPurchasesByUserId(userId);
    }

    @GetMapping("addFavorite")
    public int addFavorite(@Min(0) @Max(2147483647) @NotNull @RequestParam int productId,
                           @Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
       return userService.addFavorite(productId,userId);
    }

    @GetMapping("deleteFavorite")
    public int deleteFavorite(@Min(0) @Max(2147483647) @NotNull @RequestParam int productId,
                              @Min(0) @Max(2147483647) @NotNull @RequestParam int userId){
       return userService.deleteFavorite(productId,userId);
    }
}
