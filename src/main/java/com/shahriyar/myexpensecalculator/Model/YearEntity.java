package com.shahriyar.myexpensecalculator.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YearEntity {

        @Id
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        private Long id;

        private Long yearlyDebit;

        private Long yearlyCredit;

        private Long yearlySettlement;

        private Integer yearNumber;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<MonthEntity> monthEntityList;

    public YearEntity(AllEntityDTO yearEntityDTO, Long id) {
        this.id = id;
        this.yearlyDebit = yearEntityDTO.getYearlyDebit();
        this.yearlyCredit = yearEntityDTO.getYearlyCredit();
        this.yearlySettlement = yearEntityDTO.getYearlySettlement();
        this.yearNumber = yearEntityDTO.getYearNumber();
    }

    public void addMonthToYear(MonthEntity monthEntity) {
        monthEntityList.add(monthEntity);
    }

}
