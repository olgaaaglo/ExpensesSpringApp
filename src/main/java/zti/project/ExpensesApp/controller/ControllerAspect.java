package zti.project.ExpensesApp.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import zti.project.ExpensesApp.model.Expense;

import java.util.ArrayList;


@Aspect
@Configuration
public class ControllerAspect {

    @Around("execution(* getExpense(..))")
    public Object aroundGetExpense(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Finding expense...");
        Object ret = pjp.proceed();

        Expense ex = (Expense)ret;
        System.out.println("Expense found: " + ex.toString());
        return ret;
    }

    @Around("execution(* getAllExpenses(..))")
    public Object aroundGetAllExpenses(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Finding expenses...");
        Object ret = pjp.proceed();

        ArrayList<Expense> exList = (ArrayList<Expense>)ret;
        System.out.println("Expenses found: ");
        for(Expense ex : exList) {
            System.out.println(ex.toString());
        }
        return ret;
    }

    @Around("execution(* createExpense(..))")
    public Object aroundCreateExpense(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Creating expense...");
        Object ret = pjp.proceed();

        Expense ex = (Expense)ret;
        System.out.println("Expense created: " + ex.toString());
        return ret;
    }

    @Around("execution(* updateExpense(..))")
    public Object aroundUpdateExpense(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Updating expense...");
        Object ret = pjp.proceed();

        ResponseEntity<Expense> ent = (ResponseEntity<Expense>)ret;
        Expense ex = ent.getBody();
        System.out.println("Expense updated: " + ex.toString());
        return ret;
    }

    @Around("execution(* deleteExpense(..))")
    public Object aroundDeleteExpense(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Deleting expense...");
        Object ret = pjp.proceed();

        System.out.println("Expense deleted");
        return ret;
    }

    @Pointcut("target(zti.project.ExpensesApp.controller.ExpenseController)")
    public void controllerThrow() {};

    @AfterThrowing(pointcut = "controllerThrow()", throwing = "exception")
    public Object afterThrowingExampleMethod(Object exception) {
        System.out.println("Operation not completed, exception: " + exception.toString());
        return exception;
    }
}

