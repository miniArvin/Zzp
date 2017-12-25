package com.tryine.zzp.ui.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.CityNameAdapter;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.entity.test.remote.HomeEntity;
import com.tryine.zzp.utils.SpaceItemDecoration;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeGourmetCityFragment extends BaseFragment {
    private List<HomeEntity.InfoBean.GourmetCityBean> gourmetCityBeen;
    private RecyclerView home_city_rv;
    private CityNameAdapter cityNameAdapter;
    public HomeGourmetCityFragment() {
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home_gourmet_city;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        gourmetCityBeen = (List<HomeEntity.InfoBean.GourmetCityBean>) getArguments().get("gourmet");
        initView();
    }

    public void initView(){
        home_city_rv = (RecyclerView) mView.findViewById(R.id.home_city_rv);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.home_city_item_div);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        home_city_rv.setLayoutManager(linearLayoutManager);
        home_city_rv.setNestedScrollingEnabled(false);
        cityNameAdapter = new CityNameAdapter (mContext, null,null,gourmetCityBeen,null, mView);
        home_city_rv.addItemDecoration(new SpaceItemDecoration(spacingInPixels,SpaceItemDecoration.HORIZONTAL_LIST));
        home_city_rv.setAdapter(cityNameAdapter);
    }

}
