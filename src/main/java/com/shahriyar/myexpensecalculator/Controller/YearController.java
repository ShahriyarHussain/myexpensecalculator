package com.shahriyar.myexpensecalculator.Controller;

import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.Model.YearEntity;
import com.shahriyar.myexpensecalculator.Service.YearEntityService;
import com.shahriyar.myexpensecalculator.util.IdProducerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/year")
public class YearController {

    private final YearEntityService yearEntityService;

    public YearController(YearEntityService yearEntityService) {
        this.yearEntityService = yearEntityService;
    }

    @GetMapping("/get-year-by-id/{id}")
    public ResponseEntity<YearEntity> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(yearEntityService.findYearEntityById(id));
    }

    @PostMapping("/add-year")
    public ResponseEntity<YearEntity> addNewExpense(@RequestBody Map<String, String> expenseDTO) {
        return ResponseEntity.ok(yearEntityService.addNewYearEntity(new AllEntityDTO(expenseDTO)));
    }
}
