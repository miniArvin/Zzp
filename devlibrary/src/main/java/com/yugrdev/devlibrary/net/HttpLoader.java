package com.yugrdev.devlibrary.net;

/**
 * Name: HttpLoader
 * Details:
 * Created by PC on 2017/3/27.
 * Update:
 */

public class HttpLoader {
    private static HttpLoader sInstance;

    private HttpLoader() {
    }

    public static HttpLoader getInstance() {
        if (sInstance == null) {
            sInstance = new HttpLoader();
        }
        return sInstance;
    }


    public void get(String url, HttpParams params, Class<?> clazz, DisposeDataListener listener) {
        CustomOkHttpClient.sendRequest(CustomRequest.createGetRequest(url, params), new CustomCallback(new DisposeDataHandle(listener,clazz)));
    }
    public void post(String url, HttpParams params, Class<?> clazz, DisposeDataListener listener) {
        CustomOkHttpClient.sendRequest(CustomRequest.createPostRequest(url, params), new CustomCallback(new DisposeDataHandle(listener,clazz)));
    }



}
