package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.dtos.FavoriteProductsResponseDto;
import com.lisovski.mrmuscule.dtos.PurchasedProductsResponseDto;
import com.lisovski.mrmuscule.models.User;
import com.lisovski.mrmuscule.models.UserFavorite;
import com.lisovski.mrmuscule.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("getById")
    public User getById(@RequestParam int userId){
        return userService.getById(userId);
    }

    @GetMapping("getFavorites")
    public FavoriteProductsResponseDto getFavoritesById(@RequestParam int userId){
        return userService.getFavoritesByUserId(userId);
    }

    @GetMapping("getPurchases")
    public PurchasedProductsResponseDto getPurchasesById(@RequestParam int userId){
        return userService.getPurchasesByUserId(userId);
    }

    @GetMapping("addFavorite")
    public int addFavorite(@RequestParam int productId,
                            @RequestParam int userId){
       return userService.addFavorite(productId,userId);
    }

    @GetMapping("deleteFavorite")
    public int deleteFavorite(@RequestParam int productId,
                            @RequestParam int userId){
       return userService.deleteFavorite(productId,userId);
    }
}
