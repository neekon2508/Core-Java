package Chap5_Inheritance.inheritance;
/**
 * This program demonstrates inheritance between superclass Employee and subclass Manager
 * @version 1.0 2024-07-05
 * @author Neekon
 */
public class ManagerTest {
    public static void main(String[] args) {
        var boss = new Manager("Carl Craker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        var staff = new Employee[3];
        staff[0] = boss;
        var manager = (Manager) staff[0];
        manager.setBonus(500);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

        for(Employee e : staff)
          System.out.println("name="+e.getName()+",salary="+e.getSalary());
        System.err.println(manager.getName()+manager.getSalary());
    }
}
