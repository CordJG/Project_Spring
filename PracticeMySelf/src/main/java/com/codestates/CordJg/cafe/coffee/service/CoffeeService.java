package com.codestates.CordJg.cafe.coffee.service;


import com.codestates.CordJg.cafe.coffee.dto.CoffeePostDto;
import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import com.codestates.CordJg.cafe.repository.CoffeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public Coffee createCoffee(Coffee coffee){

        return coffeeRepository.save(coffee);
    }

    public Coffee updateCoffee(Coffee coffee) {

        return coffeeRepository.save(coffee);
    }

//    @RequestMapping
//    public Coffee getCoffee()
}
