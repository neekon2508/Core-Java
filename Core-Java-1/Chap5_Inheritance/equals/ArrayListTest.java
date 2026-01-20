package Chap5_Inheritance.equals;

import java.util.ArrayList;

/**
 * This program demonstrates the ArrayList class
 * @version 1.0 2024-07-05
 * @author Neekon
 */
public class ArrayListTest {
    public static void main(String[] args) {
        var staff = new ArrayList<Employee>();
        staff.add(new Employee("Carl Hackey", 75000, 1987, 12, 15) );
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));
        staff.add(new Manager("Neekon Chan", 1000000, 2024, 10, 12));
        for(Employee e: staff) 
         System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hidreDay="+e.getHireDay());

    }
}
