package com.shahriyar.myexpensecalculator.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class MonthEntity {

    @Id
    @JsonIgnore
    private Long id;

    private Long monthlyDebit;

    private Long monthlyCredit;

    private Long monthlySettlement;

    private Integer monthNumber;

    @OneToMany(mappedBy = "DayEntity")
    private Set<DayEntity> dayEntityList;
}
