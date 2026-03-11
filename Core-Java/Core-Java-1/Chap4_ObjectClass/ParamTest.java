package Chap4_ObjectClass;

/**
 * This program demonstrates parameter passing in Java  
 * @version 1.0 2024-07-04
 * @author Neekon
 */
public class ParamTest {
    public static void main (String[] args)
    {
            /*
        * Test 1: Methods can't modify numeric parameters
        */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);tripleValue(percent);
        System.out.println("After: percent=" + percent);
        /*
        * Test 2: Methods can change the state of object parameters
        */
        System.out.println("\nTesting tripleSalary:");
        var harry = new EmployeeSimple("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

        /*E
        29 * Test 3: Methods can't attach new objects to object parameters
        30 */
        System.out.println("\nTesting swap:");
        var a = new EmployeeSimple("Alice", 70000);
        var b = new EmployeeSimple("Bob", 60000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }


public static void tripleValue(double x)
{
    x = 3*x;
    System.out.println("End of method: x="+x);
}
public static void tripleSalary(EmployeeSimple x)
{
    x.raiseSalary(200);
    System.out.println("End of method: salary="+x.getSalary());
}
public static void swap(EmployeeSimple x, EmployeeSimple y)
{
    EmployeeSimple temp = x;
    x = y;
    y = temp;
    System.out.println("End of method: x="+x.getName());
    System.out.println("End of method: y="+y.getName());


}
}
class EmployeeSimple {
    private String name;
    private double salary;
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public EmployeeSimple(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public void raiseSalary(double byPercent)
    {
        salary+=salary*byPercent/100;
    }

}