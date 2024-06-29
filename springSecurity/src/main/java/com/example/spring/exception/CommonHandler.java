package com.example.spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CommonHandler {

    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e) {
        e.printStackTrace();
        log.info("exception hello");
    }

}
