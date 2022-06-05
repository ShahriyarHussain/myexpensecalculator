package com.shahriyar.myexpensecalculator.Service;

import com.shahriyar.myexpensecalculator.DTO.ExpenseDTO;
import com.shahriyar.myexpensecalculator.Enum.ExpenseCategory;
import com.shahriyar.myexpensecalculator.Exception.BadDataFormatException;
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

    public ExpenseEntity addNewExpenseEntity(ExpenseDTO expenseDTO) {
        return expenseEntityRepository.save(new ExpenseEntity(expenseDTO));
    }

    public ExpenseEntity getExpenseEntityById(Long id) {
        return expenseEntityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public ExpenseEntity modifyExpenseEntity(ExpenseDTO expenseDTO, Long id) {
        ExpenseEntity expenseEntity = expenseEntityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        expenseEntity.setAmount(expenseDTO.getAmount());
        expenseEntity.setQuantity(expenseDTO.getQuantity());
        try {
            expenseEntity.setCategory(ExpenseCategory.valueOf(expenseDTO.getCategory()));
        } catch (IllegalArgumentException ex) {
            throw new BadDataFormatException("Invalid category type");
        }
        expenseEntity.setName(expenseDTO.getName());
        return expenseEntityRepository.save(expenseEntity);
    }
}
