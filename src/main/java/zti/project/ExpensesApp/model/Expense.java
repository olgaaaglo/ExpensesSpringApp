package zti.project.ExpensesApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private int amount;
    private String date;
    private String label;

    public String toString() {
        return name + " (amount: " + amount + ", date: " + date + ", label: " + label + ")";
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public long getId() {
//        return id;
//    }

//    @Column(name = "labels", nullable = true)
//    public String[] getLabels() {
//        return labels;
//    }
//    public void setLabels(List<String> labels) {
//        this.labels = labels;
//    }


//    public void setId(long id) {
//        this.id = id;
//    }
//
//    @Column(name = "fname", nullable = false)
//    public String getFname() {
//        return fname;
//    }
//    public void setFname(String firstName) {
//        this.fname = firstName;
//    }
//
//    @Override
//    public String toString() {
//        return "Person [id=" + id + ", firstName=" + name
//                + "]";
//    }

}
