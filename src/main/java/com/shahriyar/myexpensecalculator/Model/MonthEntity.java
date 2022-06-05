package com.shahriyar.myexpensecalculator.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonthEntity {

    @Id
    private Long id;

    private Long monthlyDebit;

    private Long monthlyCredit;

    private Long monthlySettlement;

    private Integer monthNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DayEntity> dayEntityList;
}
