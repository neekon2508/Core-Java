package Chap4_ObjectClass;
import java.time.*;
/*
 * This program illustrates the Date classes
 */
public class LocalDateClass {
    LocalDate newYearsEve = LocalDate.of(1999,12,31);
    // int year = newYearsEve.getYear();
    // int moth = newYearsEve.getMonthValue();
    // int day = newYearsEve.getDayOfMonth();
    LocalDate aThousandDaysLater = newYearsEve.plusDays(1000);
    int year = aThousandDaysLater.getYear();
    int month = aThousandDaysLater.getMonthValue();
    int day = aThousandDaysLater.getDayOfMonth();

}
