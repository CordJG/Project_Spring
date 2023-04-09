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
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Coffee coffee;

    public void setOrder(Order order) {
        this.order= order;
        if (!this.order.getOrderCoffees().contains(this)) {
            this.order.getOrderCoffees().add(this);
        }
    }


}
