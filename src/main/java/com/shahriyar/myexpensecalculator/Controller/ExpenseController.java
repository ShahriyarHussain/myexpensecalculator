package com.shahriyar.myexpensecalculator.Controller;

import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.DTO.ExpenseDTO;
import com.shahriyar.myexpensecalculator.Model.ExpenseEntity;
import com.shahriyar.myexpensecalculator.Service.ExpenseEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseEntityService expenseEntityService;

    public ExpenseController(ExpenseEntityService expenseEntityService) {
        this.expenseEntityService = expenseEntityService;
    }

    @GetMapping("/getexpensebyid/{id}")
    public ResponseEntity<ExpenseEntity> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseEntityService.getExpenseEntityById(id));
    }

    @PostMapping("/addexpense")
    public ResponseEntity<ExpenseEntity> addNewExpense(@RequestBody ExpenseDTO expenseDTO) {
        return ResponseEntity.ok(expenseEntityService.addNewExpenseEntity(expenseDTO));
    }

    @PutMapping("/modexpense/{id}")
    public ResponseEntity<ExpenseEntity> modifyExpense(@RequestBody ExpenseDTO expenseDTO, @PathVariable Long id) {
        return ResponseEntity.ok(expenseEntityService.modifyExpenseEntity(expenseDTO, id));
    }

    //FOR TESTING PURPOSES ONLY
    @PostMapping("/addexpense2")
    public ResponseEntity<String> addExpenseFromGlobalDTO(@RequestBody Map<String, String> expenseDTO) {
        return ResponseEntity.ok(new AllEntityDTO(expenseDTO).toString());
    }
}
