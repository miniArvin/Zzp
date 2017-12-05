package com.tryine.zzp.ui.activity.mine.publish;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.ui.fragment.mine.MyPublishArticleFragment;
import com.tryine.zzp.ui.fragment.mine.MyPublishOrderCommentFragment;
import com.tryine.zzp.ui.fragment.mine.MyPublishQuestionsFragment;
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

public class MyPublishActivity extends BaseStatusMActivity {
    private List<Fragment> fragments;
    private List<String> titles;
    private MagicIndicator mine_publish_indicator;
    private NoScrollViewPager mine_publish_vp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_publish;
    }

    @Override
    protected void afterOnCreate() {
        init();
    }

    public void init(){
        titles = new ArrayList<>();
        titles.add("订单点评(20)");
        titles.add("文章(8)");
        titles.add("问答(4)");
        fragments=new ArrayList<>();
        fragments.add(new MyPublishOrderCommentFragment());
        fragments.add(new MyPublishArticleFragment());
        fragments.add(new MyPublishQuestionsFragment());
        mine_publish_indicator= (MagicIndicator) findViewById(R.id.mine_publish_indicator);
        mine_publish_vp= (NoScrollViewPager) findViewById(R.id.mine_publish_vp);
        initMagicIndicator();
    }

    private void initMagicIndicator() {

        mine_publish_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
                titleText.setTextSize(15f);
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
                        mine_publish_vp.setCurrentItem(index);
                    }
                });

                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        mine_publish_indicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mine_publish_indicator, mine_publish_vp);
    }

}
