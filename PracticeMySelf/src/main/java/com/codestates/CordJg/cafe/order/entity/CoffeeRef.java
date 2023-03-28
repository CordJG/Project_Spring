package com.codestates.CordJg.cafe.order.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("ORDER_COFFEE")
@Builder
public class CoffeeRef {
    @Id
    private long orderCoffeeId;
    private long coffeeId;
    private int quantity;
}
