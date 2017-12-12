package com.tryine.zzp.ui.fragment;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MagicIndicatorPagerAdapter;
import com.tryine.zzp.ui.activity.mine.order.AllOrderActivity;
import com.tryine.zzp.ui.fragment.order.OrderHotelFragment;
import com.tryine.zzp.ui.fragment.order.OrderIndependentTravelFragment;
import com.tryine.zzp.utils.FragmentUtil.OrderFragmentController;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.widget.NoScrollViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;


public class OrderFragment extends BaseFragment implements View.OnClickListener{
    private List<String> titles;
    private List<Fragment> fragments;
    private TextView order_all_order_btn;
    private LinearLayout order_hotel_ll;
    private LinearLayout order_independent_travel_ll;
    public String firstTabShow="hotel";
    private MagicIndicator order_indicator;
    private NoScrollViewPager order_vp;

    public OrderFragment() {

    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_order;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        init();
    }

    public void init(){
        titles=new ArrayList<>();
        titles.add("酒店");
        titles.add("自由行");
        fragments=new ArrayList<>();
        fragments.add(new OrderHotelFragment());
        fragments.add(new OrderIndependentTravelFragment());
        order_vp = (NoScrollViewPager) mView.findViewById(R.id.order_vp);
        order_indicator = (MagicIndicator) mView.findViewById(R.id.order_indicator);
        order_all_order_btn= (TextView) mView.findViewById(R.id.order_all_order_btn);
        order_all_order_btn.setOnClickListener(this);
        initMagicIndicator();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order_all_order_btn:
                startAct(AllOrderActivity.class);
            default:
                break;
        }
    }

    private void initMagicIndicator() {
        order_vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        CommonNavigator commonNavigator = new CommonNavigator(mContext);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titles == null ? 0 : titles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(titles.get(index));
                simplePagerTitleView.setNormalColor(Color.BLACK);
                simplePagerTitleView.setTextSize(14);
                simplePagerTitleView.setSelectedColor(Color.parseColor("#f08519"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        order_vp.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(Color.parseColor("#f08519"));
                return indicator;
            }

        });
        order_indicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(order_indicator, order_vp);
    }

}
