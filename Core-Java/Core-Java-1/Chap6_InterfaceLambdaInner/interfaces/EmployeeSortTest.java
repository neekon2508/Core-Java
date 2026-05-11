package Chap6_InterfaceLambdaInner.interfaces;
import java.util.*;

/**
 * This program demonstrates the use of the Comparable interface
 * @version 1.0 2024-07-05
 * @author Neekon 
 */
public class EmployeeSortTest {
    public static void main(String[] args) {
        var staff = new Employee[3];
        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        Arrays.sort(staff);
        for (var e : staff)
          System.out.println("name="+e.getName()+",salary="+e.getSalary());
        Arrays.sort(staff, Comparator.comparing(Employee::getSalary, Comparator.nullsFirst(Comparator.naturalOrder())));
        for (var e : staff)
          System.out.println("name="+e.getName()+",salary="+e.getSalary());


    }
}
