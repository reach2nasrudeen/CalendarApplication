package com.app.calendarapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;


public class CalendarAdapter extends ArrayAdapter<Date> {
    // days with events
    private HashSet<Date> eventDays;
    private Calendar calendar;
    // for view inflation
    private LayoutInflater inflater;

    public CalendarAdapter(Context context, ArrayList<Date> days, HashSet<Date> eventDays, Calendar calendar)
    {
        super(context, R.layout.control_calendar_day, days);
        this.eventDays = eventDays;
        inflater = LayoutInflater.from(context);
        this.calendar = calendar;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        // day in question
        Date date = getItem(position);
        int day = date.getDate();
        int month = date.getMonth();
        int year = date.getYear();

        // today
        Date today = new Date();

        // inflate item if it does not exist yet
        if (view == null)
            view = inflater.inflate(R.layout.control_calendar_day, parent, false);
        TextView textDay = (TextView) view.findViewById(R.id.day_view);
        TextView textPrice = (TextView) view.findViewById(R.id.textPrice);
        // if this day has an event, specify event image
        view.setBackgroundResource(0);
        view.setBackgroundColor(ContextCompat.getColor(getContext(),android.R.color.white));
        if (eventDays != null)
        {
            for (Date eventDate : eventDays)
            {
                if (eventDate.getDate() == day &&
                        eventDate.getMonth() == month &&
                        eventDate.getYear() == year)
                {
                    // mark this day for event
                    view.setBackgroundResource(R.mipmap.ic_launcher);
                    break;
                }
            }
        }

        // clear styling
        textDay.setTypeface(null, Typeface.NORMAL);
        textDay.setTextColor(Color.BLACK);

//        if (month != today.getMonth() || year != today.getYear())
//        {
//            view.setBackgroundColor(ContextCompat.getColor(getContext(),android.R.color.holo_green_dark));
//            textDay.setTextColor(ContextCompat.getColor(getContext(),android.R.color.white));
//            // if this day is outside current month, grey it out
////            ((TextView)view).setTextColor(ContextCompat.getColor(getContext(),R.color.greyed_out));
//        }
        Log.i("Current Date ", Helper.getDate(date));
        Log.i("Current Date ", Helper.getDate(date));

        if(Helper.checkSameMonthOrNot(calendar.get(Calendar.MONTH)+1, Helper.getDate(date))){
            if (day == today.getDate())
            {
                textPrice.setText("1000");
                // if it is today, set it to blue/bold
                textDay.setTypeface(null, Typeface.BOLD);
                textDay.setTextColor(ContextCompat.getColor(getContext(),R.color.today));
            }
            // set text
            textDay.setText(String.valueOf(date.getDate()));
            //Log.i("Date",String.valueOf(date.getDate()));
        }else {
            textDay.setVisibility(View.INVISIBLE);
            textPrice.setVisibility(View.INVISIBLE);
        }
        return view;
    }
}
