package com.codestates.cordJg.repository;

import com.codestates.cordJg.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
