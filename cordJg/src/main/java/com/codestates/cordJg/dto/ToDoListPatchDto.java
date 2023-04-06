package com.codestates.cordJg.dto;

import lombok.Getter;

@Getter
public class ToDoListPatchDto {


    private String title;
    private int todo_order;
    private boolean completed;


}
