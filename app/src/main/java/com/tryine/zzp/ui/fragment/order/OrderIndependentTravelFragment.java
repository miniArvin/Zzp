package com.tryine.zzp.ui.fragment.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.OrderIndependentTravelAdapter;
import com.tryine.zzp.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderIndependentTravelFragment extends BaseFragment {

    private ListView order_independent_travel_fl_lv;
    private OrderIndependentTravelAdapter orderIndependentTravelAdapter;

    public OrderIndependentTravelFragment() {

    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_order_independent_travel;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        init();
    }

    public void init(){
        order_independent_travel_fl_lv= (ListView) mView.findViewById(R.id.order_independent_travel_fl_lv);
        orderIndependentTravelAdapter=new OrderIndependentTravelAdapter(mContext,mView);
        order_independent_travel_fl_lv.setAdapter(orderIndependentTravelAdapter);
    }

    public void loadData(){

    }

}
