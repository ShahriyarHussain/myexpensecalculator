package com.shahriyar.myexpensecalculator.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.Enum.ExpenseCategory;
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

    private Boolean type;

    private Integer amount;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private DayEntity day;

    public ExpenseEntity(AllEntityDTO expenseDTO, DayEntity dayEntity) {
        this.name = expenseDTO.getName();
        this.category = expenseDTO.getCategory();
        this.amount = expenseDTO.getAmount();
        this.quantity = expenseDTO.getQuantity();
        this.type = expenseDTO.getType();
        this.day = dayEntity;
    }
}
