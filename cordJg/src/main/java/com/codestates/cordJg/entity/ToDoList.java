package com.codestates.cordJg.entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private int todo_order;
    @Column(columnDefinition = "BOOLEAN NOT NULL")
    private boolean completed;

    public ToDoList(String title, int todo_order, boolean completed) {
        this.title = title;
        this.todo_order = todo_order;
        this.completed = completed;
    }
}
