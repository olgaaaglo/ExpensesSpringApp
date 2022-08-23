package zti.project.ExpensesApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zti.project.ExpensesApp.exception.ResourceNotFoundException;
import zti.project.ExpensesApp.model.Expense;
import zti.project.ExpensesApp.repository.ExpenseRepository;

/**
 * Kontroler aplikacji - endopointy do dzialania na bazie
 */
@RestController
@RequestMapping("/api")
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpense(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found for this id: " + id));
    }

    @PostMapping("/expenses")
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @PutMapping("/expenses/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable(value = "id") Long id,
                                                 @RequestBody Expense expenseDetails) throws ResourceNotFoundException {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found for this id: " + id));

        expense.setName(expenseDetails.getName());
        expense.setAmount(expenseDetails.getAmount());
        expense.setDate (expenseDetails.getDate());
        expense.setLabel(expenseDetails.getLabel());
        final Expense updatedExpense = expenseRepository.save(expense);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/expenses/{id}")
    public Map<String, Boolean> deleteExpense(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found for this id: " + id));

        expenseRepository.delete(expense);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
