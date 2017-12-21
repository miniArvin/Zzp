package com.tryine.zzp.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.FoundFoodViewAdapter;
import com.tryine.zzp.adapter.FoundLocationNameAdapter;
import com.tryine.zzp.adapter.FoundNewsAdapter;
import com.tryine.zzp.adapter.FoundQuestionsAdapter;
import com.tryine.zzp.entity.test.TestEntity;
import com.tryine.zzp.ui.activity.found.FoundDetailActivity;
import com.tryine.zzp.ui.activity.hotel.HotelListActivity;
import com.tryine.zzp.widget.FlowLayout.SpaceItemDecoration;
import com.tryine.zzp.widget.NoScrollListView;
import com.tryine.zzp.base.BaseFragment;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class FoundFragment extends BaseFragment implements View.OnClickListener {

    private RecyclerView found_location_name_rv;
    private TestEntity locationEntity;
    private List<TestEntity> locationList;
    private FoundLocationNameAdapter foundLocationNameAdapter;
    private RecyclerView found_food_view_rv;
    private FoundFoodViewAdapter foundFoodViewAdapter;
    private NoScrollListView found_news_lv;
    private FoundNewsAdapter foundNewsAdapter;
    private LinearLayout found_food_view_more_ll;
    private LinearLayout found_question_more_ll;
    private LinearLayout found_news_more_ll;
    private LinearLayout found_hotel_more_ll;
    private NoScrollListView found_question_lv;
    private FoundQuestionsAdapter foundQuestionsAdapter;
    private Banner found_banner;

    public FoundFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_found;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        init();
        loadData();
    }

    public void init(){
        locationEntity=new TestEntity();
        locationList=new ArrayList<>();
        found_location_name_rv= (RecyclerView) mView.findViewById(R.id.found_location_name_rv);
        found_food_view_rv= (RecyclerView) mView.findViewById(R.id.found_food_view_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        found_location_name_rv.setLayoutManager(linearLayoutManager);
        found_location_name_rv.setNestedScrollingEnabled(false);
        foundLocationNameAdapter=new FoundLocationNameAdapter(mView,mContext,locationList);
        found_location_name_rv.setAdapter(foundLocationNameAdapter);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(mView.getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        found_food_view_rv.setLayoutManager(linearLayoutManager1);
        found_food_view_rv.setNestedScrollingEnabled(false);
        found_food_view_rv.addItemDecoration(new SpaceItemDecoration(dp2px(5)));
        foundFoodViewAdapter=new FoundFoodViewAdapter(mView,mContext);
        found_food_view_rv.setAdapter(foundFoodViewAdapter);
        found_news_lv= (NoScrollListView) mView.findViewById(R.id.found_news_lv);
        foundNewsAdapter =new FoundNewsAdapter(mView,mContext);
        found_news_lv.setAdapter(foundNewsAdapter);
        found_question_lv= (NoScrollListView) mView.findViewById(R.id.found_question_lv);
        foundQuestionsAdapter=new FoundQuestionsAdapter(mView,mContext);
        found_question_lv.setAdapter(foundQuestionsAdapter);
        found_food_view_more_ll= (LinearLayout) mView.findViewById(R.id.found_food_view_more_ll);
        found_question_more_ll= (LinearLayout) mView.findViewById(R.id.found_question_more_ll);
        found_news_more_ll= (LinearLayout) mView.findViewById(R.id.found_news_more_ll);
        found_hotel_more_ll= (LinearLayout) mView.findViewById(R.id.found_hotel_more_ll);
        found_food_view_more_ll.setOnClickListener(this);
        found_news_more_ll.setOnClickListener(this);
        found_question_more_ll.setOnClickListener(this);
        found_hotel_more_ll.setOnClickListener(this);
        found_banner = (Banner) mView.findViewById(R.id.found_banner);
    }

    public void loadData(){
        locationEntity.mImg=R.drawable.found_location_icon;
        locationEntity.mName="天门山";
        locationEntity.mLocation="奇山、奇石、玻璃桥";
        locationList.add(locationEntity);
        foundLocationNameAdapter.notifyDataSetChanged();
        foundFoodViewAdapter.notifyDataSetChanged();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.found_food_view_more_ll:
                startAct(FoundDetailActivity.class);
                break;
            case R.id.found_news_more_ll:
                startAct(FoundDetailActivity.class);
                break;
            case R.id.found_question_more_ll:
                startAct(FoundDetailActivity.class);
                break;
            case R.id.found_hotel_more_ll:
                startAct(HotelListActivity.class);
                break;
        }
    }

    public int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
