package com.shahriyar.myexpensecalculator.Service;

import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.Exception.EntityAlreadyExists;
import com.shahriyar.myexpensecalculator.Exception.EntityNotFoundException;
import com.shahriyar.myexpensecalculator.Model.DayEntity;
import com.shahriyar.myexpensecalculator.Model.MonthEntity;
import com.shahriyar.myexpensecalculator.Repository.DayEntityRepository;
import com.shahriyar.myexpensecalculator.util.IdProducerUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DayEntityService {

    private final DayEntityRepository dayEntityRepository;
    private final MonthEntityService monthEntityService;

    public DayEntityService(DayEntityRepository dayEntityRepository, MonthEntityService monthEntityService) {
        this.dayEntityRepository = dayEntityRepository;
        this.monthEntityService = monthEntityService;
    }

    public DayEntity addNewDayEntity(AllEntityDTO dayEntityDTO) {
        Long monthId = IdProducerUtil.produceId(LocalDateTime.now(), "MONTH");
        if (!monthEntityService.existsMonthById(monthId)) {
            throw new EntityNotFoundException("Month Entity Doesn't exist for this day");
        }

        Long dayId = IdProducerUtil.produceId(LocalDateTime.now(), "DAY");
        if (existsDayById(dayId)) {
            throw new EntityAlreadyExists("The day entity is already added");
        }
        return dayEntityRepository.save(new DayEntity(dayEntityDTO, dayId, monthEntityService.findMonthEntityById(monthId)));
    }

    public boolean existsDayById(Long id) {
        return dayEntityRepository.existsById(id);
    }

    public DayEntity findDayEntityById(Long id) {
        return dayEntityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
