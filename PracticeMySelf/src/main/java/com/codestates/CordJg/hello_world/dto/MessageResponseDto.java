package com.codestates.CordJg.hello_world.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageResponseDto {
    private long messageId;
    private String message;
}
