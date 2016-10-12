package com.app.calendarapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements CalendarView.EventHandler {
//    Calendar calendar;
    String[] months;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        months = Helper.get12Months();
        CalendarView cv = ((CalendarView)findViewById(R.id.calendar_view));
        CalendarView cv1 = ((CalendarView)findViewById(R.id.calendar_view1));
        CalendarView cv2 = ((CalendarView)findViewById(R.id.calendar_view2));
        CalendarView cv3 = ((CalendarView)findViewById(R.id.calendar_view3));
        CalendarView cv4 = ((CalendarView)findViewById(R.id.calendar_view4));
        CalendarView cv5 = ((CalendarView)findViewById(R.id.calendar_view5));
        CalendarView cv6 = ((CalendarView)findViewById(R.id.calendar_view6));
        CalendarView cv7 = ((CalendarView)findViewById(R.id.calendar_view7));
        CalendarView cv8 = ((CalendarView)findViewById(R.id.calendar_view8));
        CalendarView cv9 = ((CalendarView)findViewById(R.id.calendar_view9));
        CalendarView cv10 = ((CalendarView)findViewById(R.id.calendar_view10));
        CalendarView cv11 = ((CalendarView)findViewById(R.id.calendar_view11));

        cv.updateCalendar(initCalendar(0));
        cv1.updateCalendar(initCalendar(1));
        cv2.updateCalendar(initCalendar(2));
        cv3.updateCalendar(initCalendar(3));
        cv4.updateCalendar(initCalendar(4));
        cv5.updateCalendar(initCalendar(5));
        cv6.updateCalendar(initCalendar(6));
        cv7.updateCalendar(initCalendar(7));
        cv8.updateCalendar(initCalendar(8));
        cv9.updateCalendar(initCalendar(9));
        cv10.updateCalendar(initCalendar(10));
        cv11.updateCalendar(initCalendar(11));

        // assign event handler
        cv.setEventHandler(this);
        cv1.setEventHandler(this);
        cv2.setEventHandler(this);
        cv3.setEventHandler(this);
        cv4.setEventHandler(this);
        cv5.setEventHandler(this);
        cv6.setEventHandler(this);
        cv7.setEventHandler(this);
        cv8.setEventHandler(this);
        cv9.setEventHandler(this);
        cv10.setEventHandler(this);
        cv11.setEventHandler(this);
    }
    private Calendar initCalendar(int position){
        Date parsed = new Date();
        Calendar calendar;
        try {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            parsed = format.parse(months[position]);
            calendar = Calendar.getInstance();
            calendar.setTime(parsed);
        }
        catch(ParseException pe) {
            throw new IllegalArgumentException();
        }
        return calendar;
    }

    private void handleClick(Date date){
        // show returned day
        DateFormat df = SimpleDateFormat.getDateInstance();
        Toast.makeText(MainActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDayLongPress(Date date) {
        handleClick(date);
    }

    @Override
    public void onDayPress(Date date) {
        handleClick(date);
    }
}
