package Chap6_InterfaceLambdaInner.clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }
    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month-1,day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public Employee clone() throws CloneNotSupportedException {
        //Object.clone()
        Employee cloned = (Employee) super.clone();
        //clone mutable fields
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;

    }
    public void raiseSalary(double byPercent)
    {
        salary += salary*byPercent/100;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Employee[name"+name+",salary="+salary+",hireDay="+hireDay+"]";
    }


}
