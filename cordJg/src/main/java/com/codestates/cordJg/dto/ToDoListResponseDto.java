package com.codestates.cordJg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ToDoListResponseDto {

    private long toDoListId;
    private String title;
    private long todo_order;
    private boolean completed;
}
