package com.codestates.CordJg.cafe.order.dto;

import com.codestates.CordJg.cafe.order.entity.Order;
import lombok.Getter;

@Getter

public class OrderPatchDto {
    private long orderId;
    private Order.OrderStatus orderStatus;

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
