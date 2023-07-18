package com.lisovski.mrmuscule.dtos;

import com.lisovski.mrmuscule.models.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FavoriteProductsResponseDto {
    private List<Product> favoriteList = new ArrayList<>();
}
