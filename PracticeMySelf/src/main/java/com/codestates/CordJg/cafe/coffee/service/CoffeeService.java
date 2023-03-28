package com.codestates.CordJg.cafe.coffee.service;


import com.codestates.CordJg.cafe.coffee.dto.CoffeePostDto;
import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import com.codestates.CordJg.cafe.exception.BusinessLogicException;
import com.codestates.CordJg.cafe.exception.ExceptionCode;
import com.codestates.CordJg.cafe.order.entity.Order;
import com.codestates.CordJg.cafe.repository.CoffeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoffeeService {

    private  CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public Coffee createCoffee(Coffee coffee){

        String coffeeName = coffee.getName().toUpperCase();

        verifyExistCoffee(coffeeName);
        coffee.setName(coffeeName);


        return coffeeRepository.save(coffee);
    }

    public Coffee updateCoffee(Coffee coffee) {

        Coffee findCoffee = findVerifiedCoffee(coffee.getCoffeeId());

        Optional.ofNullable(coffee.getPrice())
                .ifPresent(price -> findCoffee.setPrice(price));

        return coffeeRepository.save(findCoffee);
    }

    public Coffee findCoffee(long coffeeId) {
        return findVerifiedCoffee(coffeeId);
    }

    public List<Coffee> findOrderedCoffees(Order order) {
        return order.getOrderCoffees()
                .stream()
                .map(coffeeRef -> findCoffee(coffeeRef.getCoffeeId()))
                .collect(Collectors.toList());
    }

    public List<Coffee> findCoffees() {
        return (List < Coffee >) coffeeRepository.findAll();
    }

    public void deleteCoffee(long coffeeId) {
        Coffee coffee = findVerifiedCoffee(coffeeId);
        coffeeRepository.delete(coffee);
    }

    public Coffee findVerifiedCoffee(long coffeeId) {
        Optional<Coffee> optionalCoffee = coffeeRepository.findById(coffeeId);
        Coffee findCoffee =
                optionalCoffee.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));

        return findCoffee;
    }

    private void verifyExistCoffee(String coffeeName) {
        Optional<Coffee> coffee = coffeeRepository.findByName(coffeeName);
        if(coffee.isPresent())
            throw new BusinessLogicException(ExceptionCode.COFFEE_EXISTS);
    }


}
