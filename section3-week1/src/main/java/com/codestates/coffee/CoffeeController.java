package com.codestates.coffee;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/v2/coffees")
public class CoffeeController {
    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("price") String price,
                                     @RequestParam("korName") String korName,
                                     @RequestParam("engName") String engName)

                                      {
        Map<String,String> map = new HashMap<>();
        map.put("price", price);
        map.put("korName", korName);
        map.put("engName", engName);


        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        System.out.println("# coffeeId: " + coffeeId);

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        System.out.println("# get Coffees");

        // not implmentation
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
