package zti.project.ExpensesApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zti.project.ExpensesApp.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
