package zti.project.ExpensesApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpensesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensesAppApplication.class, args);
		System.out.println("hi");

//		PersonController pc = new PersonController();
//		pc.personRepository = new PersonRepository() {
//		}
//		pc.getAllPersons();
	}

}
