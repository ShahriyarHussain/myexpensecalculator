package com.shahriyar.myexpensecalculator.Controller;

import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.Model.MonthEntity;
import com.shahriyar.myexpensecalculator.Service.MonthEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/month")
public class MonthController {

    private final MonthEntityService monthEntityService;

    public MonthController(MonthEntityService monthEntityService) {
        this.monthEntityService = monthEntityService;
    }

    @GetMapping("/get-month-by-id/{id}")
    public ResponseEntity<MonthEntity> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(monthEntityService.findMonthEntityById(id));
    }

    @PostMapping("/add-month")
    public ResponseEntity<MonthEntity> addNewExpense(@RequestBody Map<String, String> expenseDTO) {
        return ResponseEntity.ok(monthEntityService.addNewMonthEntity(new AllEntityDTO(expenseDTO)));
    }

//    @PutMapping("/mod-expense/{id}")
//    public ResponseEntity<MonthEntity> modifyExpense(@RequestBody Map<String, String> expenseDTO, @PathVariable Long id) {
//        return ResponseEntity.ok(monthEntityService.modifyMonthEntity(new AllEntityDTO(expenseDTO), id));
//    }
}
