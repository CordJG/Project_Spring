package com.codestates.PracticeMySelf.coffee.service;

import com.codestates.PracticeMySelf.coffee.dto.CoffeeDTO;
import com.codestates.PracticeMySelf.repository.CoffeeRepository;

public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public void createCoffee(CoffeeDTO coffeeDTO){




    }
}
