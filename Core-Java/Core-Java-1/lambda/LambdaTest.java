package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.function.IntConsumer;

import javax.swing.Timer;

public class LambdaTest {

    public static void main(String[] args)
    {
        var planets = new String[] {"Mercury","Venus","Earth","Mars",
    "Jupiter","Saturn","Uranus","Neptune"};
    System.out.print(Arrays.toString(planets));
    Arrays.sort(planets, (first,second)->first.length()-second.length());
    System.out.println(Arrays.toString(planets));

    var time = new Timer(1000,event ->
    System.out.println("The time is "+new Date()));
    time.start();    
    var list = new ArrayList<String>();
    list.add("Heelo");
    list.add("haha");
    list.removeIf(b->b==null);
    repeat(10, () -> System.out.print("Hello World"));
    repeat(10, a -> System.out.println("Coutdown "+(9-a)));
}
public static void repeat(int n, Runnable action)
{
    for(int i =0;i<n;++i) action.run();
}
public static void repeat(int n , IntConsumer action)
{
    for(int i =0;i<n;++i) action.accept(i);
}

}
