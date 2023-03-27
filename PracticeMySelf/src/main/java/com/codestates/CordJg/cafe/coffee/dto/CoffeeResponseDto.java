package com.codestates.CordJg.cafe.coffee.dto;

import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class CoffeeResponseDto {

    private long coffeeId;
    private String name;
    private int price;

}
