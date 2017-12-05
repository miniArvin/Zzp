package com.tryine.zzp.ui.activity.hotel;


import android.widget.ListView;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MinePublishCommentAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.entity.test.remote.HotelListEntity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;


import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class HotelListActivity extends BaseStatusMActivity {
    private ListView hotel_list_lv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type = 5;
    private HotelListEntity hotelListEntities;
    private List<HotelListEntity.InfoBean> hotelListInfo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hotel_list;
    }

    @Override
    protected void afterOnCreate() {
        initView();
        loadMessage();
    }

    public void initView() {
        hotelListInfo=new ArrayList<>();
        hotel_list_lv = (ListView) findViewById(R.id.hotel_list_lv);
        minePublishCommentAdapter = new MinePublishCommentAdapter(null, this, type);
        hotel_list_lv.setAdapter(minePublishCommentAdapter);
    }

    public void loadData() {

    }

    public void loadMessage() {
        OkHttpUtils
                .post()
                .url(Api.HOTELLIST)
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
                            Gson gson = new Gson();
                            hotelListEntities = (gson.fromJson(response.toString(), HotelListEntity.class));
                            if (hotelListEntities.getStatus() == 330) {
                                hotelListInfo=hotelListEntities.getInfo();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
