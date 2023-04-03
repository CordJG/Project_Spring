package com.codestates.CordJg.cafe.repository;



import com.codestates.CordJg.cafe.coffee.entity.Coffee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    Optional<Coffee> findByName(String name);

    @Query(value = "SELECT c FROM coffee c WHERE c.coffeeId = :coffeeId")
    Optional<Coffee> findByCoffee(long coffeeId);


}
