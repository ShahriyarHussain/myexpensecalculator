package com.shahriyar.myexpensecalculator.Repository;

import com.shahriyar.myexpensecalculator.Model.DayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface DayEntityRepository extends JpaRepository<DayEntity, Long> {
}
