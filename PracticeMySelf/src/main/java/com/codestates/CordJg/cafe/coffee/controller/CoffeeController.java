package com.codestates.CordJg.cafe.coffee.controller;

import com.codestates.CordJg.cafe.coffee.dto.CoffeeDTO;
import com.codestates.CordJg.cafe.coffee.dto.CoffeePathchDto;
import com.codestates.CordJg.cafe.coffee.dto.CoffeePostDto;
import com.codestates.CordJg.cafe.coffee.dto.CoffeeResponseDto;
import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import com.codestates.CordJg.cafe.coffee.mapper.CoffeeMapper;
import com.codestates.CordJg.cafe.coffee.service.CoffeeService;
import com.codestates.CordJg.cafe.repository.CoffeeRepository;
import com.codestates.CordJg.cafe.response.MultiResponseDto;
import com.codestates.CordJg.cafe.response.SingleResponseDto;
import com.codestates.CordJg.cafe.utils.UriCreator;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {

    private final CoffeeMapper mapper;

    private final CoffeeService service;

    private final static String COFFEE_DEFAULT_URL = "/v1/coffees";

    public CoffeeController(CoffeeMapper mapper, CoffeeService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto){

        Coffee coffee = service.createCoffee(mapper.postToCoffee(coffeePostDto));

        URI location = UriCreator.createUri(COFFEE_DEFAULT_URL, coffee.getCoffeeId());


        return ResponseEntity.created(location).build();
    }
    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Min(1) long coffeeId,
                                      @Valid @RequestBody CoffeePathchDto coffeePathchDto){

        coffeePathchDto.setCoffeeId(coffeeId);

        Coffee coffee = service.updateCoffee(mapper.patchToCoffee(coffeePathchDto));

        CoffeeResponseDto response = mapper.coffeeToResponse(coffee);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }
    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId){

        Coffee coffee = service.findCoffee(coffeeId);

        CoffeeResponseDto response = mapper.coffeeToResponse(coffee);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity getCoffees(@Positive @RequestParam(value = "page", defaultValue = "1") int page,
                                     @Positive @RequestParam(value = "page", defaultValue = "5") int size){

        Page<Coffee> pageCoffees = service.findCoffees(page -1, size);
        List<Coffee> coffees = pageCoffees.getContent();
        CoffeeResponseDto response = mapper.coffeesToResponse(coffees);

        return new ResponseEntity<>(new MultiResponseDto<>(response,pageCoffees), HttpStatus.CREATED);

    }

    public ResponseEntity deleteCoffee(CoffeeDTO coffeeDTO){

        return new ResponseEntity<>(coffeeDTO, HttpStatus.CREATED);

    }
}
