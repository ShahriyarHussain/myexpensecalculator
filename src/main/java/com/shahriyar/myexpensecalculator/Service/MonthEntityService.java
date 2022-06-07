package com.shahriyar.myexpensecalculator.Service;

import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.Exception.EntityAlreadyExists;
import com.shahriyar.myexpensecalculator.Exception.EntityNotFoundException;
import com.shahriyar.myexpensecalculator.Model.MonthEntity;
import com.shahriyar.myexpensecalculator.Repository.MonthEntityRepository;
import com.shahriyar.myexpensecalculator.util.IdProducerUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MonthEntityService {

    private final MonthEntityRepository monthEntityRepository;
    private final YearEntityService yearEntityService;

    public MonthEntityService(MonthEntityRepository monthEntityRepository, YearEntityService yearEntityService) {
        this.monthEntityRepository = monthEntityRepository;
        this.yearEntityService = yearEntityService;
    }

    public MonthEntity addNewMonthEntity(AllEntityDTO monthEntityDTO) {
        Long yearId = IdProducerUtil.produceId(LocalDateTime.now(), "YEAR");
        if (!yearEntityService.existsYearById(yearId)) {
            throw new EntityNotFoundException("Year Entity Doesn't exist for this day");
        }

        Long monthId = IdProducerUtil.produceId(LocalDateTime.now(), "MONTH");
        if (existsMonthById(monthId)) {
            throw new EntityAlreadyExists("The month entity is already added");
        }
        return monthEntityRepository.save(new MonthEntity(monthEntityDTO, monthId, yearEntityService.findYearEntityById(yearId)));
    }

    public boolean existsMonthById(Long id) {
        return monthEntityRepository.existsById(id);
    }

    public MonthEntity findMonthEntityById(Long id) {
        return monthEntityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }



}
