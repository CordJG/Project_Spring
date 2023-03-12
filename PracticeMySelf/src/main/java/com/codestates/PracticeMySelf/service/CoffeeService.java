package com.codestates.PracticeMySelf.service;

import com.codestates.PracticeMySelf.dto.CoffeeDTO;
import com.codestates.PracticeMySelf.repository.CoffeeRepository;

public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public CoffeeDTO createCoffee(CoffeeDTO coffeeDTO){

        coffeeRepository.save(coffeeDTO);


    }
}
