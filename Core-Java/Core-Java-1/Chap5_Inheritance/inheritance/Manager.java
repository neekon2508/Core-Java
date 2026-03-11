package Chap5_Inheritance.inheritance;

public class Manager extends Employee {
    private double bonus;
    /**
     * 
     * @param name
     * @param salary
     * @param year
     * @param month
     * @param day
     */
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
        //TODO Auto-generated constructor stub
    }

    public double getSalary()
    {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    public void setBonus(double b)
    {
        bonus = b;
    }
    

}
