package com.tryine.zzp.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;


/**
 * Name: PermissionUtils
 * Details:
 * Created by PC on 2017/3/21.
 * Update:
 */

public class PermissionUtils {
    /**
     * @param activity              当前Activity 需要在Activity中 重写onRequestPermissionsResult()方法实现回调
     * @param permission            权限名 android.manifest.permission
     * @param permissionRequestCode 请求码
     * @return true 系统低于M or 未授权 false 已授权
     */
    public static boolean checkPermission(@NonNull Activity activity, @NonNull String permission, @NonNull int permissionRequestCode) {
        if (AndroidVersionUtils.checkSdkVersion(Build.VERSION_CODES.M)) {
            if (PackageManager.PERMISSION_DENIED == ContextCompat.checkSelfPermission(activity, permission)) {
//            String[] perms = {"android.permission.CAMERA"};
                String[] perms = {permission};
                activity.requestPermissions(perms, permissionRequestCode);
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * @param activity              当前Activity 需要在Activity中 重写onRequestPermissionsResult()方法实现回调
     * @param permissions           权限名 android.manifest.permission
     * @param permissionRequestCode 请求码
     * @return true 系统低于M or 未授权 false 已授权
     */
    public static boolean checkPermission(@NonNull Activity activity, @NonNull String[] permissions, @NonNull int permissionRequestCode) {
        if (AndroidVersionUtils.checkSdkVersion(Build.VERSION_CODES.M)) {
            for (String perms : permissions) {
                if (PackageManager.PERMISSION_DENIED == ContextCompat.checkSelfPermission(activity, perms)) {
                    activity.requestPermissions(permissions, permissionRequestCode);
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
