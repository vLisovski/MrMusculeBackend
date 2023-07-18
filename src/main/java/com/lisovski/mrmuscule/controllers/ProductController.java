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

    @GetMapping("getAll/inventory/{limit}/{offset}")
    public List<Product> getInventoryProducts(@PathVariable(name = "limit") int limit,
                                     @PathVariable(name = "offset") int offset) {
        return productService.getProductsByCategory(ProductType.inventory,limit,offset);
    }

    @GetMapping("getAll/food/{limit}/{offset}")
    public List<Product> getFoodProducts(@PathVariable(name = "limit") int limit,
                                     @PathVariable(name = "offset") int offset) {
        return productService.getProductsByCategory(ProductType.food,limit,offset);
    }

    @GetMapping("getAll/clothes/{limit}/{offset}")
    public List<Product> getClothesProducts(@PathVariable(name = "limit") int limit,
                                         @PathVariable(name = "offset") int offset) {
        return productService.getProductsByCategory(ProductType.clothes,limit,offset);
    }





}
