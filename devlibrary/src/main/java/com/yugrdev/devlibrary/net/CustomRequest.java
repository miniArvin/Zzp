package com.yugrdev.devlibrary.net;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Name: CustomRequest
 * Details:
 * Created by PC on 2017/3/27.
 * Update:
 */

public class CustomRequest {

    public static Request createGetRequest(@NonNull String url, @Nullable HttpParams params) {
        if (params != null) {
            url = url + params.getGetParams();
        }
        return new Request.Builder().url(url)
                .get()
                .build();
    }

    public static Request createPostRequest(@NonNull String url, @Nullable HttpParams params) {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.getParams().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                formBodyBuilder.add(key, value);
            }
        }
        RequestBody body = formBodyBuilder.build();
        return new Request.Builder()
                .url(url)
                .post(body)
                .build();
    }
}
