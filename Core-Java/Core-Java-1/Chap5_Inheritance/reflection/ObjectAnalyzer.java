package Chap5_Inheritance.reflection;

import java.lang.reflect.*;
import java.util.ArrayList;

public class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * Converts an object to a string representation that lists all fields
     * @param obj an object
     * @return a string with the object's class name and all fields names and values
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public String toString(Object obj) throws IllegalArgumentException, IllegalAccessException {

        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);
        Class cl = obj.getClass();
        if (cl == String.class) return (String) obj;
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) r += ",";
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    Class t = f.getType();
                    Object val = f.get(obj);
                    if (t.isPrimitive()) r += val;
                    else r += toString(val);
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        } while (cl != null);

        return r;
    }
}
