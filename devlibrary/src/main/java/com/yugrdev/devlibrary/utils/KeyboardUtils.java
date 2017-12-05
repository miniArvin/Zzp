package com.yugrdev.devlibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

/**
 * 项目名称：DevPKG
 * 类：KeyboardUtils
 * 描述：
 * 创建人：Yugr
 * 创建日期：2016/10/10
 * 时间：13:46
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class KeyboardUtils {
    /**
     * 如果软键盘开启，隐藏软键盘
     *
     * @param activity
     */
    public static void checkHideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean isOpen = imm.isActive();
        if (isOpen) {
            hideKeyboard(activity);
        }
    }

    /**
     * 隐藏软键盘
     */
    public static void hideKeyboard(Activity activity) {
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (NullPointerException e) {
            Log.e("hideKeyboard", e.toString());
        }
    }
}
