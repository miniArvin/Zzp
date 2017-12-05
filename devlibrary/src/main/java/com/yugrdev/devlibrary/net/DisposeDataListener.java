package com.yugrdev.devlibrary.net;

/**
 * Name: DisposeDataListener
 * Details:
 * Created by PC on 2017/3/27.
 * Update:
 */

public interface DisposeDataListener<T> {
    void onSuccess(T t);

    void onFailure(Object reasonObj);
}
