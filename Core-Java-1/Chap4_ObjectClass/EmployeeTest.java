package Chap4_ObjectClass;
import java.time.*;
import java.util.Objects;
import java.util.Random;

/**
 * This program tests the Employee class
 * @version 1.0 2024-07-04
 * @author
 */
public class EmployeeTest {

    public static void main (String[] args)
    {
       var staff = new Employee[3];
       staff[0] = new Employee("Carl Cracket",  750000,  LocalDate.of(1987, 12 , 15));
       staff[1] = new Employee("Harry Hacker",  50000,  LocalDate.of(1989, 10 , 1));
       staff[2] = new Employee("Tony Tester",  40000,  LocalDate.of(1990, 3 , 15));
       //staff[2] = new Employee(null,  40000,  LocalDate.of(1990, 3 , 15));
       for(var e: staff)
        e.raiseSalary(5);
        for(var e: staff)
       {
        System.out.println(e.toString());
       }
    //    for(var e: staff)
    //    {
    //     // e.setId();
    //     System.out.println(e.toString());
    //    }
       int n = Employee.getNextId();
       System.out.println("Next availabe id = "+n);
       

       
      
       
    }

}
class Employee
{
    private static int nextId;

    private String name="";//instance field initialization
    private double salary;
    private LocalDate hireDay;
    private int id;
    //static initialization block
    static {
        var generator = new Random();
        nextId = generator.nextInt(10000);
    }
    //object initialization block
    {
        id = nextId;
        nextId++;
    }
    //2 overloaded constructors
    public Employee(String name, double salary, LocalDate hireDay) {
        //require the name is nonull
        Objects.requireNonNull(name, "The name cannot be null");
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
        // id=0;
    }
    
    public Employee() {
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public LocalDate getHireDay() {
        //Never write accessor methods that return references to mutable objects
        return hireDay;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }
    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent/100;
        salary+=raise;
    }
    // public void setId() {
    //     id = nextId;
    //     nextId++;
    // }
    
    public static int getNextId() {
        return nextId;
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + ", id=" + id + "]";
    }
    public static void main(String[] args) //unit Test
    {
        var e = new Employee("Harry", 1000, LocalDate.of(1990,12,12));
        System.out.println(e.toString());
    }
    
}
