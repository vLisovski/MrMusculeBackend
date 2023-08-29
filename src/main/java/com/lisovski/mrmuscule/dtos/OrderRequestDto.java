package com.lisovski.mrmuscule.dtos;

import com.lisovski.mrmuscule.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.util.List;

public class OrderRequestDto {

    @NotNull
    @Min(0)
    @Max(2147483647)
    private int cost;

    @Pattern(regexp = ".{0,512}")
    private String description;

    @Min(0)
    @Max(2147483647)
    private int bonusesToBuy;

    @NotNull
    @Min(0)
    @Max(2147483647)
    private int userId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @NotNull
    @NotBlank
    private List<String> productIdsList;
}
