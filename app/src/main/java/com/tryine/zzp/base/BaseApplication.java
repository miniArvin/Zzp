package com.tryine.zzp.base;

import android.app.Application;
import android.content.Context;

/**
 * 项目名称：DevPKG
 * 类：BaseApplication
 * 描述：
 * 创建人：Yugr
 * 创建日期：2016/11/14
 * 时间：14:07
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public abstract class BaseApplication extends Application {
    private static BaseApplication sInstance;


    public BaseApplication() {
        sInstance = this;
    }

    public static Context getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    protected abstract void init();

}
