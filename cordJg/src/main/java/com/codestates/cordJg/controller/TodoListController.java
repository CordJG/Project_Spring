package com.codestates.cordJg.controller;

import com.codestates.cordJg.dto.ToDoListPatchDto;
import com.codestates.cordJg.dto.ToDoListPostDto;

import com.codestates.cordJg.entity.ToDoList;
import com.codestates.cordJg.mapper.ToDoListMapper;
import com.codestates.cordJg.service.ToDoListService;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping
@Validated
public class TodoListController {

    private final ToDoListService service;
    private final ToDoListMapper mapper;

    public TodoListController(ToDoListService service, ToDoListMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postList(@Valid @RequestBody ToDoListPostDto toDoListPostDto) {

        ToDoList toDoList = mapper.listPostDtoToList(toDoListPostDto);

        ToDoList response = service.createList(toDoList);

        return new ResponseEntity<>(mapper.listToListResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{list-id}")
    public ResponseEntity patchList(@PathVariable("list-id") @Min(1) long listId,
                                    @Valid @RequestBody ToDoListPatchDto toDoListPatchDto) {
        toDoListPatchDto.setListId(listId);

        ToDoList response =
                service.updateList(mapper.listPatchDtoToList(toDoListPatchDto));

        return new ResponseEntity<>(mapper.listToListResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{list-id}")
    public ResponseEntity getList(@PathVariable("list-id") long listId) {
        ToDoList response = service.findList(listId);

        return new ResponseEntity<>(mapper.listToListResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getLists(@Positive @RequestParam(defaultValue = "1") int page,
                                   @Positive @RequestParam(defaultValue = "5") int size) {
        Page<ToDoList> pageLists = service.findLists(page - 1, size);
        List<ToDoList> lists = pageLists.getContent();

        return new ResponseEntity<>(mapper.listsToResponseDto(lists), HttpStatus.OK);
    }

    @DeleteMapping("/{list-id}")
    public ResponseEntity deleteList(@PathVariable("list-id") @Positive long listId){
        service.deleteList(listId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteLists(){
        service.deleteAllList();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
