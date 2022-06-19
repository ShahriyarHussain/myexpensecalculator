package com.shahriyar.myexpensecalculator.Service;

import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import com.shahriyar.myexpensecalculator.Exception.EntityAlreadyExists;
import com.shahriyar.myexpensecalculator.Exception.EntityNotFoundException;
import com.shahriyar.myexpensecalculator.Model.MonthEntity;
import com.shahriyar.myexpensecalculator.Model.YearEntity;
import com.shahriyar.myexpensecalculator.Repository.YearEntityRepository;
import com.shahriyar.myexpensecalculator.util.IdProducerUtil;
import org.springframework.stereotype.Service;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.util.Map;

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

    public void addMonthToYear(MonthEntity monthEntity, YearEntity yearEntity) {
        yearEntity.addMonthToYear(monthEntity);
        yearEntityRepository.save(yearEntity);
    }

    public Map<String, String> returnEntityDataAsDTO(YearEntity yearEntity) {
        AllEntityDTO allEntityDTO = new AllEntityDTO();
        allEntityDTO.addElementToDto("yearDebit", yearEntity.getYearlyDebit().toString());
        allEntityDTO.addElementToDto("yearCredit", yearEntity.getYearlyCredit().toString());
        allEntityDTO.addElementToDto("yearlySettlement", yearEntity.getYearlySettlement().toString());
        allEntityDTO.addElementToDto("yearNumber", yearEntity.getYearNumber().toString());
        StringBuilder monthListString = new StringBuilder();
        monthListString.append("[");
        if (yearEntity.getMonthEntityList() != null) {
            monthListString.append(System.lineSeparator());
            for (MonthEntity m : yearEntity.getMonthEntityList()) {
                monthListString.append(new DateFormatSymbols().getMonths()[m.getMonthNumber() - 1]).
                        append(",").append(System.lineSeparator());
            }
        }
        monthListString.append(System.lineSeparator()).append("\t]");
        allEntityDTO.addElementToDto("months", monthListString.toString());
        System.err.println(allEntityDTO);
        return allEntityDTO.getDTOMap();
    }
}
