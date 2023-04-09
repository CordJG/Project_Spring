package com.codestates.CordJg.cafe.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class OrderCoffeePostDto {


    @Positive
    private long coffeeId;

    @Positive
    private int quantity;
}
