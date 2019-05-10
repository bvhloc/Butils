package com.bvhloc.general.datetime;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DatetimeUtils {

    public static Calendar getCalendar(String dateString, SimpleDateFormat dateFormat) {
        try {

            Date date = dateFormat.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Calendar.getInstance();
    }

    public static String getString(Calendar calendar, SimpleDateFormat dateFormat) {

        Date date = calendar.getTime();
        return dateFormat.format(date);
    }

    @SuppressLint("SimpleDateFormat")
    public static Calendar getInternationalCalendar() {

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        df.setTimeZone(TimeZone.getTimeZone("gmt"));
        String gmtTime = df.format(new Date());
        return getCalendar(gmtTime, new SimpleDateFormat("yyyyMMddHHmmssSSS"));
    }

    public static Calendar getVietNamCalendar() {

        Calendar calendar = getInternationalCalendar();
        long timeInMilis = calendar.getTimeInMillis() + (7 * 60 * 60 * 1000);
        calendar.setTimeInMillis(timeInMilis);
        return calendar;
    }
}
