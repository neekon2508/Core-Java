import java.time.*;

public class CalendarTest
{
    public static void main(String[] args)
    {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today-1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for(int i=1;i<value;i++)
         System.out.print(" ");
        while(date.getMonthValue()==month)
        {
            SafeVarargs
        }
    }
}