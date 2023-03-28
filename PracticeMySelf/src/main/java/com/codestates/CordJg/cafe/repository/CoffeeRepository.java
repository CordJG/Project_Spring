package com.codestates.CordJg.cafe.repository;



import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {

    Optional<Coffee> findByName(String name);

}
