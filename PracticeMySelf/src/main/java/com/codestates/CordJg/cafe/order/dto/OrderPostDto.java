package com.codestates.CordJg.cafe.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPostDto {
    @Positive
    private long memberId;

    @Valid
    private List<OrderCoffeePostDto> orderCoffees;
}
