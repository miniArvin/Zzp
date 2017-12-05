package com.tryine.zzp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;

/**
 * Name: BaseStatusBarActivity
 * Details:
 * Created by PC on 2017/5/26.
 * Update:
 */

public abstract class BaseStatusBarActivity extends BaseActivity {
    public class BaseActivity extends AppCompatActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            ImmersionBar.with(this)
                    .statusBarDarkFont(true)
                    .init();
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            ImmersionBar.with(this).destroy();  //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        }
    }
}
