package com.codestates.cordJg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ToDoListResponseDto {

    private int listId;
    private String title;
    private int todo_order;
    private boolean completed;
}
