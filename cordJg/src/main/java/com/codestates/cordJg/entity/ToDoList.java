package com.codestates.cordJg.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

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
    private Long listId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length=10, nullable = false)
    private long todo_order;
    @Column(length=10, nullable = false)
    private boolean completed;

    public ToDoList(String title, long todo_order, boolean completed) {
        this.title = title;
        this.todo_order = todo_order;
        this.completed = completed;
    }
}
