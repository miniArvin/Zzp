package com.tryine.zzp.utils;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.tryine.zzp.R;

/**
 * Name: TimerUtils
 * Details:
 * Created by PC on 2017/7/5.
 * Update:
 * <p>
 * 计时器
 */
public class TimerUtils {


    public static void CountDownTimer(final TextView view, int time, String beforestr, String afterstr, OnCountDownFinishListener listener) {
        CountDownTimer(view, time, 1000, beforestr, afterstr, listener);
    }

    public static void CountDownTimer(final TextView view, int time, String afterstr, OnCountDownFinishListener listener) {
        CountDownTimer(view, time, 1000, "", afterstr, listener);
    }

    public static void CountDownTimer(final TextView view, int time, OnCountDownFinishListener listener) {
        CountDownTimer(view, time, 1000, "", "", listener);
    }

    public static void CountDownTimer(final TextView view, int time, int wait, final String beforestr, final String afterstr, final OnCountDownFinishListener listener) {
        final String TVtext = view.getText().toString().trim();
        final CountDownTimer countDownTimer = new CountDownTimer(time, wait) {
            @Override
            public void onTick(long l) {
                //倒计时每秒的回调
                view.setText(beforestr + l / 1000 + afterstr);
                view.setClickable(false);
                view.setBackgroundResource(R.drawable.register_bg_gray);
            }

            @Override
            public void onFinish() {
                //倒计时结束
                view.setText(TVtext);
                view.setClickable(true);
                view.setBackgroundResource(R.drawable.login_bg_code);
                listener.OnCountDownFinish();
            }
        };
        countDownTimer.start();
    }


    public interface OnCountDownFinishListener {
        void OnCountDownFinish();
    }
}
