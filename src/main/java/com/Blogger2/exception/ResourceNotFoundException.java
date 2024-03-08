package com.Blogger2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)                                           //404
public class ResourceNotFoundException extends RuntimeException{

    //private String message;

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
