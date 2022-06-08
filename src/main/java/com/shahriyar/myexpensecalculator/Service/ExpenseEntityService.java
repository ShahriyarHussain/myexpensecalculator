package com.shahriyar.myexpensecalculator.Service;

import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.Exception.EntityNotFoundException;
import com.shahriyar.myexpensecalculator.Model.ExpenseEntity;
import com.shahriyar.myexpensecalculator.Repository.ExpenseEntityRepository;
import com.shahriyar.myexpensecalculator.util.IdProducerUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExpenseEntityService {

    private final ExpenseEntityRepository expenseEntityRepository;
    private final DayEntityService dayEntityService;

    public ExpenseEntityService(ExpenseEntityRepository expenseEntityRepository, DayEntityService dayEntityService) {
        this.expenseEntityRepository = expenseEntityRepository;
        this.dayEntityService = dayEntityService;
    }

    public ExpenseEntity addNewExpenseEntity(AllEntityDTO expenseDTO) {
        Long dayId = IdProducerUtil.produceId(LocalDateTime.now(), "DAY");
        if (!dayEntityService.existsDayById(dayId)) {
            throw new EntityNotFoundException("Day Entity Doesn't exist for this expense");
        }
        return expenseEntityRepository.save(new ExpenseEntity(expenseDTO, dayEntityService.findDayEntityById(dayId)));
    }

    public ExpenseEntity findExpenseEntityById(Long id) {
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
