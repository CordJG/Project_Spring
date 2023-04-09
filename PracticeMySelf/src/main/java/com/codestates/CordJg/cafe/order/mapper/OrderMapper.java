package com.codestates.CordJg.cafe.order.mapper;




import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import com.codestates.CordJg.cafe.member.entity.Member;
import com.codestates.CordJg.cafe.order.dto.OrderCoffeeResponseDto;
import com.codestates.CordJg.cafe.order.dto.OrderPatchDto;
import com.codestates.CordJg.cafe.order.dto.OrderPostDto;
import com.codestates.CordJg.cafe.order.dto.OrderResponseDto;

import com.codestates.CordJg.cafe.order.entity.Order;
import com.codestates.CordJg.cafe.order.entity.OrderCoffee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface OrderMapper {

    default Order orderPostDtoToOrder(OrderPostDto orderPostDto) {
        Order order = new Order();
        Member member = new Member();
        member.setMemberId(orderPostDto.getMemberId());

        List<OrderCoffee> orderCoffees = orderPostDto.getOrderCoffees().stream()
                .map(orderCoffeeDto -> {
                    OrderCoffee orderCoffee = new OrderCoffee();
                    Coffee coffee = new Coffee();
                    coffee.setCoffeeId(orderCoffeeDto.getCoffeeId());
                    orderCoffee.setOrder(order);
                    orderCoffee.setCoffee(coffee);
                    orderCoffee.setQuantity(orderCoffeeDto.getQuantity());
                    return orderCoffee;
                }).collect(Collectors.toList());
        order.setMember(member);
        order.setOrderCoffees(orderCoffees);

        return order;
    }

    Order orderPatchDtoToOrder(OrderPatchDto orderPatchDto);

    List<OrderResponseDto> ordersToOrderResponseDtos(List<Order> orders);

    @Mapping(source = "member.memberId", target = "memberId")
    OrderResponseDto orderToResponseDto(Order order);

    @Mapping(source = "coffee.coffeeId", target = "coffeeId")
    @Mapping(source = "coffee.name", target = "name")
    @Mapping(source = "coffee.price.value", target = "price")
    OrderCoffeeResponseDto orderCoffeeToOrderCoffeeResponseDto(OrderCoffee orderCoffee);







}
