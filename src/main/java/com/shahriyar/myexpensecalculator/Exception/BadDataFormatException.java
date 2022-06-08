package com.shahriyar.myexpensecalculator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadDataFormatException extends RuntimeException{
    public BadDataFormatException() {
        super("Invalid data format provided");
    }

    public BadDataFormatException(String message) {
        super(message);
    }
}