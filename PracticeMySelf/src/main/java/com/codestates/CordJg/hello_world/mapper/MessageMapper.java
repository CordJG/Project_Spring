package com.codestates.CordJg.hello_world.mapper;

import com.codestates.CordJg.hello_world.dto.MessagePostDto;
import com.codestates.CordJg.hello_world.dto.MessageResponseDto;
import com.codestates.CordJg.hello_world.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageResponseDto messageToMessageResponseDto(Message message);

    Message postToMessage(MessagePostDto messagePostDto);

}
