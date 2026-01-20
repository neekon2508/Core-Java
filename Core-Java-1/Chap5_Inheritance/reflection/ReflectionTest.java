package Chap5_Inheritance.reflection;

import java.util.*;
import java.lang.reflect.*;

/**
 * This program uses relfection to print all features of a class
 * @version 1.0 2024-07-05
 * @author Neekon
 */
public class ReflectionTest {
    public static void main(String[] args) throws ReflectiveOperationException {
        String name;
        if(args.length >0) name = args[0];
        else
        {
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g java.util.Date)");
            name = in.next();
        }

        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modifier = Modifier.toString(cl.getModifiers());
        if (modifier.length() > 0 ) System.out.println(modifier+" ");
        System.out.println("class "+name);
        if (supercl != null & supercl != Object.class) System.out.println(" extends "+supercl.getName());

        System.out.println("\n{\n");
        printConstructor(cl);
        System.out.println();
        printMethods(cl);
        System.out.println( );
        printFields(cl);
        System.out.println("}");
    }

/**
 * Prints all constructors of a class
 * @param cl a class
 */
public static void printConstructor(Class cl)
{
    Constructor[] constructors = cl.getDeclaredConstructors();

    for(Constructor c : constructors)
    {
        String name = c.getName();
        System.out.println("    ");
        String modifier = Modifier.toString(c.getModifiers());
        if (modifier.length() > 0 ) System.out.print(modifier+" ");
        System.out.print(name+"(");

        Class[] paramTypes = c.getParameterTypes();
        for(int j =0; j < paramTypes.length; j++)
        {
            if (j>0) System.out.println(", ");
            System.out.print(paramTypes[j].getName());
        }
        System.out.println(");");
    }
}
/**
 * Prints all methods of a class
 * @param cl a class
 */
public static void printMethods(Class cl)
{
    Method[] methods = cl.getDeclaredMethods();

    for(Method m : methods)
    {
        Class retType = m.getReturnType();
        String name = m.getName();

        System.out.println("    ");
        String modifier = Modifier.toString(m.getModifiers());
        if (modifier.length() > 0 ) System.out.print(modifier+" ");
        System.out.print(retType.getName()+" "+ name+"(");

        Class[] paramTypes = m.getParameterTypes();
        for(int j =0; j < paramTypes.length; j++)
        {
            if (j>0) System.out.print(", ");
            System.out.print(paramTypes[j].getName());
        }
        System.out.println(");");
    }
}
/**
 * Print all fields of a class
 * @param cl a class 
 */
    public static void printFields(Class cl)
    {
        Field[] fields = cl.getDeclaredFields();

        for(Field f : fields)
        {
            Class type = f.getType();
            String name =f.getName();
            System.out.println("    ");
            String modifier = Modifier.toString(f.getModifiers());
            if (modifier.length() > 0) System.out.print(modifier+" ");
            System.out.println(type.getName()+" "+name+";");
        }
    }
}