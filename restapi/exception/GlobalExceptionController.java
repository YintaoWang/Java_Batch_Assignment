package com.yintaowang.assignment.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = RecordsNotFindException.class)
    public ResponseEntity<Object> exception(RecordsNotFindException exception) {
        return new ResponseEntity<>("Records not found", HttpStatus.NOT_FOUND);
    }

}
