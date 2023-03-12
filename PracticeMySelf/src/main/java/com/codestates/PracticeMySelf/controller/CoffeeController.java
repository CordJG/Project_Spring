package com.codestates.PracticeMySelf.controller;

import com.codestates.PracticeMySelf.dto.CoffeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CoffeeController {

    public ResponseEntity postCoffee(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>(coffeeDTO.Response(), HttpStatus.CREATED);
    }

    public ResponseEntity patchCoffee(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>()
    }

    public ResponseEntity getCoffee(CoffeeDTO coffeeDTO){

    }

    public ResponseEntity getCoffees(CoffeeDTO coffeeDTO){

    }

    public ResponseEntity deleteCoffee(CoffeeDTO coffeeDTO){

    }
}
