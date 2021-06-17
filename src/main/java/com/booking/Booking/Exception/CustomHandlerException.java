package com.booking.Booking.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdException(HotelsNotFoundException ex, WebRequest wr){
        HotelsNotFoundExceptionResponse pir= new HotelsNotFoundExceptionResponse(ex.getMessage());
        return new ResponseEntity(pir, HttpStatus.BAD_REQUEST);
    }
}
