package com.tryine.zzp.ui.activity.hotel;


import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.SearchKeyWordAdapter;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.widget.FlowLayout.FlowLayoutManager;
import com.tryine.zzp.widget.FlowLayout.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class SearchKeyWordActivity extends BaseStatusMActivity {
    private List<String> lists;
    private SearchKeyWordAdapter searchKeyWordAdapter;
    private RecyclerView search_key_word_location_rv;
    private RecyclerView search_key_word_hotel_rv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_key_word;
    }

    @Override
    protected void afterOnCreate() {
        init();
    }

    public void init(){
        lists=new ArrayList<>();
        lists.add("长沙");
        lists.add("上海");
        lists.add("北京");
        lists.add("成都");
        lists.add("南京");
        lists.add("乌鲁木齐");
        lists.add("北海");
        search_key_word_hotel_rv= (RecyclerView) findViewById(R.id.search_key_word_hotel_rv);
        search_key_word_location_rv= (RecyclerView) findViewById(R.id.search_key_word_location_rv);
        searchKeyWordAdapter=new SearchKeyWordAdapter(lists,this);
        FlowLayoutManager flowLayoutManagerLocation = new FlowLayoutManager();
        search_key_word_location_rv.addItemDecoration(new SpaceItemDecoration(dp2px(5)));
        search_key_word_location_rv.setLayoutManager(flowLayoutManagerLocation);
        search_key_word_location_rv.setAdapter(searchKeyWordAdapter);
        FlowLayoutManager flowLayoutManagerHotel = new FlowLayoutManager();
        search_key_word_hotel_rv.addItemDecoration(new SpaceItemDecoration(dp2px(5)));
        search_key_word_hotel_rv.setLayoutManager(flowLayoutManagerHotel);
        search_key_word_hotel_rv.setAdapter(searchKeyWordAdapter);
    }

    public int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
