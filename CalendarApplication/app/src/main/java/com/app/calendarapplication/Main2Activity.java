package com.app.calendarapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    String[] strMonths;
    private static final String DATE_FORMAT = "MMM yyyy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        textView = (TextView) findViewById(R.id.textView);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        cal.getFirstDayOfWeek();
        textView.append("\n\nFirst Day of Week "+cal.getFirstDayOfWeek());
        textView.append("\nTotal Week of Month "+cal.get(Calendar.WEEK_OF_MONTH));
        cal.setFirstDayOfWeek(Calendar.SUNDAY);
        textView.append("\n\nAfter Change 1st Day of Week "+cal.getFirstDayOfWeek());
        textView.append("\nAfter Change Total Week of Month "+cal.get(Calendar.WEEK_OF_MONTH));
        int rec = cal.get(Calendar.WEEK_OF_MONTH);


        strMonths = Helper.get12Months();
//        for(int i=0;i<strMonths.length;i++){
//            textView.append("\n\nMonth :  "+strMonths[i]);
//            textView.append("\nMonth Name : "+sdf.format(initCalendar(i).getTime()));
//            textView.append("\nCount : "+Helper.getCountOfMonth(initCalendar(i)));
//        }
    }
    private Calendar initCalendar(int position){
        Date parsed;
        Calendar calendar;
        try {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            parsed = format.parse(strMonths[position]);
            calendar = Calendar.getInstance();
            calendar.setTime(parsed);
        }
        catch(ParseException pe) {
            throw new IllegalArgumentException();
        }
        Log.e("Cal Data Month=>",String.valueOf(calendar.get(Calendar.MONTH)));
        Log.e("Cal Data Year=>",String.valueOf(calendar.get(Calendar.YEAR)));
        return calendar;
    }
}
