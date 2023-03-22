package com.codestates.CordJg.cafe.coffee.service;

import com.codestates.CordJg.cafe.coffee.dto.CoffeeDTO;
import com.codestates.CordJg.cafe.repository.CoffeeRepository;

public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public void createCoffee(CoffeeDTO coffeeDTO){




    }
}
