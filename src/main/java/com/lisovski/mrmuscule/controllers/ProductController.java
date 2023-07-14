package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.dtos.FavoriteProductsResponseDto;
import com.lisovski.mrmuscule.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("getFavorite/{userId}")
    public List<FavoriteProductsResponseDto> getFavoriteProducts(@PathVariable(name = "userId") int userId) {
        return productService.getFavoriteProducts(userId);
    }
}
