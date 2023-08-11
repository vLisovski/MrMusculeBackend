package com.lisovski.mrmuscule.controllers;

import com.lisovski.mrmuscule.enums.ProductType;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.services.ProductService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
@Validated
public class ProductController {

    private ProductService productService;

    @GetMapping("getAll/inventory")
    public List<Product> getInventoryProducts(@Min(1) @Max(10) @RequestParam @NotNull int limit,
                                              @Min(0) @Max(2147483646) @RequestParam @NotNull int offset) {
        return productService.getProductsByCategory(ProductType.inventory,limit,offset);
    }

    @GetMapping("getAll/food")
    public List<Product> getFoodProducts(@Min(1) @Max(10) @NotNull @RequestParam int limit,
                                         @Min(0) @Max(2147483646) @RequestParam @NotNull int offset) {
        return productService.getProductsByCategory(ProductType.food,limit,offset);
    }

    @GetMapping("getAll/clothes")
    public List<Product> getClothesProducts(@Min(1) @Max(10) @NotNull @RequestParam int limit,
                                            @Min(0) @Max(2147483646) @NotNull @RequestParam int offset) {
        return productService.getProductsByCategory(ProductType.clothes,limit,offset);
    }
}
