package com.shahriyar.myexpensecalculator.Repository;

import com.shahriyar.myexpensecalculator.Model.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ExpenseEntityRepository extends JpaRepository<ExpenseEntity, Long> {



}
