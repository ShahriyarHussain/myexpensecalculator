package com.shahriyar.myexpensecalculator.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonthEntity {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private Long monthlyDebit;

    private Long monthlyCredit;

    private Long monthlySettlement;

    private Integer monthNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DayEntity> dayEntityList;

    @ManyToOne(fetch = FetchType.LAZY)
    private YearEntity yearEntity;

    public MonthEntity(AllEntityDTO monthEntityDTO, Long id, YearEntity yearEntity) {
        this.id = id;
        this.monthlyDebit = monthEntityDTO.getMonthlyDebit();
        this.monthlyCredit = monthEntityDTO.getMonthlyCredit();
        this.monthlySettlement = monthEntityDTO.getMonthlySettlement();
        this.monthNumber = monthEntityDTO.getMonthNumber();
        this.yearEntity = yearEntity;
    }

    public void addDayToList(DayEntity dayEntity) {
        dayEntityList.add(dayEntity);
    }

}
