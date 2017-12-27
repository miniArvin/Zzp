package com.tryine.zzp.ui.activity.mine.order;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.AllOrderAdapter;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.ui.fragment.order.ZZPOrderFragment;
import com.tryine.zzp.widget.NoScrollViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.ArrayList;
import java.util.List;

public class AllOrderActivity extends BaseStatusMActivity implements ZZPOrderFragment.OrderNumFragmentListener,View.OnClickListener {
    private List<String> titles;
    private List<Fragment> fragments;
    private MagicIndicator all_order_indicator;
    private NoScrollViewPager all_order_vp;
    private TextView view_head_title;
    private String orderNum="0";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_all_order;
    }

    @Override
    protected void afterOnCreate() {
        initView();
    }

    public void initView() {
        titles = new ArrayList<>();
        titles.add("掌中拍订单(0)");
        titles.add("自助定价(0)");
        titles.add("旅游订单(0)");
        fragments = new ArrayList<>();
        fragments.add(new ZZPOrderFragment());
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("全部订单");
        all_order_vp = (NoScrollViewPager) findViewById(R.id.all_order_vp);
        all_order_indicator = (MagicIndicator) findViewById(R.id.all_order_indicator);
        initMagicIndicator();
    }

    private void initMagicIndicator() {
        all_order_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return titles.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);

                // load custom layout
                View customLayout = LayoutInflater.from(context).inflate(R.layout.indicator_layout, null);
                final View titleV = customLayout.findViewById(R.id.title_v);
                final TextView titleText = (TextView) customLayout.findViewById(R.id.title_text);
                titleV.setBackgroundResource(R.color.home_location_btn);
                titleText.setText(titles.get(index));
                titleText.setTextSize(14f);
                titleText.setTextColor(getResources().getColor(R.color.home_location_btn));
                commonPagerTitleView.setContentView(customLayout);

                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {

                    @Override
                    public void onSelected(int index, int totalCount) {
                        titleText.setTextColor(getResources().getColor(R.color.home_location_btn));
                        titleV.setBackgroundResource(R.color.home_location_btn);
                    }

                    @Override
                    public void onDeselected(int index, int totalCount) {
                        titleText.setTextColor(getResources().getColor(R.color.home_location_word));
                        titleV.setBackgroundResource(R.color.white);
                    }

                    @Override
                    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {

                    }

                    @Override
                    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {

                    }
                });

                commonPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        all_order_vp.setCurrentItem(index);
                    }
                });

                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        all_order_indicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(all_order_indicator, all_order_vp);
    }


    @Override
    public void orderNum(String num) {
        orderNum = num;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_head_back:
                finish();
                break;
        }
    }
}
