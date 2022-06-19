package com.shahriyar.myexpensecalculator.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shahriyar.myexpensecalculator.DTO.AllEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayEntity {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private Long dailySettlement;

    private Long dailyDebit;

    private Long dailyCredit;

    private Integer dayNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExpenseEntity> dailyExpenses = new LinkedList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private MonthEntity monthEntity;

    public DayEntity(AllEntityDTO monthEntityDTO, Long id, MonthEntity monthEntity) {
        setId(id);
        setDailyDebit(monthEntityDTO.getDailyDebit());
        setDailyCredit(monthEntityDTO.getDailyCredit());
        setDailySettlement(monthEntityDTO.getDailySettlement());
        setDayNumber(monthEntityDTO.getDayNumber());
        setMonthEntity(monthEntity);
    }

}
