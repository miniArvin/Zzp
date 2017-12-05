package com.tryine.zzp.utils.FragmentUtil;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class CollectFragmentController {
    private int containerId;
    private FragmentManager fm;
    private List<Fragment> fragments;

    private static CollectFragmentController controller;

    public static CollectFragmentController getInstance(FragmentActivity activity, int containerId, List<Fragment> mFragments) {
        if (controller == null) {
            controller = new CollectFragmentController(activity, containerId,mFragments);
        }
        return controller;
    }

    private CollectFragmentController(FragmentActivity activity, int containerId, List<Fragment> mFragments) {
        this.containerId = containerId;
        fm = activity.getSupportFragmentManager();
        fragments=mFragments;
        initFragment();
    }

    private void initFragment() {
        FragmentTransaction ft = fm.beginTransaction();
        for(Fragment fragment : fragments) {
            ft.add(containerId, fragment);
        }
        ft.commit();
    }

    public void showFragment(int position) {
        hideFragments();
        Fragment fragment = fragments.get(position);
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragment);
        ft.commit();
    }

    public void hideFragments() {
        FragmentTransaction ft = fm.beginTransaction();
        for(Fragment fragment : fragments) {
            if(fragment != null) {
                ft.hide(fragment);
            }
        }
        ft.commit();
    }

    public Fragment getFragment(int position) {
        return fragments.get(position);
    }
    public void destoryController(){
        controller = null;
    }

}
