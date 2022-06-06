package com.shahriyar.myexpensecalculator.DTO;

import com.shahriyar.myexpensecalculator.Enum.ExpenseCategory;
import com.shahriyar.myexpensecalculator.Exception.BadDataFormatException;

import java.util.Map;

public class AllEntityDTO {

    private final Map<String, String> dtoMap;

    public AllEntityDTO(Map<String, String> dtoMap) {
        this.dtoMap = dtoMap;
    }

    public String getName() {
        if (!dtoMap.containsKey("name")) {
            throw new BadDataFormatException("Object does not contain name");
        }
        return dtoMap.get("name");
    }

    public ExpenseCategory getCategory() {
        if (!dtoMap.containsKey("category")) {
            throw new BadDataFormatException("Object does not contain category");
        }
        try {
            return ExpenseCategory.valueOf(dtoMap.get("category"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw new BadDataFormatException("Invalid category provided");
        }
    }
}
