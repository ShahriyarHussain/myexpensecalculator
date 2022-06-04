package com.shahriyar.myexpensecalculator.Service;

import com.shahriyar.myexpensecalculator.DTO.ExpenseDTO;
import com.shahriyar.myexpensecalculator.Model.ExpenseEntity;
import com.shahriyar.myexpensecalculator.Repository.ExpenseEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseEntityRepository expenseEntityRepository;

    public ExpenseService(ExpenseEntityRepository expenseEntityRepository) {
        this.expenseEntityRepository = expenseEntityRepository;
    }

    public void addNewExpense(ExpenseDTO expenseDTO) {
        expenseEntityRepository.save(new ExpenseEntity(expenseDTO));
    }
}
