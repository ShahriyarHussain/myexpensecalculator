package com.shahriyar.myexpensecalculator.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shahriyar.myexpensecalculator.DTO.ExpenseDTO;
import com.shahriyar.myexpensecalculator.Enum.ExpenseCategory;
import com.shahriyar.myexpensecalculator.Exception.BadDataFormatException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String name;

    private ExpenseCategory category;

    private boolean type;

    private int amount;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "day")
    private DayEntity day;

    public ExpenseEntity(ExpenseDTO expenseDTO) {
        this.name = expenseDTO.getName();
        try {
            this.category = ExpenseCategory.valueOf(expenseDTO.getCategory());
        } catch (Exception e) {
            throw new BadDataFormatException(e.getMessage());
        }
        this.amount = expenseDTO.getAmount();
        this.quantity = expenseDTO.getQuantity();
        this.type = expenseDTO.isType();
    }
}
