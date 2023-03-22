package com.codestates.CordJg.hello_world.service;

import com.codestates.CordJg.hello_world.entity.Message;
import com.codestates.CordJg.hello_world.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Message createMessage(Message message) {

        return repository.save(message);
    }
}
