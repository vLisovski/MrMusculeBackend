package com.lisovski.mrmuscule.dtos;

import com.lisovski.mrmuscule.enums.OrderStatus;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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

    @Min(0)
    @Max(2147483647)
    private int bonusBoost;

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
