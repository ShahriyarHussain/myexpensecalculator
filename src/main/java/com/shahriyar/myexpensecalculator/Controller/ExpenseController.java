package com.shahriyar.myexpensecalculator.Controller;

import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.Model.ExpenseEntity;
import com.shahriyar.myexpensecalculator.Service.ExpenseEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseEntityService expenseEntityService;

    public ExpenseController(ExpenseEntityService expenseEntityService) {
        this.expenseEntityService = expenseEntityService;
    }

    @GetMapping("/get-expense-by-id/{id}")
    public ResponseEntity<ExpenseEntity> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseEntityService.findExpenseEntityById(id));
    }

    @PostMapping("/add-expense")
    public ResponseEntity<ExpenseEntity> addNewExpense(@RequestBody Map<String, String> expenseDTO) {
        return ResponseEntity.ok(expenseEntityService.addNewExpenseEntity(new AllEntityDTO(expenseDTO)));
    }

    @PutMapping("/mod-expense/{id}")
    public ResponseEntity<ExpenseEntity> modifyExpense(@RequestBody Map<String, String> expenseDTO, @PathVariable Long id) {
        return ResponseEntity.ok(expenseEntityService.modifyExpenseEntity(new AllEntityDTO(expenseDTO), id));
    }

    //FOR TESTING PURPOSES ONLY
    @PostMapping("/add-expense2")
    public ResponseEntity<String> addExpenseFromGlobalDTO(@RequestBody Map<String, String> expenseDTO) {
        return ResponseEntity.ok(new AllEntityDTO(expenseDTO).toString());
    }
}
