package com.shahriyar.myexpensecalculator.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExpenseDTO {

    private String name;

    private String category;

    private boolean type;

    private int amount;

    private int quantity;

}
