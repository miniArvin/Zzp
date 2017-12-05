package com.yugrdev.devlibrary.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.yugrdev.devlibrary.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 项目名称：DevPKG
 * 类：StatusBarUtils
 * 描述：
 * 创建人：Yugr
 * 创建日期：2016/11/24
 * 时间：11:19
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public class StatusBarUtils {
    /**
     * @param activity
     * @param windowLightStatusBar true:设置StatusBar字体为深色，false:设置StatusBar字体为白色
     */
    public static void setThemeForM(Activity activity, boolean windowLightStatusBar) {
        if (AndroidVersionUtils.checkSdkVersion(AndroidVersionUtils.Version.M)) {
            if (windowLightStatusBar) {
                activity.setTheme(R.style.AppTheme_M_StatusBarTextDark);
            } else {
                activity.setTheme(R.style.AppTheme_M_StatusBarTextLight);

            }
        }
    }

    /**
     * 设置状态栏颜色
     *
     * @param activity 需要设置的Activity
     * @param color    状态栏颜色
     * @param isFits   布局是否填充状态栏
     */
    public static void setColor(Activity activity, int color, boolean isFits) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 生成一个状态栏大小的矩形
            View statusView = createStatusView(activity, color);
            // 添加 statusView 到布局中
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
            View childView = decorView.getChildAt(0);
            if (childView == statusView) {

            }
            decorView.addView(statusView);
            // 设置根布局的参数
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(isFits);
            rootView.setClipToPadding(true);
        }
    }

    /**
     * @param activity 需要设置的Activity
     * @param color    状态栏颜色
     * @return
     */
    private static View createStatusView(Activity activity, int color) {
        // 获得状态栏高度
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);

        // 绘制一个和状态栏一样高的矩形
        View statusView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                statusBarHeight);
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);
        return statusView;
    }


    /**
     * 使状态栏透明
     *
     * @param activity
     * @param isFits   布局是否填充状态栏
     */
    public static void setTranslucent(Activity activity, boolean isFits) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 设置根布局的参数
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(isFits);
            rootView.setClipToPadding(true);
        }
    }

    /**
     * 设置MIUI状态栏为夜晚模式
     *
     * @param activity
     * @param darkmode
     * @return
     */
    public static boolean setMiuiStatusBarDarkMode(Activity activity, boolean darkmode) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag = 0;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(activity.getWindow(), darkmode ? darkModeFlag : 0, darkModeFlag);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 设置Meizu状态栏夜晚模式
     *
     * @param activity
     * @param dark
     * @return
     */
    public static boolean setMeizuStatusBarDarkIcon(Activity activity, boolean dark) {
        boolean result = false;
        if (activity != null) {
            try {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                activity.getWindow().setAttributes(lp);
                result = true;
            } catch (Exception e) {
            }
        }
        return result;
    }

}
