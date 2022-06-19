package com.shahriyar.myexpensecalculator.DTO;

import com.shahriyar.myexpensecalculator.Enum.ExpenseCategory;
import com.shahriyar.myexpensecalculator.Exception.BadDataFormatException;

import java.util.HashMap;
import java.util.Map;

/*
* AllEntityDTO object is a data transfer object for all entities in the project
* it works with a hashmap where the json values are received and sent via a
* key value pair. If a new entity is to be transferred using the DTO,
* add the necessary get methods in the object with proper validation and return type.
* */

public class AllEntityDTO {

    private final Map<String, String> dtoMap;

    public AllEntityDTO() {
        dtoMap = new HashMap<>();
    }

    public AllEntityDTO(Map<String, String> dtoMap) {
        this.dtoMap = dtoMap;
    }

    public Map<String, String> getDtoMap() {
        return this.dtoMap;
    }

    public void addElementToDto(String key, String value) {
        this.dtoMap.put(key, value);
    }

    // Expense Entity Getters Here
    public String getName() {
        if (!dtoMap.containsKey("name")) {
            throw new BadDataFormatException("Object does not contain name value");
        }
        return dtoMap.get("name");
    }

    public ExpenseCategory getCategory() {
        if (!dtoMap.containsKey("category")) {
            throw new BadDataFormatException("Object does not contain category value");
        }
        try {
            return ExpenseCategory.valueOf(dtoMap.get("category"));
        } catch (IllegalArgumentException e) {
            throw new BadDataFormatException(e.getMessage());
        }
    }

    public Boolean getType() {
        if (!dtoMap.containsKey("type")) {
            throw new BadDataFormatException("Object does not contain type value");
        }
        if (dtoMap.get("type").equals("true")) {
            return true;
        }
        if (dtoMap.get("type").equals("false")) {
            return false;
        }
        throw new BadDataFormatException("Type value must be boolean (either true or false)");
    }

    public Integer getAmount() {
        if (!dtoMap.containsKey("amount")) {
            throw new BadDataFormatException("Object does not contain amount value");
        }
        int amount;
        try {
            amount = Integer.parseInt(dtoMap.get("amount"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return amount;
    }

    public Integer getQuantity() {
        if (!dtoMap.containsKey("quantity")) {
            throw new BadDataFormatException("Object does not contain quantity value");
        }
        int quantity;
        try {
            quantity = Integer.parseInt(dtoMap.get("quantity"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return quantity;
    }

    //Day Entity Getters Here
    public Long getDailySettlement() {
        if (!dtoMap.containsKey("dailySettlement")) {
            throw new BadDataFormatException("Object does not contain dailySettlement value");
        }
        long dailySettlement;
        try {
            dailySettlement = Long.parseLong(dtoMap.get("dailySettlement"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return dailySettlement;
    }

    public Long getDailyDebit() {
        if (!dtoMap.containsKey("dailyDebit")) {
            throw new BadDataFormatException("Object does not contain dailyDebit value");
        }
        long dailyDebit;
        try {
            dailyDebit = Long.parseLong(dtoMap.get("dailyDebit"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return dailyDebit;
    }

    public Long getDailyCredit() {
        if (!dtoMap.containsKey("dailyCredit")) {
            throw new BadDataFormatException("Object does not contain dailyCredit value");
        }
        long dailyCredit;
        try {
            dailyCredit = Long.parseLong(dtoMap.get("dailyCredit"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return dailyCredit;
    }

    public Integer getDayNumber() {
        if (!dtoMap.containsKey("dayNumber")) {
            throw new BadDataFormatException("Object does not contain dayNumber value");
        }
        int dayNumber;
        try {
            dayNumber = Integer.parseInt(dtoMap.get("dayNumber"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return dayNumber;
    }

    //Month Entity Getters Here
    public Long getMonthlySettlement() {
        if (!dtoMap.containsKey("monthlySettlement")) {
            throw new BadDataFormatException("Object does not contain monthlySettlement value");
        }
        long monthlySettlement;
        try {
            monthlySettlement = Long.parseLong(dtoMap.get("monthlySettlement"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return monthlySettlement;
    }

    public Long getMonthlyDebit() {
        if (!dtoMap.containsKey("monthlyDebit")) {
            throw new BadDataFormatException("Object does not contain monthlyDebit value");
        }
        long monthlyDebit;
        try {
            monthlyDebit = Long.parseLong(dtoMap.get("monthlyDebit"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return monthlyDebit;
    }

    public Long getMonthlyCredit() {
        if (!dtoMap.containsKey("monthlyCredit")) {
            throw new BadDataFormatException("Object does not contain monthlyCredit value");
        }
        long monthlyCredit;
        try {
            monthlyCredit = Long.parseLong(dtoMap.get("monthlyCredit"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return monthlyCredit;
    }

    public Integer getMonthNumber() {
        if (!dtoMap.containsKey("monthNumber")) {
            throw new BadDataFormatException("Object does not contain monthNumber value");
        }
        int monthNumber;
        try {
            monthNumber = Integer.parseInt(dtoMap.get("monthNumber"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return monthNumber;
    }

    //Year Entity Getters Here
    public Long getYearlySettlement() {
        if (!dtoMap.containsKey("yearlySettlement")) {
            throw new BadDataFormatException("Object does not contain yearlySettlement value");
        }
        long yearlySettlement;
        try {
            yearlySettlement = Long.parseLong(dtoMap.get("yearlySettlement"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return yearlySettlement;
    }

    public Long getYearlyDebit() {
        if (!dtoMap.containsKey("yearlyDebit")) {
            throw new BadDataFormatException("Object does not contain yearlyDebit value");
        }
        long yearlyDebit;
        try {
            yearlyDebit = Long.parseLong(dtoMap.get("yearlyDebit"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return yearlyDebit;
    }

    public Long getYearlyCredit() {
        if (!dtoMap.containsKey("yearlyCredit")) {
            throw new BadDataFormatException("Object does not contain yearlyCredit value");
        }
        long yearlyCredit;
        try {
            yearlyCredit = Long.parseLong(dtoMap.get("yearlyCredit"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return yearlyCredit;
    }

    public Integer getYearNumber() {
        if (!dtoMap.containsKey("yearNumber")) {
            throw new BadDataFormatException("Object does not contain yearNumber value");
        }
        int yearNumber;
        try {
            yearNumber = Integer.parseInt(dtoMap.get("yearNumber"));
        } catch (NumberFormatException e) {
            throw new BadDataFormatException(e.getMessage());
        }
        return yearNumber;
    }

    public Map<String, String> getDTOMap() {
        return this.dtoMap;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{\n");
        this.dtoMap.forEach((k,v) ->
                result.append("\t").append(k).append(" : ").append(v).append(",").append(System.lineSeparator()));
        return result.append("}").toString();
    }

}
