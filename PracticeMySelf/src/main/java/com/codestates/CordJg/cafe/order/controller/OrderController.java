package com.codestates.CordJg.cafe.order.controller;

import com.codestates.CordJg.cafe.coffee.service.CoffeeService;
import com.codestates.CordJg.cafe.order.dto.OrderPatchDto;
import com.codestates.CordJg.cafe.order.dto.OrderPostDto;

import com.codestates.CordJg.cafe.order.entity.Order;
import com.codestates.CordJg.cafe.order.mapper.OrderMapper;
import com.codestates.CordJg.cafe.order.service.OrderService;
import com.codestates.CordJg.cafe.response.SingleResponseDto;
import com.codestates.CordJg.cafe.response.MultiResponseDto;
import com.codestates.CordJg.cafe.utils.UriCreator;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
@Validated
public class OrderController {
    private final static String ORDER_DEFAULT_URL = "/v1/orders";
    private final OrderService orderService;
    private final OrderMapper mapper;
    private final CoffeeService coffeeService;

    public OrderController(OrderService orderService, OrderMapper mapper, CoffeeService coffeeService) {
        this.orderService = orderService;
        this.mapper = mapper;
        this.coffeeService = coffeeService;
    }

    @PostMapping
    public ResponseEntity postOrder(@Valid @RequestBody OrderPostDto orderPostDto) {
        Order order = orderService.createOrder(mapper.orderPostDtoToOrder(orderPostDto));

        URI location = UriCreator.createUri(ORDER_DEFAULT_URL, order.getOrderId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{order-id}")
    public ResponseEntity patchOrder(@PathVariable("order-id") @Positive long orderId,
                                     @Valid @RequestBody OrderPatchDto orderPatchDto) {
        orderPatchDto.setOrderId(orderId);
        Order order = orderService.updateOrder(mapper.orderPatchDtoToOrder(orderPatchDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.orderToResponseDto(order)), HttpStatus.OK);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId) {
        Order order = orderService.findOrder(orderId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.orderToResponseDto(order)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders(@Positive @RequestParam(value = "page", defaultValue = "1") int page,
                                    @Positive @RequestParam(value = "size", defaultValue = "5") int size) {
        Page<Order> pageOrders = orderService.findOrders(page -1,size);
        List<Order> orders = pageOrders.getContent();


        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.orderToResponseDtos(orders), pageOrders), HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity cancelOrder(@PathVariable("order-id") @Positive long orderId) {
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
