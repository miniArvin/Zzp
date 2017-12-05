package com.tryine.zzp.utils;

import android.app.Activity;
import android.os.Build;
import android.view.WindowManager;

/**
 * Name: StatusBarUtils
 * Details:
 * Created by PC on 2017/5/25.
 * Update:
 */

public class StatusBarUtils {
    /**
     * 设置透明状态栏（api大于19方可使用）
     * <p>可在Activity的onCreat()中调用</p>
     * <p>需在顶部控件布局中加入以下属性让内容出现在状态栏之下</p>
     * <p>android:clipToPadding="true"</p>
     * <p>android:fitsSystemWindows="true"</p>
     *
     * @param activity activity
     */
    public static void setTransparentStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
