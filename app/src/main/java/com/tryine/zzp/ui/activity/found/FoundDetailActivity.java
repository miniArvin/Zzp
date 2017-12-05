package com.tryine.zzp.ui.activity.found;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.ui.fragment.found.FoundDetailFoodFragment;
import com.tryine.zzp.ui.fragment.found.FoundDetailNewsFragment;
import com.tryine.zzp.ui.fragment.found.FoundDetailQuestionFragment;
import com.tryine.zzp.widget.NoScrollViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

public class FoundDetailActivity extends BaseStatusMActivity implements View.OnClickListener {
    private List<String> titles;
    private List<Fragment> fragments;
    private NoScrollViewPager found_detail_vp;
    private MagicIndicator found_detail_indicator;
    private ImageView found_detail_show_iv;
    private LinearLayout found_detail_article_ll;
    private LinearLayout found_detail_question_ll;
    private Boolean isShow=false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_found_detail;
    }

    @Override
    protected void afterOnCreate() {

    }
    public void init(){
        titles=new ArrayList<>();
        titles.add("美食·美景");
        titles.add("趣味问答");
        titles.add("新闻咨询");
        fragments=new ArrayList<>();
        fragments.add(new FoundDetailFoodFragment());
        fragments.add(new FoundDetailQuestionFragment());
        fragments.add(new FoundDetailNewsFragment());
        found_detail_vp = (NoScrollViewPager) findViewById(R.id.found_detail_vp);
        found_detail_indicator = (MagicIndicator) findViewById(R.id.found_detail_indicator);
        initMagicIndicator();
        found_detail_show_iv= (ImageView) findViewById(R.id.found_detail_show_iv);
        found_detail_show_iv.setOnClickListener(this);
        found_detail_article_ll= (LinearLayout) findViewById(R.id.found_detail_article_ll);
        found_detail_article_ll.setOnClickListener(this);
        found_detail_question_ll= (LinearLayout) findViewById(R.id.found_detail_question_ll);
        found_detail_question_ll.setOnClickListener(this);
    }

    private void initMagicIndicator() {
        found_detail_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
                        found_detail_vp.setCurrentItem(index);
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
        found_detail_indicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(found_detail_indicator, found_detail_vp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.found_detail_show_iv:
                if (!isShow){
                    found_detail_article_ll.setVisibility(View.VISIBLE);
                    found_detail_question_ll.setVisibility(View.VISIBLE);
                    found_detail_show_iv.setImageResource(R.drawable.found_detail_float_hidden_icon);
                    isShow=true;
                }else {
                    found_detail_article_ll.setVisibility(View.GONE);
                    found_detail_question_ll.setVisibility(View.GONE);
                    found_detail_show_iv.setImageResource(R.drawable.found_detail_float_show_icon);
                    isShow=false;
                }

                break;
            case R.id.found_detail_article_ll:
                break;
            case R.id.found_detail_question_ll:
                break;
        }
    }
}
