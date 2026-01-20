package Chap6_InterfaceLambdaInner.lambda;

import java.util.*;
import java.util.function.*;

import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates the use of lambda expressions
 * @version 1.0 2024-07-06
 * @author Neekon
 */
public class LambdaTest {
    public static void main(String[] args) {
       try(Scanner in = new Scanner(System.in))
       {
        int n = in.nextInt();
        testOperator(n, i->{
            i*=2;
            return i;
        });1
       }
    }

    public static void repeat(int n, Runnable action)
    {
        for (int i = 0; i<n;++i) action.run();
    }

    public static int testSupplier(int n, Supplier<Integer> action)
    {
        int sum =0;
        for(int i =0;i<n;++i)
         sum+=action.get();
        return sum;
    }
    public static void testConsumer(int n, Consumer<Integer> action) {
        for(int i = 1;i<=n;++i)
         action.accept(i);
    }
    public static void testBiConsumer(int m, int n,BiConsumer<Integer,Integer> action)
    {
        action.accept(m, n);
    }
   public static void testOperator(int n, UnaryOperator<Integer> action)
   {
    int doubleN = action.apply(n);
    System.out.println(doubleN);
   }
}