package com.yugrdev.devlibrary.utils;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.yugrdev.devlibrary.Dev;

/**
 * 项目名称：DevPKG
 * 类：AToast
 * 描述：
 * 创建人：Yugr
 * 创建日期：2017/1/13
 * 时间：13:57
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class AToast {
    private static Toast mToast;


    public static void show(String msg) {
        safeShow(msg, Toast.LENGTH_SHORT);
    }

    public static void show(int resId) {
        show(Dev.getContext().getString(resId));
    }

    public static void showLong(String msg) {

        safeShow(msg, Toast.LENGTH_LONG);

    }

    public static void showLong(int resId) {
        show(Dev.getContext().getString(resId));
    }

    /**
     * 安全弹出Toast。处理线程的问题。
     *
     * @param text
     * @param lengthShort
     */
    private static void safeShow(final String text, final int lengthShort) {
        if (Looper.myLooper() != Looper.getMainLooper()) {//如果不是在主线程弹出吐司，那么抛到主线程弹
            new Handler(Looper.getMainLooper()).post(
                    new Runnable() {
                        @Override
                        public void run() {
                            showToast(text, lengthShort);
                        }
                    }
            );
        } else {
            showToast(text, lengthShort);
        }
    }

    /**
     * 弹出Toast，处理单例的问题。
     *
     * @param text
     * @param lengthShort
     */
    private static void showToast(String text, int lengthShort) {
        if (mToast == null) {
            mToast = Toast.makeText(Dev.getContext(), null, Toast.LENGTH_SHORT);
        }
        mToast.setDuration(lengthShort);
        mToast.setText(text);
        mToast.show();
    }

}

