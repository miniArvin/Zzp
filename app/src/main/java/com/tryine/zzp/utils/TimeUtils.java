package com.tryine.zzp.utils;

import java.util.Calendar;

/**
 * Name: TimeUtils
 * Details:
 * Created by PC on 2017/7/14.
 * Update:
 */

public class TimeUtils {
    public static String getDate() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int mon = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        String date = year + "-" + mon + "-" + day;
        return date;
    }

    public static int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getMon() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static int getDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

}
