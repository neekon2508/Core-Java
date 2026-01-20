import java.util.Arrays;
import java.util.Objects;

public class ObjectTest {
    
    public static void main (String[] args)
    {
        Object a = new Person("a",100);
        Object b = new Person("a",100);
       
        Object c = "Hello";
        Object d = "Hello";

        Object e = new Manager("a",100,1000);
        Object f = new Manager("a",100,10000);

        String ab[] = new String[] {"hello","goodbye"}; 
        String bc[] = new String[] {"hello","goodbye"}; 
        System.out.println(a.equals(b));
        System.out.println(c.equals(d));
        System.out.println(e.equals(f));
        System.out.println(e.equals(d));
        System.out.println(Arrays.equals(ab, bc));
        System.out.println(a.toString());
    }
}
 class Person 
{
    private String name;
    private long age;

    public Person(String name,long age)
    {
        this.name = name;
        this.age = age;
    }
    public boolean equals(Object otherobject)
    {
        if(this == otherobject) return true;
        if(getClass() != otherobject.getClass()) return false;
        Person other = (Person) otherobject;
        return Objects.equals(name,other.name) && age==other.age;
    }
    public int hashCode()
    {
        return Objects.hash(name,age);
    }
}
class Manager extends Person
{
    private long bonus;
    public Manager(String name,long age,long bonus) {
        super(name, age);
        this.bonus = bonus;
    }
    public boolean equals(Object otherObject)
    {
        if(!super.equals(otherObject)) return false;
        Manager other = (Manager) otherObject;
        return bonus == other.bonus;
    }

}