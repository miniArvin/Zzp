package com.yugrdev.devlibrary.utils;

import android.util.Log;

/**
 * 项目名称：DevPKG
 * 类：ALog
 * 描述：
 * 创建人：Yugr
 * 创建日期：2017/1/7
 * 时间：14:46
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class ALog {
    private static boolean isDebug = true;

    private static String mTag = "ALOG";
    //defualt Verbose


    public static void v(String msg) {
        if (isDebug) {
            Log.v(mTag, getTitle() + msg);
        }
    }

    public static void d(String msg) {
        if (isDebug) {
            Log.d(mTag, getTitle() + msg);
        }
    }

    public static void i(String msg) {
        if (isDebug) {
            Log.i(mTag, getTitle() + msg);
        }
    }

    public static void w(String msg) {
        if (isDebug) {
            Log.w(mTag, getTitle() + msg);
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(mTag, getTitle() + msg);
        }
    }

    public static void setIsDebug(boolean isDebug) {
        ALog.isDebug = isDebug;
        if (ALog.isDebug) {
            Log.w(mTag, "当前为Debug版本/n开启Log");
        } else {
            Log.w(mTag, "当前为正式发布版本/n关闭Log");
        }
    }

    public static void setmTag(String tag) {
        ALog.mTag = tag;
    }

    public static String getTitle() {
        StackTraceElement elm = Thread.currentThread().getStackTrace()[4];
        String className = elm.getClassName();
        return className + "." + elm.getMethodName() + "(" + elm.getLineNumber() + ")" + ": ";
    }

}
