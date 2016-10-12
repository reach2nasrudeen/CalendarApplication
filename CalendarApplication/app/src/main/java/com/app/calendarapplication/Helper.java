package com.app.calendarapplication;

import java.util.Calendar;
import java.util.Date;


public class Helper {
    public static boolean currentMonth = false;
    public static String[] stringMonths;
    public static String[] get12Months(){
        stringMonths = new String[12];
        for(int i=0;i<12;i++){
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, i);
            calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            Date nextMonthFirstDay = calendar.getTime();
            stringMonths[i] = String.valueOf(nextMonthFirstDay);
            System.out.println(stringMonths[i]);
        }
        return stringMonths;
    }
}
