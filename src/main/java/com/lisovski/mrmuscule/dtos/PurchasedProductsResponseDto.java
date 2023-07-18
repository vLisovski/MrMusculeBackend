package com.lisovski.mrmuscule.dtos;

import com.lisovski.mrmuscule.models.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PurchasedProductsResponseDto {
    private List<Product> purchasesList = new ArrayList<>();
}
