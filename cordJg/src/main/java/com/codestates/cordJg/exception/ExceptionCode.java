package com.codestates.cordJg.exception;

import lombok.Getter;

public enum ExceptionCode {

    LIST_NOT_FOUND(404,"List Not Found"),
    LIST_EXIST(606, "List Existed");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
