package com.codestates.cordJg.mapper;

import com.codestates.cordJg.dto.ToDoListPatchDto;
import com.codestates.cordJg.dto.ToDoListPostDto;
import com.codestates.cordJg.dto.ToDoListResponseDto;
import com.codestates.cordJg.entity.ToDoList;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToDoListMapper {

    ToDoList listPostDtoToList(ToDoListPostDto toDoListPostDto);

    ToDoList listPatchDtoToList(ToDoListPatchDto toDoListPatchDto);

    ToDoListResponseDto listToListResponseDto(ToDoList toDoList);

    List<ToDoListResponseDto> listsToResponseDto(List<ToDoList> lists);
}
