package com.shahriyar.myexpensecalculator.Service;

import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.Exception.EntityNotFoundException;
import com.shahriyar.myexpensecalculator.Model.ExpenseEntity;
import com.shahriyar.myexpensecalculator.Repository.ExpenseEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseEntityService {

    private final ExpenseEntityRepository expenseEntityRepository;

    public ExpenseEntityService(ExpenseEntityRepository expenseEntityRepository) {
        this.expenseEntityRepository = expenseEntityRepository;
    }

    public ExpenseEntity addNewExpenseEntity(AllEntityDTO expenseDTO) {
        return expenseEntityRepository.save(new ExpenseEntity(expenseDTO));
    }

    public ExpenseEntity getExpenseEntityById(Long id) {
        return expenseEntityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public ExpenseEntity modifyExpenseEntity(AllEntityDTO expenseDTO, Long id) {
        ExpenseEntity expenseEntity = expenseEntityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        expenseEntity.setAmount(expenseDTO.getAmount());
        expenseEntity.setQuantity(expenseDTO.getQuantity());
        expenseEntity.setCategory(expenseDTO.getCategory());
        expenseEntity.setName(expenseDTO.getName());
        return expenseEntityRepository.save(expenseEntity);
    }
}
