package com.yugrdev.devlibrary.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * 项目名称：DevPKG
 * 类：ISnackBar
 * 描述：
 * 创建人：Yugr
 * 创建日期：2017/1/13
 * 时间：13:57
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class ISnackBar {
    public ISnackBar() {
    }

    public static void show(View view, CharSequence text, int duration, CharSequence actionText, View.OnClickListener listener) {
        Snackbar.make(view, text, duration)
                .setAction(actionText, listener)
                .show();
    }

    public static void show(View view, CharSequence text, int duration) {
        Snackbar.make(view, text, duration)
                .show();
    }

}
