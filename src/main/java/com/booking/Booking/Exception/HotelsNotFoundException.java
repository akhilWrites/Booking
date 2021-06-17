package com.booking.Booking.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HotelsNotFoundException extends RuntimeException{

    public HotelsNotFoundException(String message){
        super(message);
    }
}
