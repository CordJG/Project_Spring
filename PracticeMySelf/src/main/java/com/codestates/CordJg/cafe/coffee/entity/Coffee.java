package com.codestates.CordJg.cafe.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.MapperConfig;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    @Id
    private long coffeeId;
    private String name;
    private int price;


}


