package com.codestates.PracticeMySelf.advice;

import com.codestates.PracticeMySelf.exception.BusinessLogicException;
import com.codestates.PracticeMySelf.exception.ExceptionCode;
import com.codestates.PracticeMySelf.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        final ErrorResponse response = ErrorResponse.of(e.getBindingResult());

        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(
            ConstraintViolationException e) {
        final ErrorResponse response = ErrorResponse.of(e.getConstraintViolations());

        return response;
    }

    @ExceptionHandler
    public  ResponseEntity handleResourceNotFoundException(BusinessLogicException e) {
        System.out.println(e.getExceptionCode().getStatus());
        System.out.println(e.getMessage());
        ErrorResponse response =
                new ErrorResponse(
                        e.getExceptionCode().getStatus(),
                        e.getExceptionCode().getMessage()
                );

        return new ResponseEntity<>(response,HttpStatus.valueOf(e.getExceptionCode().getStatus()));
    }

    @ExceptionHandler
    public ResponseEntity handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){

        System.out.println(e.getMessage());
        ErrorResponse response=
                new ErrorResponse(
                        HttpStatus.METHOD_NOT_ALLOWED.value(),
                        HttpStatus.METHOD_NOT_ALLOWED.toString()
                );
        return new ResponseEntity<>(response,HttpStatus.METHOD_NOT_ALLOWED);
    }
}
