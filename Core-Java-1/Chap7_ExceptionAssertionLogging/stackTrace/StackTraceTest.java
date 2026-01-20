package Chap7_ExceptionAssertionLogging.stackTrace;
import java.util.*;
/**
 * A program that displays a trace feature of a recursive method call
 */
public class StackTraceTest {

    public static void main(String[] args) {
        try (var in = new Scanner(System.in))
        {
            System.out.println("Enter n: ");
            int n = in.nextInt();
            factorial(n);
        }
    }
    /**
     * Computes the factorial of a number
     * @param n a non-negtaive integer
     * @return n! = 1 * 2 *...*n
     */
    public static int factorial(int n)
    {
        System.out.println("factorial("+n+"):");
        var walker = StackWalker.getInstance();
        walker.forEach(System.out::println);
        int r;
        if (n <= 1) r=1;
        else r = n* factorial(n-1);
        System.err.println("return "+r);
        return r;
    }
}
