package com.codestates.CordJg.cafe.coffee.controller;

import com.codestates.CordJg.cafe.coffee.dto.CoffeeDTO;
import com.codestates.CordJg.cafe.coffee.dto.CoffeePostDto;
import com.codestates.CordJg.cafe.coffee.dto.CoffeeResponseDto;
import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import com.codestates.CordJg.cafe.coffee.mapper.CoffeeMapper;
import com.codestates.CordJg.cafe.coffee.service.CoffeeService;
import com.codestates.CordJg.cafe.repository.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {

    private final CoffeeMapper mapper;
    private final CoffeeRepository repository;

    private final CoffeeService service;

    public CoffeeController(CoffeeMapper mapper, CoffeeRepository repository, CoffeeService service) {
        this.mapper = mapper;
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity postCoffee(@RequestBody CoffeePostDto coffeePostDto){

        Coffee coffee = service.createCoffee(mapper.postToCoffee(coffeePostDto));

        CoffeeResponseDto response = mapper.coffeeToResponse(coffee);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PatchMapping
    public ResponseEntity patchCoffee(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>(coffeeDTO, HttpStatus.CREATED);
    }
    @GetMapping("/coffee-id/")
    public ResponseEntity getCoffee(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>(coffeeDTO, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity getCoffees(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>(coffeeDTO, HttpStatus.CREATED);

    }

    public ResponseEntity deleteCoffee(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>(coffeeDTO, HttpStatus.CREATED);

    }
}
