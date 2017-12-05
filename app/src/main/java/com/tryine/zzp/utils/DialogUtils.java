package com.tryine.zzp.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

/**
 * Name: DialogUtils
 * Details:
 * Created by PC on 2017/6/14.
 * Update:
 */

public class DialogUtils {
    public static void show(Context context, String msg, String PosBt, DialogInterface.OnClickListener PosBtClickListener) {
        show(context, null, msg, PosBt, PosBtClickListener);
    }

    public static void show(Context context, String title, String msg, String PosBt, DialogInterface.OnClickListener PosBtClickListener) {
        show(context, title, msg, PosBt, PosBtClickListener, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

    public static void show(Context context, String title, String msg, String PosBt, DialogInterface.OnClickListener PosBtClickListener, String NegBt, DialogInterface.OnClickListener NegBtClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        builder.setMessage(msg);
        builder.setPositiveButton(PosBt, PosBtClickListener);
        builder.setNegativeButton(NegBt, NegBtClickListener);
        builder.create().show();
    }

}
