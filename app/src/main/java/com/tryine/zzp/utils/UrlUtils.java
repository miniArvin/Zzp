package com.tryine.zzp.utils;

import android.text.TextUtils;

/**
 * Name: UrlUtils
 * Details:
 * Created by PC on 2017/7/10.
 * Update:
 */

public class UrlUtils {
    public static String getUrl(String url) {
        if (!TextUtils.isEmpty(url)) {
            if (url.contains("http"))
                return url;
            return "http://" + url;
        } else {
            return "";
        }
    }
}
