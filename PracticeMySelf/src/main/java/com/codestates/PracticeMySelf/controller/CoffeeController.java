package com.codestates.PracticeMySelf.controller;

import com.codestates.PracticeMySelf.dto.CoffeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {

    public ResponseEntity postCoffee(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>(coffeeDTO, HttpStatus.CREATED);
    }

    public ResponseEntity patchCoffee(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>(coffeeDTO, HttpStatus.CREATED);
    }

    public ResponseEntity getCoffee(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>(coffeeDTO, HttpStatus.CREATED);

    }

    public ResponseEntity getCoffees(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>(coffeeDTO, HttpStatus.CREATED);

    }

    public ResponseEntity deleteCoffee(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>(coffeeDTO, HttpStatus.CREATED);

    }
}
