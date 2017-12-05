package com.tryine.zzp.utils;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

/**
 * Name: IntentUtils
 * Details:
 * Created by PC on 2017/6/14.
 * Update:
 */

public class IntentUtils {
    /**
     * 直接拨打电话，Android M 后需要请求权限Manifest.permission.CALL_PHONE
     */
    public static void startCall(Context context, String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone.trim()));
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }
        context.startActivity(intent);
    }

    /**
     * 打开拨号界面，在拨号栏显示号码
     */
    public static void startCallPage(Context context, String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone.trim()));
        context.startActivity(intent);
    }


    /**
     * 在浏览器中打开链接
     */
    public static void startWeb(Context context, String url) {
        try {
            Uri uri = Uri.parse(url.trim());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new ActivityNotFoundException("Url Format Error! Url=" + url);
        }
    }

    public static void startQqChat(Context context, String qq) {
        try {

            String uri = "mqqwpa://im/chat?chat_type=wpa&uin=" + qq;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new ActivityNotFoundException("QQ not Found");
        }
    }
}
