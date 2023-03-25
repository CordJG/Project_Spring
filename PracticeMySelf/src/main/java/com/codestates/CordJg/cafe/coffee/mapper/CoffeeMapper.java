package com.codestates.CordJg.cafe.coffee.mapper;

import com.codestates.CordJg.cafe.coffee.dto.CoffeeDTO;
import com.codestates.CordJg.cafe.coffee.dto.CoffeePathchDto;
import com.codestates.CordJg.cafe.coffee.dto.CoffeePostDto;
import com.codestates.CordJg.cafe.coffee.dto.CoffeeResponseDto;
import com.codestates.CordJg.cafe.coffee.entity.Coffee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee postToCoffee(CoffeePostDto coffeePostDto);
    Coffee patchToCoffee(CoffeePathchDto coffeePathchDto);

    CoffeeResponseDto coffeeToResponse(Coffee coffee);
}
