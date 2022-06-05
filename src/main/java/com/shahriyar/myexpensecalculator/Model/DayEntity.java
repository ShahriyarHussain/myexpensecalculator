package com.shahriyar.myexpensecalculator.Model;

import com.shahriyar.myexpensecalculator.DTO.ExpenseDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayEntity {

    @Id
    private Long id;

    private Long dailySettlement;

    private Long dailyDebit;

    private Long dailyCredit;

    private Integer dayNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExpenseEntity> dailyExpenses = new LinkedList<>();

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "month")
    private MonthEntity monthEntity;

}
