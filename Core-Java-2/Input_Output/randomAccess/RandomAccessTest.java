package Input_Output.randomAccess;
/**
 * @version 1.0 2024-08-27
 * @author Neekon
 */

import java.io.*;
import java.time.*;

import Input_Output.inheritance.Employee;

public class RandomAccessTest {
    public static void main(String[] args) throws IOException {
        var staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        try (var out = new DataOutputStream(new FileOutputStream("employee.dat")))
        {
            //save all employee records to the file employee.dat
            for(Employee e : staff)
             writeData(out, e);
        }
        try (var in = new RandomAccessFile("employee.dat","r"))
        {
            //retrive all records into a new array
            //compute the array size
            int n = (int) (in.length()/Employee.RECORD_SIZE);
            var newStaff = new Employee[n];

            //read employees in reverse order
            for(int i =n-1;i>=0;i--)
            {
                newStaff[i] = new Employee();
                in.seek(i*Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }
            //print the newly read employee records
            for (Employee e : newStaff)
             System.out.println(e);
        }
    }
    /**
     * Reads employee data from a data input
     * @param in the data input
     * @return the employee
     * @throws IOException 
     */
    public static Employee readData(DataInput in) throws IOException
    {
        String name = readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, y, m, d);
    }
    /**
     * Writes employee data to a data input
     * @param out the data output
     * @param e the employee
     * @throws IOException
     */
    public static void writeData(DataOutput out, Employee e) throws IOException
    {
        writeFixedString(e.getName(), Employee.NAME_SIZE, out);
        out.writeDouble(e.getSalary());

        LocalDate hireDay = e.getHireDay();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());
    }
    public static void writeFixedString(String s, int size, DataOutput out) throws IOException
    {
        for (int i =0; i< size;i++)
        {
            char ch =0;
            if (i < s.length()) ch = s.charAt(i);
            out.writeChar(ch);
        }
    }
    public static String readFixedString(int size, DataInput in) throws IOException
    {
        var b = new StringBuilder(size);
        int i =0;
        var done = false;
        while(!done && i < size)
        {
            char ch = in.readChar();
            i++;
            if (ch==0) done = true;
            else b.append(ch);
        }
        in.skipBytes(2*(size-i));
        return b.toString();
    }

}
