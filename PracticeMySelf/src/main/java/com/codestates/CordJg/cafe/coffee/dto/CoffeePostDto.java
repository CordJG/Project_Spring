package com.codestates.CordJg.cafe.coffee.dto;

import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter
public class CoffeePostDto {
    @NotBlank
    private String name;

    @Range(min = 100, max=10000)
    private int price;


}
