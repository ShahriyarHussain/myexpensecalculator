package com.shahriyar.myexpensecalculator.Service;

import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.Exception.EntityAlreadyExists;
import com.shahriyar.myexpensecalculator.Exception.EntityNotFoundException;
import com.shahriyar.myexpensecalculator.Model.YearEntity;
import com.shahriyar.myexpensecalculator.Repository.YearEntityRepository;
import com.shahriyar.myexpensecalculator.util.IdProducerUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class YearEntityService {

    private final YearEntityRepository yearEntityRepository;

    public YearEntityService(YearEntityRepository yearEntityRepository) {
        this.yearEntityRepository = yearEntityRepository;
    }

    public YearEntity addNewYearEntity(AllEntityDTO yearEntityDTO) {
        Long id = IdProducerUtil.produceId(LocalDateTime.now(), "YEAR");
        if (existsYearById(id)) {
            throw new EntityAlreadyExists("The year entity is already added");
        }
        return yearEntityRepository.save(new YearEntity(yearEntityDTO, id));
    }

    public boolean existsYearById(Long id) {
        return yearEntityRepository.existsById(id);
    }

    public YearEntity findYearEntityById(Long id) {
        return yearEntityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
