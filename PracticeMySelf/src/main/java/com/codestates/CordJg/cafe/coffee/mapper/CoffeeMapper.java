package com.codestates.CordJg.cafe.coffee.mapper;

import com.codestates.CordJg.cafe.coffee.dto.CoffeeDTO;
import com.codestates.CordJg.cafe.coffee.dto.CoffeePathchDto;
import com.codestates.CordJg.cafe.coffee.dto.CoffeePostDto;
import com.codestates.CordJg.cafe.coffee.dto.CoffeeResponseDto;
import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    @Mapping(source = "price", target = "price.value")
    Coffee postToCoffee(CoffeePostDto coffeePostDto);
    Coffee patchToCoffee(CoffeePathchDto coffeePathchDto);

    CoffeeResponseDto coffeeToResponse(Coffee coffee);
}
