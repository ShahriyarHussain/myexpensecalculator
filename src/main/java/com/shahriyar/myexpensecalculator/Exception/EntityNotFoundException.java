package com.shahriyar.myexpensecalculator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super("Requested object not found");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
