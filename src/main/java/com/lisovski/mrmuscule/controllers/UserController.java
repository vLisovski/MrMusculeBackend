package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.dtos.FavoriteProductsResponseDto;
import com.lisovski.mrmuscule.dtos.PurchasedProductsResponseDto;
import com.lisovski.mrmuscule.models.User;
import com.lisovski.mrmuscule.models.UserFavorite;
import com.lisovski.mrmuscule.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("getById/{userId}")
    public User getById(@PathVariable(name = "userId") int userId){
        return userService.getById(userId);
    }

    @GetMapping("getFavorites/{userId}")
    public FavoriteProductsResponseDto getFavoritesById(@PathVariable(name = "userId") int userId){
        return userService.getFavoritesByUserId(userId);
    }

    @GetMapping("getPurchases/{userId}")
    public PurchasedProductsResponseDto getPurchasesById(@PathVariable(name = "userId") int userId){
        return userService.getPurchasesByUserId(userId);
    }

    @GetMapping("addFavorite/{productId}/{userId}")
    public int addFavorite(@PathVariable(name = "productId") int productId,
                            @PathVariable(name = "userId") int userId){
       return userService.addFavorite(productId,userId);
    }

    @GetMapping("deleteFavorite/{productId}/{userId}")
    public int deleteFavorite(@PathVariable(name = "productId") int productId,
                            @PathVariable(name = "userId") int userId){
       return userService.deleteFavorite(productId,userId);
    }
}
