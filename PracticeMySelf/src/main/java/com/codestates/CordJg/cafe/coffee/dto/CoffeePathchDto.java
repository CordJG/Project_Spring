package com.codestates.CordJg.cafe.coffee.dto;

import com.codestates.CordJg.cafe.annotation.NotSpace;
import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter
public class CoffeePathchDto {

    private long coffeeId;

    @Range(min=100,max=50000)
    private Integer price;

    private Coffee.CoffeeStatus coffeeStatus;

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public Integer getPrice() {
        return price;
    }

}
