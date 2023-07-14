package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.dtos.FavoriteProductsResponseDto;
import com.lisovski.mrmuscule.models.Product;
import com.lisovski.mrmuscule.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public List<FavoriteProductsResponseDto> getFavoriteProducts(int userId){
        List<Product> productList = productRepository.getFavorite(userId);

        return productList.stream().map((product)->
                modelMapper.map(product,FavoriteProductsResponseDto.class)).collect(Collectors.toList());
    }
}
