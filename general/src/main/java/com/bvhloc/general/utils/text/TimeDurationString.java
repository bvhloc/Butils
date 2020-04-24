package com.bvhloc.general.utils.text;
/**
 * Refer AppTimeStringHelper class in Youtrade project
 * */
public class TimeDurationString {

    protected String getYear() {
        return "year";
    }

    protected String getYears() {
        return "years";
    }

    protected String getMonth() {
        return "month";
    }

    protected String getMonths() {
        return "months";
    }

    protected String getWeek() {
        return "week";
    }

    protected String getWeeks() {
        return "weeks";
    }

    protected String getDay() {
        return "day";
    }

    protected String getDays() {
        return "days";
    }

    protected String getHour() {
        return "hour";
    }

    protected String getHours() {
        return "hours";
    }

    protected String getMinute() {
        return "minute";
    }

    protected String getMinutes() {
        return "minutes";
    }

    protected String getSecond() {
        return "second";
    }

    protected String getSeconds() {
        return "second";
    }

    public String getString(long timeInMillis) {

        long second = 1000;
        long minute = second * 60;
        long hour = minute * 60;
        long day = hour * 24;
        long week = day * 7;
        long month = day * 30;
        long year = day * 365;

        year = timeInMillis / year;
        if (year > 1) {
            return year + " " + getYears();
        } else if (year > 0) {
            return year + " " + getYear();
        }

        month = timeInMillis / month;
        if (month > 1) {
            return month + " " + getMonths();
        } else if (month > 0) {
            return month + " " + getMonth();
        }

        week = timeInMillis / week;
        if (week > 1) {
            return week + " " + getWeeks();
        } else if (week > 0) {
            return week + " " + getWeek();
        }

        day = timeInMillis / day;
        if (day > 1) {
            return day + " " + getDays();
        } else if (day > 0) {
            return day + " " + getDay();
        }

        hour = timeInMillis / hour;
        if (hour > 1) {
            return hour + " " + getHours();
        } else if (hour > 0) {
            return hour + " " + getHour();
        }

        minute = timeInMillis / minute;
        if (minute > 1) {
            return minute + " " + getMinutes();
        } else if (minute > 0) {
            return minute + " " + getMinute();
        }

        second = timeInMillis / 1000;
        if (second > 1) {
            return second + " " + getSeconds();
        } else if (second > 0) {
            return second + " " + getSecond();
        }
        return "";
    }
}
