package Chap9_Collection.map;
import java.util.*;

import Chap5_Inheritance.inheritance.Employee;

public class MapTest {
    public static void main(String[] args) {
        var staff = new HashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));

        // //print all entries
        // System.out.println(staff);
        // //remove an entry
        // staff.remove("567-24-2546");
        // //replace an entry
        // staff.put("456-62-5527", new Employee("Francesca Miller"));
        // //look up a value
        // System.out.println(staff.get("157-62-7935"));
        // //iterate through all entries
        // staff.forEach((k,v) -> 
        // System.out.println("key="+k+" , value="+v));
        var counts = new HashMap<String, Integer>();
        counts.merge("word", 1, (v1,v2)->Integer.sum(v1,v2));
        counts.merge("word", 1, (v1,v2)->Integer.sum(v1,v2));
        counts.forEach((k,v)->System.out.println("key="+k+" , value="+v));

    }

}
