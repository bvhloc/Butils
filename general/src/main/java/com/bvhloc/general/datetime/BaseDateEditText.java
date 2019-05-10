package com.bvhloc.general.datetime;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;

import com.bvhloc.general.BToucher;
import com.bvhloc.general.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("ConstantConditions")
public abstract class BaseDateEditText extends AppCompatEditText {

    /**
     * this function can be modified in other projects
     */
    protected String getSaveText() {
        return "Save";
    }

    /**
     * this function can be modified in other projects
     */
    protected String getCancelText() {
        return "Cancel";
    }

    /**
     * this function can be modified in other projects
     */
    protected SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat("MM/dd/yyyy");
    }

    public BaseDateEditText(final Context context, AttributeSet attrs) {
        super(context, attrs);
        BToucher.addAlpha(this);
        setFocusable(false);
        setCursorVisible(false);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                final DatePicker datePicker = new DatePicker(context,
                        null, R.style.Theme_AppCompat_Dialog);
                datePicker.setCalendarViewShown(false);
//                datePicker.setMaxDate(new Date().getTime());

                if (!getText().toString().equals("")) {

                    try {
                        Date date = getDateFormat().parse(getText().toString());
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
                    datePicker.updateDate(Calendar.getInstance().get(Calendar.YEAR),
                            Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                }

                new AlertDialog.Builder(context)
                        .setTitle(title)
                        .setView(datePicker)
                        .setNegativeButton(getCancelText(), null)
                        .setPositiveButton(getSaveText(), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Calendar cal = Calendar.getInstance();
                                cal.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                                Date date = cal.getTime();
                                setText(getDateFormat().format(date));
                                if (onDateChangedListener != null) {
                                    onDateChangedListener.onDateChanged(cal);
                                }
                            }
                        })
                        .show();
            }
        });
    }

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCalendar(Calendar calendar) {
        String date = DatetimeUtils.getString(calendar, getDateFormat());
        setText(date);
    }

    public Calendar getCalendar() {
        String date = getText().toString();
        if (!date.equals("")) {
            return DatetimeUtils.getCalendar(date, getDateFormat());
        }
        return null;
    }

    private OnDateChangedListener onDateChangedListener;

    public interface OnDateChangedListener {

        void onDateChanged(Calendar calendar);
    }

    public void setOnDateChangedListener(OnDateChangedListener onDateChangedListener) {
        this.onDateChangedListener = onDateChangedListener;
    }
}
