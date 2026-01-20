package Internationalization;

import java.util.*;
import java.nio.charset.Charset;
import java.text.*;
import java.time.format.*;
import java.time.*;

public class Test {
    public static void main(String[] args) {
        // getLocales();
        // getLanguages();
        // getCountries();
        //  System.out.println(Locale.getDefault());
        // // presentString();
        // formatCurrency(123456.78);
        // currencies(123456.78,"GBP");
        //  dateTimeFormat();
        // converNormalize("Ångström");
        // locatorGetAllLocales();
        MessageFormatNumberDate();
        System.out.println(Charset.defaultCharset());
        System.out.println("100 €");

    }

    public static void getLocales()
    {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales)
         System.out.println(locale);
    }

    public static void getLanguages()
    {
        String[] languages =Locale.getISOLanguages();
        for ( String language : languages)
        System.out.print(language+" ");
        System.out.println();

    }

    public static void getCountries()
    {
        String[] countries = Locale.getISOCountries();
        for (String country : countries)
            System.out.print(country+" ");
        System.out.println();
    }

    public static void presentString()
    {
        var loc = new Locale("de", "CH");
        System.out.println(loc.getDisplayName(Locale.ENGLISH));
    }

    public static void formatCurrency(double amt)
    {
        Locale loc = Locale.GERMAN;
        NumberFormat currFmt = NumberFormat.getCurrencyInstance(loc);
        String result = currFmt.format(amt);
        System.out.println(result);
    }

    public static void currencies(double number, String currencyIdentifier)
    {
        NumberFormat euroFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        euroFormatter.setCurrency(Currency.getInstance(currencyIdentifier));
        String result = euroFormatter.format(number);
        System.out.println(result);
    }
    public static void timeFormat()
    {
       
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.US);
        LocalTime time = LocalTime.of(14,30,45);
        String timefor = timeFormatter.format(time);
        System.out.println(timefor);
    }
    public static void dateTimeFormat()
    {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        ZonedDateTime dateTime = ZonedDateTime.now();
        FormatStyle[] styles = FormatStyle.values();
        DateTimeFormatter dateTimeFormatter;
        DateTimeFormatter dateFormatter;
        DateTimeFormatter timeFormatter;
        for (FormatStyle style: styles)
        {
            dateFormatter = DateTimeFormatter.ofLocalizedDate(style).withLocale(Locale.getDefault());
            String dateFormatted =  dateFormatter.format(date);
            
            if(style.toString().equals("LONG")  || style.toString().equals("FULL"))
            timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(Locale.getDefault());
            else timeFormatter = DateTimeFormatter.ofLocalizedTime(style).withLocale(Locale.getDefault());

            String timeFormatted = timeFormatter.format(time);
            dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(style).withLocale(Locale.getDefault());;
            String dateTimeFormatted = dateTimeFormatter.format(dateTime);
            System.out.println("Date: "+dateFormatted);
            System.out.println("Time: "+timeFormatted);
            System.out.println("DateTime "+ dateTimeFormatted);
        }
    }
    public static void converNormalize(String name)
    {
        String normalized = Normalizer.normalize(name, Normalizer.Form.NFD);
        System.out.println(normalized);
    }
    public static void locatorGetAllLocales()
    {
        Locale[] locales = Collator.getAvailableLocales();
        for (var locale : locales)
            System.out.println(locale);

    }
    public static void MessageFormatNumberDate()
    {
        String msg = MessageFormat.format("On {2,date,long}, a {0} destroyed {1} houses and caused {3,number,currency} of damage", "hurricane", 99, new GregorianCalendar(1999,0,1).getTime(), 10.0E8);
        System.out.println(msg);

        var mf = new MessageFormat("On {2,date,long}, a {0} destroyed {1} houses and caused {3,number,currency} of damage.", Locale.CHINA);
        String msg2 = mf.format(new Object[] {"hurricane",99, new GregorianCalendar(2024,9,11).getTime(), 10.0E8});
        System.out.println(msg2);
        String pattern = MessageFormat.format("On {2,date,long}, {0} destroyed {1,choice,0#no houses|1#one house|2#{1} houses} and caused {3,number,currency} of damage", "hurricane", 4, new GregorianCalendar(1999,0,1).getTime(), 10.0E8);
        System.out.println(pattern);
        String pattern1 = MessageFormat.format("On {2,date,long}, {0} destroyed {1,choice,-\u221E<no houses|0<one house|2\u2264{1} houses} and caused {3,number,currency} of damage", "hurricane", 1, new GregorianCalendar(1999,0,1).getTime(), 10.0E8);
        System.out.println(pattern1);
    }
}
