package com.codestates.cordJg.repository;

import com.codestates.cordJg.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {

    Optional<ToDoList> findByTitle(String title);
}
