package com.codestates.CordJg.cafe.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Builder
public class OrderCoffeeResponseDto {

    private long coffeeId;
    private String name;
    private int price;
    private int quantity;
}
