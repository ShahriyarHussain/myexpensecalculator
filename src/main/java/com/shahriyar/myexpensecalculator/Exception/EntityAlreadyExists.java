package com.shahriyar.myexpensecalculator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntityAlreadyExists extends RuntimeException{

    public EntityAlreadyExists() {
        super("Entity already exists");
    }

    public EntityAlreadyExists(String message) {
        super(message);
    }
}
