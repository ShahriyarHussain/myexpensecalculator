package com.shahriyar.myexpensecalculator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid data format provided")
public class BadDataFormatException extends RuntimeException{
    public BadDataFormatException() {
        super();
    }

    public BadDataFormatException(String message) {
        super(message);
    }
}