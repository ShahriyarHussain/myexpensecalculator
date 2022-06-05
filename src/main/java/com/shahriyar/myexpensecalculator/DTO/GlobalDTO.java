package com.shahriyar.myexpensecalculator.DTO;

import java.util.Map;

//FOR TESTING PURPOSES ONLY
public class GlobalDTO {
    private final Map<String, String> dtoObject;

    public GlobalDTO(Map<String, String> dtoObject) {
        this.dtoObject = dtoObject;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{" + System.lineSeparator());
        dtoObject.forEach((k,v) -> result.append(String.format("\t%s : %s%n", k, v)));
        result.append("}");
        return result.toString();
    }
}

