package com.shahriyar.myexpensecalculator.Model;

import com.shahriyar.myexpensecalculator.DTO.ExpenseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class DayEntity {

    @Id
    private Long id;

    private Long dailySettlement;

    private Long dailyDebit;

    private Long dailyCredit;

    private Integer dayNumber;

    @ElementCollection
    private List<Long> dailyExpenses = new LinkedList<>();

    @ManyToOne
    private MonthEntity month;
}
