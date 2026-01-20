package Chap8_GenericProgram.pair3;
import Chap5_Inheritance.equals.*;
import Chap8_GenericProgram.pair1.Pair;
/**
 * @version 1.0 2024-07-22
 * @author Neekon
 */

public class PairTest3 {
    public static void main(String[] args) {
        var ceo = new Manager("Gus Greedy", 800000,2003,12,15);
        var cfo = new Manager("Sid Sneaky", 600000,2003,12,15);
        var t1 = new Employee("T1", 800000,2003,12,15);
        var t2 = new Employee("T2", 600000,2003,12,15);
        var buddies = new Pair<Manager>(ceo, cfo);
        var buddies2 = new Pair<Employee>(t1,t2);
        printBuddies(buddies);
        printBuddies(buddies2);

        ceo.setBonus(100000);
        cfo.setBonus(500000);
        Manager[] managers = {ceo,cfo};

        var result = new Pair<Employee>();
        minmaxBonus(managers, result);
        System.out.println("first: "+result.getFirst().getName()
        +", second: "+result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: "+result.getFirst().getName()
        +", second: "+result.getSecond().getName());

    }
    public static void printBuddies(Pair<? extends Employee> p)
    {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName()+" and "+second.getName()+" are buddies ");
    }
    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result)
    {
     if(a.length==0) return;
     Manager min = a[0];
     Manager max = a[0];
     for(int i =1;i< a.length; i++)
     {
        if(min.getBonus() > a[i].getBonus()) min = a[i];
        if(max.getBonus() < a[i].getBonus()) max = a[i]; 
     }   
     result.setFirst(min);
     result.setSecond(max);
    }
    public static void maxminBonus(Manager[] a, Pair<? super Manager> result)
    {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result); //swapHelper captures wildcard type
    }
    //can't write public static <T super manager>
}
class PairAlg
{
    public static boolean hasNulls(Pair<?> p)
    {
        return p.getFirst() == null || p.getSecond() == null;
    }
    public static void swap(Pair<?> p) {swapHelper(p);}
    public static <T> void swapHelper(Pair<T> p)
    {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
