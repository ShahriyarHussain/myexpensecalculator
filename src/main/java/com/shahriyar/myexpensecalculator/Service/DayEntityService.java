package com.shahriyar.myexpensecalculator.Service;

import com.shahriyar.myexpensecalculator.Model.DayEntity;
import com.shahriyar.myexpensecalculator.Repository.DayEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class DayEntityService {

    private final DayEntityRepository dayEntityRepository;

    public DayEntityService(DayEntityRepository dayEntityRepository) {
        this.dayEntityRepository = dayEntityRepository;
    }

//  TODO: public DayEntity addDayEntity()
}
