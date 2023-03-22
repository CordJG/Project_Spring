package com.codestates.CordJg.hello_world.controller;

import com.codestates.CordJg.hello_world.dto.MessagePostDto;
import com.codestates.CordJg.hello_world.entity.Message;
import com.codestates.CordJg.hello_world.mapper.MessageMapper;
import com.codestates.CordJg.hello_world.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/messages")
public class MessageController {
    private final MessageService messageService;
    private final MessageMapper mapper;

    public MessageController(MessageService messageService, MessageMapper mapper) {
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity post(@Valid @RequestBody MessagePostDto messagePostDto){

        Message message = mapper.postToMessage(messagePostDto);

        Message response = messageService.createMessage(message);

        return ResponseEntity.ok(mapper.messageToMessageResponseDto(response));
    }
}
