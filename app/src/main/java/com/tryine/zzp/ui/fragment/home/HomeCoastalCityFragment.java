package com.tryine.zzp.ui.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.CityNameAdapter;
import com.tryine.zzp.adapter.HotelRecommendAdapter;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.entity.test.remote.HomeEntity;
import com.tryine.zzp.utils.SpaceItemDecoration;
import com.zhy.adapter.abslistview.CommonAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeCoastalCityFragment extends BaseFragment {
    private List<HomeEntity.InfoBean.CoastalCityBean> coastalCityBeen;
    private RecyclerView home_city_rv;
    private CityNameAdapter cityNameAdapter;


    public HomeCoastalCityFragment() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home_coastal_city;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        coastalCityBeen = (List<HomeEntity.InfoBean.CoastalCityBean>) getArguments().get("coastal");
        initView();
    }

    public void initView(){
        home_city_rv = (RecyclerView) mView.findViewById(R.id.home_city_rv);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.home_city_item_div);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        home_city_rv.setLayoutManager(linearLayoutManager);
        home_city_rv.setNestedScrollingEnabled(false);
        cityNameAdapter = new CityNameAdapter (mContext, null,coastalCityBeen,null,null, mView);
        home_city_rv.addItemDecoration(new SpaceItemDecoration(spacingInPixels,SpaceItemDecoration.HORIZONTAL_LIST));
        home_city_rv.setAdapter(cityNameAdapter);
    }

}
