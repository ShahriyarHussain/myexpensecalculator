package com.shahriyar.myexpensecalculator.Controller;

import com.shahriyar.myexpensecalculator.DTO.ExpenseDTO;
import com.shahriyar.myexpensecalculator.Model.ExpenseEntity;
import com.shahriyar.myexpensecalculator.Service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/getexpensebyid/{id}")
    public ResponseEntity<ExpenseEntity> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.getExpenseEntityById(id));
    }

    @PostMapping("/addexpense")
    public ResponseEntity<ExpenseEntity> addNewExpense(ExpenseDTO expenseDTO) {
        return ResponseEntity.ok(expenseService.addNewExpenseEntity(expenseDTO));
    }

    @PutMapping("/modexpense")
    public ResponseEntity<ExpenseEntity> modifyExpense(ExpenseDTO expenseDTO, Long id) {
        return ResponseEntity.ok(expenseService.modifyExpenseEntity(expenseDTO, id));
    }
}
