package Chap5_Inheritance.equals;

import java.util.Objects;

public class Manager extends Employee{

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
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),bonus);
    }
    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)) return false;
        var other = (Manager) obj;
        return bonus == other.bonus;
    }
    @Override
    public String toString() {
        return super.toString()+"[bonus=" + bonus + "]";
    }
    

}
