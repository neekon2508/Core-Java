package Input_Output.inheritance;
public class Manager extends Employee
{
   private double bonus;
   private Employee secretary;

   /**
    * @param name the employee's name
    * @param salary the salary
    * @param year the hire year
    * @param month the hire month
    * @param day the hire day
    */
   public Manager(String name, double salary, int year, int month, int day)
   {
      super(name, salary, year, month, day);
      bonus = 0;
   }

   @Override
   public String toString() {
      return "Manager [bonus=" + bonus + ", secretary=" + secretary + ", getSalary()=" + getSalary() + ", getName()="
            + getName() + ", getHireDay()=" + getHireDay() + "]";
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
   public void setSecretary(Employee e)
   {
      this.secretary = e;
   }
}
