package com.codestates.CordJg.cafe.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderCoffeeResponseDto {
    private long coffeeId;
    private String name;
    private int price;
    private int quantity;
}
