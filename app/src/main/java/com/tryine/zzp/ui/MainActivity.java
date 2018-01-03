package com.tryine.zzp.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseBottomTabsActivity;
import com.tryine.zzp.ui.activity.login.LoginActivity;
import com.tryine.zzp.ui.fragment.FoundFragment;
import com.tryine.zzp.ui.fragment.HomeFragment;
import com.tryine.zzp.ui.fragment.IndependentTravelFragment;
import com.tryine.zzp.ui.fragment.MineFragment;
import com.tryine.zzp.ui.fragment.OrderFragment;
import com.tryine.zzp.utils.PermissionUtils;
import com.tryine.zzp.widget.BottomTabView;

import java.util.ArrayList;
import java.util.List;

import static com.tryine.zzp.app.constant.Cons.SP_USER_ID;
import static com.tryine.zzp.app.constant.Cons.SP_USER_TOKEN;

public class MainActivity extends BaseBottomTabsActivity {
    private long mExitTime = 0;
    private int mSelectPosition;

    @Override
    protected void onResume() {
        super.onResume();
        mSelectPosition = getIntent().getIntExtra("position", 5);
        if (mSelectPosition != 5) {
            mainVP.setCurrentItem(mSelectPosition);
            setIntent(new Intent());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //隐藏状态栏
        super.onCreate(savedInstanceState);

        String[] permissions = {
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
//                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.CALL_PHONE,
//                Manifest.permission.READ_PHONE_STATE,
//                Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.ACCESS_COARSE_LOCATION
        };
        PermissionUtils.checkPermission(mActivity, permissions, 0);
        ImmersionBar.with(mActivity).statusBarDarkFont(true)
                .transparentStatusBar()
                .init();
        //初始化ViewPager Adapter
        FragmentPagerAdapter vpAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return getFragments().get(position);
            }

            @Override
            public int getCount() {
                return getFragments().size();
            }
        };
//        mainVP.setOffscreenPageLimit();
        mainVP.setAdapter(vpAdapter);
        //设置BottomTabView监听器，切换ViewPager
        mainBottomTab.setUpWithViewPager(mainVP);
        mainBottomTab.setOnTabItemSelectListener(new BottomTabView.OnTabItemSelectListener() {
            @Override
            public void onTabItemSelect(int position) {
                if (SPUtils.getInstance().getString(SP_USER_ID).equals("")&&(position==2||position==3)){
                    startAct(LoginActivity.class);
                }else {
                    mainVP.setCurrentItem(position, true);
                }

            }
        });
        //切换ViewPager时，同时切换BottomTabView
        mainVP.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //declare key
            Boolean first = true;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (first && positionOffset == 0 && positionOffsetPixels == 0) {
                    onPageSelected(0);
                    first = false;
                }
            }

            @Override
            public void onPageSelected(int position) {
                mainBottomTab.updatePosition(position);
                ImmersionBar immersionBar = ImmersionBar.with(mActivity);
                switch (position) {
                    case 0:
                        immersionBar.statusBarDarkFont(true)
                                .statusBarColor(R.color.bar)
                                .statusBarAlpha(0)
                                .init();
                        break;
                    case 1:
                        immersionBar.statusBarDarkFont(true)
                                .statusBarColor(R.color.bar)
                                .statusBarAlpha(0)
                                .init();
                        break;
                    case 2:
                        immersionBar.statusBarDarkFont(true)
                                .statusBarColor(R.color.bar)
                                .statusBarAlpha(0)
                                .init();

                        break;
                    case 3:
                        immersionBar.statusBarDarkFont(true)
                                .statusBarColor(R.color.bar)
                                .statusBarAlpha(0)
                                .init();
                        break;
//                    case 4:
//                        immersionBar.statusBarDarkFont(true)
//                                .statusBarColor(R.color.bar)
//                                .statusBarAlpha(0)
//                                .init();
//                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mainVP.setCurrentItem(mSelectPosition);
        loadData();
    }

    public void changePage(int position) {
        mainVP.setCurrentItem(position);

    }

    public void loadData(){

    }


    @Override
    protected List<BottomTabView.TabItemView> getTabViews() {
        List<BottomTabView.TabItemView> tabItemViews = new ArrayList<>();
        tabItemViews.add(new BottomTabView.TabItemView(this, "首页", R.color.black,
                R.color.orange, R.drawable.res_home_unselect, R.drawable.res_home_selected));
        tabItemViews.add(new BottomTabView.TabItemView(this, "发现", R.color.black,
                R.color.orange, R.drawable.res_found_unselect, R.drawable.res_found_selected));
//        tabItemViews.add(new BottomTabView.TabItemView(this, "自由行", R.color.black,
//                R.color.black, R.drawable.res_independent_travel_unselect, R.drawable.res_independent_travel_unselect));
        tabItemViews.add(new BottomTabView.TabItemView(this, "订单", R.color.black,
                R.color.orange, R.drawable.res_order_unselect, R.drawable.res_order_seletced));
        tabItemViews.add(new BottomTabView.TabItemView(this, "我的", R.color.black,
                R.color.orange, R.drawable.res_mine_unselect, R.drawable.res_mine_selected));
        return tabItemViews;
    }

    @Override
    protected List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new FoundFragment());
//        fragments.add(new IndependentTravelFragment());
        fragments.add(new OrderFragment());
        fragments.add(new MineFragment());
        return fragments;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(mActivity, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //记录当前系统时间
                mExitTime = System.currentTimeMillis();
                return true;
            } else {
                mActivity.finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        //here we can use getIntent() to get the extra data.
    }
}
