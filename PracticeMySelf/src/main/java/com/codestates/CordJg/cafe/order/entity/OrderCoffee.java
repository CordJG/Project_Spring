package com.codestates.CordJg.cafe.order.entity;

import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity(name = "ORDER_COFFEE")
public class OrderCoffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderCoffeeId;

    @Column(nullable = false)
    private long coffeeId;

    @Column(nullable = false)
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "ORDER_COFFEE_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ORDER_COFFEE_ID")
    private Coffee coffee;
}
