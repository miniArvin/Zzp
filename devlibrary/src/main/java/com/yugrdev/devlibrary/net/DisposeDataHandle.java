package com.yugrdev.devlibrary.net;

/**
 * Name: DisposeDataHandle
 * Details:
 * Created by PC on 2017/3/27.
 * Update:
 */

public class DisposeDataHandle {
    public DisposeDataListener mListener;
    public Class<?> mClass;

    public DisposeDataHandle(DisposeDataListener listener) {
        this.mListener = listener;
    }

    public DisposeDataHandle(DisposeDataListener listener, Class<?> clazz) {
        this.mListener = listener;
        mClass = clazz;
    }


}
