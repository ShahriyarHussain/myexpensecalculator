package com.shahriyar.myexpensecalculator.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shahriyar.myexpensecalculator.DTO.ExpenseDTO;
import com.shahriyar.myexpensecalculator.Enum.ExpenseCategory;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
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
        this.category = ExpenseCategory.valueOf(expenseDTO.getCategory());
        this.amount = expenseDTO.getAmount();
        this.quantity = expenseDTO.getQuantity();
        this.type = expenseDTO.isType();
    }
}
