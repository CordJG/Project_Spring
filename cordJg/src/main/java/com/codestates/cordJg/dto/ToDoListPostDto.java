package com.codestates.cordJg.dto;

import lombok.Getter;


@Getter
public class ToDoListPostDto {

    private String title;
    private int todo_order;
    private boolean completed;
}
