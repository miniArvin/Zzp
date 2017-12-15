package com.tryine.zzp.base;

import com.gyf.barlibrary.ImmersionBar;
import com.tryine.zzp.R;

/**
 * Name: BaseStatusMActivity
 * Details:
 * Created by PC on 2017/5/25.
 * Update:
 */

public abstract class BaseStatusMActivity extends BaseActivity {
    @Override
    protected void init() {
        super.init();
        ImmersionBar.with(this)
                .statusBarColor(R.color.bar)
//                .navigationBarColor(R.color.black)
                .statusBarAlpha(0)
//                .navigationBarAlpha(0)
//                .fitsSystemWindows(true)
                .statusBarDarkFont(true)
                .init();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();  //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }

}
