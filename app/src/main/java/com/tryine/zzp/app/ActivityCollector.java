package com.tryine.zzp.app;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yugr on 2017/9/1 0:20.
 * Introduce:
 * Update by
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }


    public static void saveActivity(Class clz) {
        for (Activity act : activities) {
            if (clz.isInstance(act)) {
                return;
            }
            if (!act.isFinishing()) {
                act.finish();
            }
        }
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
