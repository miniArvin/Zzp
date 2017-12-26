package com.tryine.zzp.ui.fragment.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.OrderHotelAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.entity.test.remote.OrderEntity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderHotelFragment extends BaseFragment {

    private RecyclerView order_hotel_fl_rv;
    private OrderHotelAdapter orderHotelAdapter;
    private List<OrderEntity.InfoBean> infoBeen;
    public OrderHotelFragment() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_order_hotel;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        loadMessage();
        initView();
    }

    public void initView(){
        infoBeen = new ArrayList<>();
        order_hotel_fl_rv= (RecyclerView) mView.findViewById(R.id.order_hotel_fl_rv);
    }

    public void loadData(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        order_hotel_fl_rv.setLayoutManager(linearLayoutManager);
        orderHotelAdapter=new OrderHotelAdapter(mContext,mView,infoBeen);
        order_hotel_fl_rv.setAdapter(orderHotelAdapter);
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.ORDER)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        LogUtils.e(string);
                        return string;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e(e);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                            if (jsonObject.getInt("status")==330){
                                Gson gson = new Gson();
                                OrderEntity orderEntity = gson.fromJson(response.toString(),OrderEntity.class);
                                infoBeen = orderEntity.getInfo();
                                loadData();
                            }else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

}
