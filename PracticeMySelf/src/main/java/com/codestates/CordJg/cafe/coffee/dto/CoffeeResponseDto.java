package com.codestates.CordJg.cafe.coffee.dto;

import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CoffeeResponseDto {

    private long coffeeId;
    private String name;
    private int price;

}
