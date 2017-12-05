package com.tryine.zzp.widget.HotelCalendar.helper;

import android.content.Context;


public class DeviceHelper {
    public static int dp2px(Context context,int dpi) {
        float density;
        if (context != null) {
            density = context.getResources().getDisplayMetrics().density;
        } else density = 2;
        return (int) (dpi * density + 0.5);
    }
}
