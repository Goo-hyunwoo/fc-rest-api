package com.example.restapi.exception;

import com.example.restapi.controller.ExceptionController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
//@RestControllerAdvice(basePackages = {"com.example.restapi.controller"})
@RestControllerAdvice(basePackageClasses = {ExceptionController.class})
public class RestApiExceptionHandler {

    @ExceptionHandler(value={Exception.class})
    public ResponseEntity exception(Exception e) {
        log.error("Exception {}",e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value={IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(IndexOutOfBoundsException e) {
        log.error("outOfBound {}",e);
        return ResponseEntity.status(200).build();
    }
}
