package Chap5_Inheritance.inheritance;
import java.time.*;
/**
 * The program illustrates the class of Employy
 * @version 1.0.0 2024-07-05
 * @author Neekon
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;
    public Employee(String name, double salary,int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }
    public String getName() {
        return name;
    }
    public Employee(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public LocalDate getHireDay() {
        return hireDay;
    }
    public void raiseSalary(double byPercent)
    {
        salary+=salary*byPercent/100;
    }
    
}
