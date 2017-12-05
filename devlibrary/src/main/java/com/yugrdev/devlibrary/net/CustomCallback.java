package com.yugrdev.devlibrary.net;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.yugrdev.devlibrary.utils.ALog;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

/**
 * Name: CustomCallback
 * Details:
 * Created by PC on 2017/3/27.
 * Update:
 */

public class CustomCallback implements Callback {
    private final String COOKIE_STORE = "Set-Cookie";
    private Handler mHandler;
    private DisposeDataListener mListener;
    private Class<?> mClass;

    CustomCallback(DisposeDataHandle handle) {
        this.mListener = handle.mListener;
        this.mClass = handle.mClass;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onFailure(Call call, IOException e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new IOException("Net error!"));
            }
        });
    }

    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        final String result = response.body().string();
        ArrayList<String> cookieLists = handleCookie(response.headers());
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                ALog.i(result);
                handleResponse(result);
//                if(mListener instanceof  )
            }
        });
    }

    private ArrayList<String> handleCookie(Headers headers) {
        ArrayList<String> tempList = new ArrayList<>();
        for (int i = 0; i < headers.size(); i++) {
            if (headers.name(i).equalsIgnoreCase(COOKIE_STORE)) {
                tempList.add(headers.value(i));
            }
        }
        return tempList;
    }

    private void handleResponse(Object responseObj) {
        if ((responseObj == null) || responseObj.toString().trim().equals("")) {
            mListener.onFailure(new IOException(""));
            return;
        }
        try {
            String result = responseObj.toString();
            if (mClass == null) {
                mListener.onSuccess("Net error!");

            } else {
                //将json转化为实体类
                Object obj = new Gson().fromJson(result, mClass);
                if (obj != null) {
                    mListener.onSuccess(obj);
                } else {
                    mListener.onFailure(new Exception("Json Error!"));
                }
            }
        } catch (Exception e) {
            mListener.onFailure(new Exception("Unknow Error!"));
            e.printStackTrace();
        }
    }
}
