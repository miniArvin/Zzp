package com.tryine.zzp.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.tryine.zzp.R;

/**
 * Name: UIUtils
 * Details:
 * Created by PC on 2017/6/21.
 * Update:
 */

public class UIUtils {
    public static void startAct(Activity activity, Class clazz) {
        startAct(activity, clazz, null);
    }

    public static void startAct(Activity activity, Class clazz, Bundle bundle) {
        Intent intent = new Intent(activity, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.start_in_left, R.anim.start_out_left);
    }
}
