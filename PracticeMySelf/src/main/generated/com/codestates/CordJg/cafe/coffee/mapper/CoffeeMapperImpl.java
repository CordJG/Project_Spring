package com.codestates.CordJg.cafe.coffee.mapper;

import com.codestates.CordJg.cafe.coffee.dto.CoffeePathchDto;
import com.codestates.CordJg.cafe.coffee.dto.CoffeePostDto;
import com.codestates.CordJg.cafe.coffee.dto.CoffeeResponseDto;
import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-27T21:22:43+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class CoffeeMapperImpl implements CoffeeMapper {

    @Override
    public Coffee postToCoffee(CoffeePostDto coffeePostDto) {
        if ( coffeePostDto == null ) {
            return null;
        }

        Coffee coffee = new Coffee();

        coffee.setName( coffeePostDto.getName() );
        coffee.setPrice( coffeePostDto.getPrice() );

        return coffee;
    }

    @Override
    public Coffee patchToCoffee(CoffeePathchDto coffeePathchDto) {
        if ( coffeePathchDto == null ) {
            return null;
        }

        Coffee coffee = new Coffee();

        coffee.setCoffeeId( coffeePathchDto.getCoffeeId() );
        coffee.setPrice( coffeePathchDto.getPrice() );

        return coffee;
    }

    @Override
    public CoffeeResponseDto coffeeToResponse(Coffee coffee) {
        if ( coffee == null ) {
            return null;
        }

        long coffeeId = 0L;
        String name = null;
        int price = 0;

        coffeeId = coffee.getCoffeeId();
        name = coffee.getName();
        price = coffee.getPrice();

        CoffeeResponseDto coffeeResponseDto = new CoffeeResponseDto( coffeeId, name, price );

        return coffeeResponseDto;
    }
}
