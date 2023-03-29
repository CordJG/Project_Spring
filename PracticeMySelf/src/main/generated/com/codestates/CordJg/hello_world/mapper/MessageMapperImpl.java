package com.codestates.CordJg.hello_world.mapper;

import com.codestates.CordJg.hello_world.dto.MessagePostDto;
import com.codestates.CordJg.hello_world.dto.MessageResponseDto;
import com.codestates.CordJg.hello_world.entity.Message;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-28T22:07:11+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public MessageResponseDto messageToMessageResponseDto(Message message) {
        if ( message == null ) {
            return null;
        }

        long messageId = 0L;
        String message1 = null;

        messageId = message.getMessageId();
        message1 = message.getMessage();

        MessageResponseDto messageResponseDto = new MessageResponseDto( messageId, message1 );

        return messageResponseDto;
    }

    @Override
    public Message postToMessage(MessagePostDto messagePostDto) {
        if ( messagePostDto == null ) {
            return null;
        }

        Message message = new Message();

        message.setMessage( messagePostDto.getMessage() );

        return message;
    }
}
