package com.codestates.cordJg.dto;

import lombok.Getter;


@Getter
public class ToDoListPostDto {

    private String title;
    private long todo_order;
    private boolean completed;
}
