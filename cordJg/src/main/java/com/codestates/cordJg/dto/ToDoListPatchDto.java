package com.codestates.cordJg.dto;

import lombok.Getter;

@Getter
public class ToDoListPatchDto {
    private long listId;

    private String title;
    private long todo_order;
    private boolean completed;

    public void setListId(long listId) {
        this.listId = listId;
    }
}
