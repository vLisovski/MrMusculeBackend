package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.enums.ProductType;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("getAll/inventory")
    public List<Product> getInventoryProducts(@RequestParam int limit,
                                     @RequestParam int offset) {
        return productService.getProductsByCategory(ProductType.inventory,limit,offset);
    }

    @GetMapping("getAll/food")
    public List<Product> getFoodProducts(@RequestParam int limit,
                                     @RequestParam int offset) {
        return productService.getProductsByCategory(ProductType.food,limit,offset);
    }

    @GetMapping("getAll/clothes")
    public List<Product> getClothesProducts(@RequestParam int limit,
                                         @RequestParam int offset) {
        return productService.getProductsByCategory(ProductType.clothes,limit,offset);
    }





}
