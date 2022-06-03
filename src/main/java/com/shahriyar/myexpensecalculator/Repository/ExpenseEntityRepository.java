package com.shahriyar.myexpensecalculator.Repository;

import com.shahriyar.myexpensecalculator.Model.ExpenseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseEntityRepository extends CrudRepository<Long, ExpenseEntity> {
}
