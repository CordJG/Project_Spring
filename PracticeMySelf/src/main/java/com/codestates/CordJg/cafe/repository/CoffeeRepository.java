package com.codestates.CordJg.cafe.repository;



import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
