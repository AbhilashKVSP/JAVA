package com.myjava;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Date dt = new Date();
        System.out.println(dt.getTime()); // gets in millisecond from 1Jan 1970

        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
        System.out.println(c.get(Calendar.WEEK_OF_YEAR));

        GregorianCalendar cal = new GregorianCalendar();
        System.out.println(cal.getTime());

        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY-MM-DD -- E");
        DateTimeFormatter df2 = DateTimeFormatter.ISO_OFFSET_DATE;
        String MyDate = dateTime.format(df);
        String MyDate2 = dateTime.format(df2);
        System.out.println(MyDate);
    }
}
