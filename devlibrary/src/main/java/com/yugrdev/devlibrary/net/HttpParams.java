package com.yugrdev.devlibrary.net;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Name: HttpParams
 * Details:
 * Created by PC on 2017/3/24.
 * Update:
 */

public class HttpParams {
    private Map<String, String> mParams = new HashMap<>();

    public Map<String, String> getParams() {
        return mParams;
    }


    public String getGetParams() {
        StringBuilder stringBuilder = new StringBuilder();
        if (mParams != null) {
            stringBuilder.append("?");
            for (Map.Entry<String, String> entry : mParams.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    stringBuilder.append(key);
                    stringBuilder.append("=");
                    stringBuilder.append(value);
                    stringBuilder.append("&");
                }
            }
        }
        String str = stringBuilder.toString();
        //截取字符串 去掉末尾的&
        if (str.endsWith("&")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public String get(String key) {
        return mParams.get(key);
    }

    public HttpParams put(String key, String value) {
        mParams.put(key, value);
        return this;
    }

    public HttpParams putAll(Map<String, String> map) {
        mParams.putAll(map);
        return this;
    }

}
