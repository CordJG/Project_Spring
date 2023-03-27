package com.codestates.CordJg.cafe.repository;

import com.codestates.CordJg.cafe.order.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
