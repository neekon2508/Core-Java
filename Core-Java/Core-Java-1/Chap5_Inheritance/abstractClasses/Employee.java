package Chap5_Inheritance.abstractClasses;

import java.time.LocalDate;

public class Employee extends Person{

    private double salary;
    private LocalDate hireDay;
    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, month);

        //TODO Auto-generated constructor stub
    }
    public double getSalary() {
        return salary;
    }
    public LocalDate getHireDay() {
        return hireDay;
    }
    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return String.format("an employee with a salary of %.2f", salary);
    }
    public void raiseSalary(double byPercent)
    {
        salary += salary*byPercent/100;
    }
    
    

}
