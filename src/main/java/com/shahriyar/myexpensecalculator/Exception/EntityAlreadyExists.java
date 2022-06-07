package com.shahriyar.myexpensecalculator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Entity already exists")
public class EntityAlreadyExists extends RuntimeException{

    public EntityAlreadyExists() {
        super();
    }

    public EntityAlreadyExists(String message) {
        super(message);
    }
}
