package com.tryine.zzp.utils;

import android.os.Build;

/**
 * 项目名称：DevPKG
 * 类：AndroidVersionUtils
 * 描述：
 * 创建人：Yugr
 * 创建日期：2017/1/7
 * 时间：13:25
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class AndroidVersionUtils {

    /**
     * 获取当前设备SDK版本
     */
    public static int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 版本判断
     *
     * @param sdkVersion 需要判断的版本号  使用内部类Version类
     * @return true 当前版本大于或等于需要判断的版本
     */
    public static boolean checkSdkVersion(int sdkVersion) {

        return Build.VERSION.SDK_INT >= sdkVersion;
    }

    class Version extends Build.VERSION_CODES {

    }
}
