package Chap5_Inheritance.reflection;

import java.util.ArrayList;

public class ObjectAnalyzerTest {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        var squares = new ArrayList<>();
        for (int i = 1; i<= 5; i++)
            squares.add(i * i);
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
