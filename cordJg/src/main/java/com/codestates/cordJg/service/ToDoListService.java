package com.codestates.cordJg.service;

import com.codestates.cordJg.dto.ToDoListResponseDto;
import com.codestates.cordJg.entity.ToDoList;
import com.codestates.cordJg.repository.ToDoListRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.codestates.cordJg.exception.*;

import java.util.Optional;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public ToDoList createList(ToDoList toDoList) {
        verifyExistList(toDoList.getListId());

        return toDoListRepository.save(toDoList);
    }

    public ToDoList updateList(ToDoList toDoList) {
        ToDoList findList = findVerifiedList(toDoList.getListId());

        Optional.ofNullable(toDoList.getTitle())
                .ifPresent(title -> findList.setTitle(title));
        Optional.ofNullable(toDoList.getTodo_order())
                .ifPresent(order -> findList.setTodo_order(order));
        Optional.ofNullable(toDoList.isCompleted())
                .ifPresent(complated -> findList.setCompleted(complated));

        return toDoListRepository.save(findList);
    }

    public ToDoList findList(long listId) {

        return findVerifiedList(listId);
    }

    public Page<ToDoList> findLists(int page, int size) {

        return toDoListRepository.findAll(PageRequest.of(page, size, Sort.by("listId").descending()));
    }

    public void deleteList(long listId) {

        ToDoList findList = findVerifiedList(listId);
        toDoListRepository.delete(findList);

    }

    public void deleteAllList() {

        toDoListRepository.deleteAll();

    }

    public ToDoList findVerifiedList(long listId) {
        Optional<ToDoList> optionalToDoList =
                toDoListRepository.findById(listId);
        ToDoList findList =
                optionalToDoList.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.LIST_NOT_FOUND));
        return findList;
    }

    private void verifyExistList(long listId) {
        Optional<ToDoList> toDoList = toDoListRepository.findById(listId);
        if(toDoList.isPresent())
            throw new BusinessLogicException(ExceptionCode.LIST_EXIST);
    }
}
