package com.yugrdev.devlibrary;

import android.content.Context;

/**
 * Name: Dev
 * Details:
 * Created by PC on 2017/5/24.
 * Update:
 */

public final class Dev {
    public static Context mContext;

    private Dev() {
    }

    public static void init(Context context) {
        mContext = context.getApplicationContext();
    }

    public static Context getContext() {
        if (mContext != null) {
            return mContext;
        }
        throw new NullPointerException("Dev not init!");

    }
}
