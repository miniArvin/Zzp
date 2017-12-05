package com.yugrdev.devlibrary.net;


import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 项目名称：DevPKG
 * 类：CustomOkHttpClient
 * 描述：
 * 创建人：Yugr
 * 创建日期：2016/11/14
 * 时间：14:37
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class CustomOkHttpClient {
    private static final int TIME_OUT = 30;
    private static OkHttpClient client = null;

    static {
        //初始化HttpClient
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        /*--添加请求头--*/
//        okHttpClientBuilder.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request()
//                        .newBuilder()
//                        .addHeader("User-Agent", "Android—Mobile") // 标明发送本次请求的客户端
//                        .build();
//                return chain.proceed(request);
//            }
//        });
        client = okHttpClientBuilder.build();
    }


    public static Call sendRequest(Request request, Callback callback) {
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    public static Call sendRequest(Request request, CustomCallback callback) {
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }
}
