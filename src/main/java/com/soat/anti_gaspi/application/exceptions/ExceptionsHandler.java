package com.soat.anti_gaspi.application.exceptions;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidDateFormat.class)
    @ResponseBody
    public ResponseEntity<RestException> handleConflict(InvalidDateFormat exception) {
        return ResponseEntity
                .badRequest()
                .body(RestException.builder()
                        .message(exception.getMessage())
                        .httpStatus(400)
                        .build());
    }

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseBody
    public ResponseEntity<RestException> handleConflict(InvalidFormatException exception) {
        return ResponseEntity
                .badRequest()
                .body(RestException.builder()
                        .message(exception.getMessage())
                        .httpStatus(400)
                        .build());
    }
}
