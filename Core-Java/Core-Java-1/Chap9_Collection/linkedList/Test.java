package Chap9_Collection.linkedList;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        Set<Integer> g = new HashSet<>();
        g.add(4);
        g.add(5);
        g.add(3);
        for(var a:g) System.out.println(a);
    }
}
