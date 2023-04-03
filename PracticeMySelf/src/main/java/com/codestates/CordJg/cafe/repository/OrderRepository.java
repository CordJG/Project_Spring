package com.codestates.CordJg.cafe.repository;

import com.codestates.CordJg.cafe.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
