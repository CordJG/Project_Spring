package com.codestates.CordJg.cafe.order.mapper;



import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import com.codestates.CordJg.cafe.coffee.service.CoffeeService;
import com.codestates.CordJg.cafe.order.dto.OrderCoffeeResponseDto;
import com.codestates.CordJg.cafe.order.dto.OrderPostDto;
import com.codestates.CordJg.cafe.order.dto.OrderResponseDto;
import com.codestates.CordJg.cafe.order.entity.CoffeeRef;
import com.codestates.CordJg.cafe.order.entity.Order;
import org.mapstruct.Mapper;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    default Order postToOrder(OrderPostDto orderPostDto) {
        Order order = new Order();

        order.setMemberId(new AggregateReference.IdOnlyAggregateReference(orderPostDto.getMemberId()));

        Set<CoffeeRef> orderCoffees = orderPostDto.getOrderCoffees()
                .stream()
                .map(orderCoffeeDto ->

                        CoffeeRef.builder()
                                .coffeeId(orderCoffeeDto.getCoffeeId())
                                .quantity(orderCoffeeDto.getQuantity())
                                .build())
                .collect(Collectors.toSet());
        order.setOrderCoffees(orderCoffees);

        return order;
    }

    default OrderResponseDto orderToResponse(CoffeeService coffeeService, Order order) {

        long memberId = order.getMemberId().getId();

        List<OrderCoffeeResponseDto> orderCoffees =
                orderCoffeesToOrderCoffeeResponseDto(coffeeService, order.getOrderCoffees());

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderCoffees(orderCoffees);
        orderResponseDto.setMemberId(memberId);
        orderResponseDto.setCreatedAt(order.getCreatedAt());
        orderResponseDto.setOrderId(order.getOrderId());
        orderResponseDto.setOrderStatus(order.getOrderStatus());

        return orderResponseDto;
    }

    default List<OrderCoffeeResponseDto> orderCoffeesToOrderCoffeeResponseDto(CoffeeService coffeeService,
                                                                              Set<CoffeeRef> orderCoffees) {
        return orderCoffees.stream()
                .map(coffeeRef -> {
                    Coffee coffee = coffeeService.findCoffee(coffeeRef.getCoffeeId());

                    return new OrderCoffeeResponseDto(coffee.getCoffeeId(),
                            coffee.getName(),
                            coffee.getPrice(),
                            coffeeRef.getQuantity());
                })
                .collect(Collectors.toList());
    }
}
