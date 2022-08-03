package com.example.demo.exce;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Miles
 * @create 2022-08-01 11:09 PM
 * @email miles.j.hoo@gmail.com
 **/
@ControllerAdvice
public class ExceptionHanders extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }
}
