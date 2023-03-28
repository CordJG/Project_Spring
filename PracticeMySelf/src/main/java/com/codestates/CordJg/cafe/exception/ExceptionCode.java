package com.codestates.CordJg.cafe.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member Not Found"),
    METHOD_NOT_ALLOWED(405,"Method Not Allowed"),
    INTERNAL_SERVER_ERROR(500,"Internal Server Error"),

    MEMBER_EXISTS(777,"Member Existed"),

    COFFEE_NOT_FOUND(666, "Coffee Not Found"),
    COFFEE_EXISTS(606,"Coffee Existed"),
    CANNOT_CHANGE_ORDER(246,"Order Is Ongoing"),
    ORDER_NOT_FOUND(444, "Order Not Found"),
    NOT_IMPLEMENTATION(501, "Not Implementation");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
