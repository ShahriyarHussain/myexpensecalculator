package com.shahriyar.myexpensecalculator.DTO;

import com.shahriyar.myexpensecalculator.Enum.ExpenseCategory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
public class ExpenseDTO {

    private String name;

    private String category;

    private boolean type;

    private int amount;

    private int quantity;
}
