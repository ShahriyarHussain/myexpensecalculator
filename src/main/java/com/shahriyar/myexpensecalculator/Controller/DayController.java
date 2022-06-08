package com.shahriyar.myexpensecalculator.Controller;

import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.Model.DayEntity;
import com.shahriyar.myexpensecalculator.Model.ExpenseEntity;
import com.shahriyar.myexpensecalculator.Service.DayEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/day")
public class DayController {

    private final DayEntityService dayEntityService;

    public DayController(DayEntityService dayEntityService) {
        this.dayEntityService = dayEntityService;
    }

    @GetMapping("/get-day-by-id/{id}")
    public ResponseEntity<DayEntity> getDayById(@PathVariable Long id) {
        return ResponseEntity.ok(dayEntityService.findDayEntityById(id));
    }

    @PostMapping("/add-day")
    public ResponseEntity<DayEntity> addNewExpense(@RequestBody Map<String, String> expenseDTO) {
        return ResponseEntity.ok(dayEntityService.addNewDayEntity(new AllEntityDTO(expenseDTO)));
    }

//    @PutMapping("/mod-expense/{id}")
//    public ResponseEntity<DayEntity> modifyExpense(@RequestBody Map<String, String> expenseDTO, @PathVariable Long id) {
//        return ResponseEntity.ok(dayEntityService.modifyDayEntity(new AllEntityDTO(expenseDTO), id));
//    }
}
