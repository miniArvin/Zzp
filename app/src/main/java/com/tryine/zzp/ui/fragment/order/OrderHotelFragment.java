package com.tryine.zzp.ui.fragment.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.OrderHotelAdapter;
import com.tryine.zzp.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderHotelFragment extends BaseFragment {

    private RecyclerView order_hotel_fl_rv;
    private OrderHotelAdapter orderHotelAdapter;

    public OrderHotelFragment() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_order_hotel;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {

        init();
        loadData();
    }

    public void init(){
        order_hotel_fl_rv= (RecyclerView) mView.findViewById(R.id.order_hotel_fl_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        order_hotel_fl_rv.setLayoutManager(linearLayoutManager);
        orderHotelAdapter=new OrderHotelAdapter(mContext,mView);
        order_hotel_fl_rv.setAdapter(orderHotelAdapter);
    }

    public void loadData(){

    }

}
