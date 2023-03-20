package com.codestates.hello_world.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MessagePostDto {
    @NotBlank
    private String message;
}
