package com.bvhloc.general.utils.datetime;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DatetimeUtils {

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


    public static Calendar getVietNamCalendar1() {

        Calendar calendar = Calendar.getInstance();
//        long timeInMilis = calendar.getTimeInMillis() + (7 * 60 * 60 * 1000);
//        calendar.setTimeInMillis(timeInMilis);
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+07"));
        return calendar;
    }

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

    public static void addDatePicker(final EditText editText, final SimpleDateFormat dateFormat, final String saveStr, final String cancelStr) {

        editText.setFocusable(false);
        editText.setCursorVisible(false);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DatePicker datePicker = new DatePicker(editText.getContext());
                datePicker.setCalendarViewShown(false);
                datePicker.setMaxDate(new Date().getTime());

                if (!editText.getText().toString().equals("")) {

                    try {
                        Date date = dateFormat.parse(editText.getText().toString());
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);
                        datePicker.updateDate(year, month, day);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    datePicker.updateDate(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                }

                new AlertDialog.Builder(editText.getContext())
                        .setView(datePicker)
                        .setNegativeButton(cancelStr, null)
                        .setPositiveButton(saveStr, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Calendar cal = Calendar.getInstance();
                                cal.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                                Date date = cal.getTime();
                                editText.setText(dateFormat.format(date));
                            }
                        })
                        .show();
            }
        });
    }
}
