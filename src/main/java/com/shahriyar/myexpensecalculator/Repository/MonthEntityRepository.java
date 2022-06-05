package com.shahriyar.myexpensecalculator.Repository;

import com.shahriyar.myexpensecalculator.Model.MonthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface MonthEntityRepository extends JpaRepository<MonthEntity, Long> {
}
