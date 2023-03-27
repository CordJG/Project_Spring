package com.codestates.CordJg.cafe.coffee.dto;

import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CoffeePathchDto {

    private long coffeeId;

    private int price;

}
