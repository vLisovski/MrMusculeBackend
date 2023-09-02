package com.lisovski.mrmuscule.dtos;

import com.lisovski.mrmuscule.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Min(0)
    @Max(2147483647)
    private int bonusBalance;

    @NotNull
    @Min(0)
    @Max(2147483647)
    private int userId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @NotNull
    @NotBlank
    private List<Integer> productIdsList;
}
