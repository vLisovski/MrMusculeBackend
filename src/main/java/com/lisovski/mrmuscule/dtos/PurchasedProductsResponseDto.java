package com.lisovski.mrmuscule.dtos;

import com.lisovski.mrmuscule.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchasedProductsResponseDto {
    private List<Product> purchasesList = new ArrayList<>();
}
