package com.tryine.zzp.base;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.tryine.zzp.R;
import com.tryine.zzp.widget.BottomTabView;

import java.util.List;

/**
 * Name: BaseBottomTabsActivity
 * Details:
 * Created by PC on 2017/5/22.
 * Update:
 */

public abstract class BaseBottomTabsActivity extends BaseStatusBarActivity {

    protected ViewPager mainVP;
    protected BottomTabView mainBottomTab;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void afterOnCreate() {
        mainBottomTab = (BottomTabView) findViewById(R.id.main_bottom);
        mainVP = (ViewPager) findViewById(R.id.main_vp);
        if (getCenterView() == null) {
            mainBottomTab.setTabItemViews(getTabViews());
        } else {
            mainBottomTab.setTabItemViews(getTabViews(), getCenterView());
        }
    }


    protected abstract List<BottomTabView.TabItemView> getTabViews();

    protected abstract List<Fragment> getFragments();

    protected View getCenterView() {
        return null;
    }

}
