package com.codestates.PracticeMySelf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    private String name;
    private int price;
    private Size size;


    public enum Size {
        SMALL, NOMALL, BIG
    }
}


