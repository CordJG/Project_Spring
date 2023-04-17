package com.codestates.CordJg.cafe.coffee.mapper;

import com.codestates.CordJg.cafe.coffee.dto.CoffeeDTO;
import com.codestates.CordJg.cafe.coffee.dto.CoffeePathchDto;
import com.codestates.CordJg.cafe.coffee.dto.CoffeePostDto;
import com.codestates.CordJg.cafe.coffee.dto.CoffeeResponseDto;
import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    @Mapping(source = "price", target = "price.value")
    Coffee postToCoffee(CoffeePostDto coffeePostDto);

    @Mapping(source = "price", target = "price.value")
    Coffee patchToCoffee(CoffeePathchDto coffeePathchDto);


    @Mapping(source = "price.value", target = "price")
    CoffeeResponseDto coffeeToResponse(Coffee coffee);

    List<CoffeeResponseDto> coffeesToResponse(List<Coffee> coffees);
}
