package com.yugrdev.devlibrary.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 项目名称：DevPKG
 * 类：DeviceUtils
 * 描述：
 * 创建人：Yugr
 * 创建日期：2017/1/7
 * 时间：13:44
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class DeviceUtils {

    /**
     * 屏幕高度
     *
     * @param context
     * @return 屏幕高度像素
     */
    public static int heightPixels(Context context) {
        return displayMetrics(context).heightPixels;
    }


    /**
     * 屏幕宽度
     *
     * @param context
     * @return 屏幕宽度像素
     */
    public static int widthPixels(Context context) {
        return displayMetrics(context).widthPixels;
    }

    public static DisplayMetrics displayMetrics(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        ALog.v("screen width=" + dm.widthPixels + "px, screen height=" + dm.heightPixels
                + "px, densityDpi=" + dm.densityDpi + ", density=" + dm.density);
        return dm;
    }

}
