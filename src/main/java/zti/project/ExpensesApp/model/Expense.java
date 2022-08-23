package zti.project.ExpensesApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Klasa reprezentujaca tabele w bazie danych - wydatek
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double amount;
    private String date;
    private String label;

    public String toString() {
        return name + " (amount: " + amount + ", date: " + date + ", label: " + label + ")";
    }
}
