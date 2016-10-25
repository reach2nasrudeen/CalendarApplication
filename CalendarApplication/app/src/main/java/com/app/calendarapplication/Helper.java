package com.app.calendarapplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Helper {
    public static boolean initialMonth;
    public static String dfDDMMYYYY = "dd/MM/yyyy";

    public static String[] stringMonths;
    public static String[] get12Months(){
        stringMonths = new String[22];
        for(int i=0;i<22;i++){
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
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
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
    public static String getDate(Date inputDate){
        String outputDate = null;
        DateFormat dateFormat = new SimpleDateFormat(Helper.dfDDMMYYYY);
        outputDate = dateFormat.format(inputDate);
        System.out.println(outputDate);
        return outputDate;
    }
    public static boolean checkSameMonthOrNot(int currentMonth,String inputDate){
        boolean status = false;
        int strMonth = Integer.parseInt(getSplittedMonth(inputDate));
        if(strMonth == currentMonth){
            status = true;
        }else {
            status = false;
        }
        return status;
    }
    public static String getSplittedMonth(String inputDate){
        String[] parts = inputDate.split("/");
        String strSplittedDate = parts[0];
        String strSplittedMonth = parts[1];
        String strSplittedYear = parts[2];
        return strSplittedMonth;
    }
    public static String getCurrentDate(){
        String outputDate = null;
        DateFormat dateFormat = new SimpleDateFormat(Helper.dfDDMMYYYY);
        Calendar cal = Calendar.getInstance();
        outputDate = dateFormat.format(cal.getTime());
        System.out.println(dateFormat.format(cal.getTime()));
        return outputDate;
    }
    public static boolean compareDates(String fromDate, String toDate){
        Boolean status = false;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(Helper.dfDDMMYYYY);
            Date date1 = sdf.parse(fromDate);
            Date date2 = sdf.parse(toDate);

            System.out.println(sdf.format(date1));
            System.out.println(sdf.format(date2));

            if(date1.after(date2)){
                //System.out.println("Date1 is after Date2");
                status = true;
            }

            if(date1.before(date2)){
                //System.out.println("Date1 is before Date2");
                status = false;
            }

            if(date1.equals(date2)){
                //System.out.println("Date1 is equal Date2");
                status = true;
            }

        }catch(ParseException ex){
            ex.printStackTrace();
        }
        return status;
    }
}
