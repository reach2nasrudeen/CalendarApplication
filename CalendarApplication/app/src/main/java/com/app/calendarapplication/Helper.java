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
           // System.out.println(stringMonths[i]);
        }
        return stringMonths;
    }
    public static int getNoOfWeeks(Calendar calendar){
        return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
    }
    public static int getCountOfMonth(Calendar calendar){
        int totalCount = 0;
        switch (Helper.getNoOfWeeks(calendar)){
            case 4:
                totalCount = 28;
                break;
            case 5:
                totalCount = 35;
                break;
            case 6:
                totalCount = 42;
                break;
        }
        return totalCount;
    }
}
