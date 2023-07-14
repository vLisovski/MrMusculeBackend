package com.lisovski.mrmuscule.dtos;

import lombok.Data;

@Data
public class FavoriteProductsResponseDto {
    private String name;
    private String description;
    private int price;
    private String type;
    private String photoPath;
}
