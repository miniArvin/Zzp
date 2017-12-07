package com.tryine.zzp.ui.activity.hotel;


import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelListAdapter;
import com.tryine.zzp.adapter.HotelListSelectDialogAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.entity.test.remote.HotelListEntity;
import com.tryine.zzp.entity.test.remote.HotelListSelectEntity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class HotelListActivity extends BaseStatusMActivity implements View.OnClickListener {
    private ListView hotel_list_lv;
    private HotelListAdapter hotelListAdapter;
    private HotelListEntity hotelListEntities;
    private List<HotelListEntity.InfoBean> hotelListInfo;
    private Bundle bundle;
    private int fav;
    private ListView hotel_list_select_lv;
    private RecyclerView hotel_list_select_rv;
    private TextView hotel_list_select_tv;
    private TextView hotel_list_score_tv;
    private TextView hotel_list_level_tv;
    private TextView hotel_list_pai_tv;
    private ImageView hotel_list_select_iv;
    private ImageView hotel_list_score_iv;
    private ImageView hotel_list_level_iv;
    private ImageView hotel_list_pai_iv;
    private LinearLayout hotel_list_level_dialog;
    private LinearLayout hotel_list_select_dialog;
    private List<String> selectList;
    private HotelListSelectDialogAdapter hotelListSelectDialogAdapter;
    private List<HotelListSelectEntity.InfoBean.BrandBean> brandInfo;
    private List<HotelListSelectEntity.InfoBean.ServiceBean> serviceInfo;
    private List<HotelListSelectEntity.InfoBean.RoomBean> roomInfo;
    private String score ;
    private Boolean isSort;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_hotel_list;
    }

    @Override
    protected void afterOnCreate() {
        initView();
        loadMessage("","");
        hotelListSelectContent();
    }

    public void initView() {
        hotelListInfo = new ArrayList<>();
        selectList = new ArrayList<>();
        brandInfo = new ArrayList<>();
        serviceInfo = new ArrayList<>();
        roomInfo=new ArrayList<>();
        selectList.add("住宿类型");
        selectList.add("品牌");
        selectList.add("酒店设备");
        isSort= true;
        hotel_list_lv = (ListView) findViewById(R.id.hotel_list_lv);
        hotel_list_select_lv = (ListView) findViewById(R.id.hotel_list_select_lv);
        hotel_list_select_rv = (RecyclerView) findViewById(R.id.hotel_list_select_rv);
        hotel_list_select_tv = (TextView) findViewById(R.id.hotel_list_select_tv);
        hotel_list_score_tv = (TextView) findViewById(R.id.hotel_list_score_tv);
        hotel_list_level_tv = (TextView) findViewById(R.id.hotel_list_level_tv);
        hotel_list_pai_tv = (TextView) findViewById(R.id.hotel_list_pai_tv);
        hotel_list_select_iv = (ImageView) findViewById(R.id.hotel_list_select_iv);
        hotel_list_score_iv = (ImageView) findViewById(R.id.hotel_list_score_iv);
        hotel_list_level_iv = (ImageView) findViewById(R.id.hotel_list_level_iv);
        hotel_list_pai_iv = (ImageView) findViewById(R.id.hotel_list_pai_iv);
        findViewById(R.id.hotel_list_select_ll).setOnClickListener(this);
        findViewById(R.id.hotel_list_score_ll).setOnClickListener(this);
        findViewById(R.id.hotel_list_level_ll).setOnClickListener(this);
        findViewById(R.id.hotel_list_pai_ll).setOnClickListener(this);
        findViewById(R.id.hotel_list_select_result_tv).setOnClickListener(this);
        findViewById(R.id.hotel_list_select_empty_tv).setOnClickListener(this);
        findViewById(R.id.hotel_level_dialog_title_tv).setVisibility(View.GONE);
        hotel_list_level_dialog = (LinearLayout) findViewById(R.id.hotel_list_level_dialog);
        hotel_list_select_dialog = (LinearLayout) findViewById(R.id.hotel_list_select_dialog);
        hotelListSelectDialogAdapter = new HotelListSelectDialogAdapter(this, selectList);
        hotel_list_select_lv.setAdapter(hotelListSelectDialogAdapter);
        hotelListSelectDialogAdapter.setDefSelect(0);
        bundle = new Bundle();
    }

    public void loadData() {
        hotelListAdapter = new HotelListAdapter(this, hotelListInfo);
        hotel_list_lv.setAdapter(hotelListAdapter);
        hotel_list_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bundle.putString("hotel_id", hotelListInfo.get(position).getHotel_id());
                startAct(HotelDetailActivity.class, bundle);
            }
        });
        hotelListAdapter.setAddListener(new HotelListAdapter.OnAddListener() {
            @Override
            public void onCollect(View v, int position) {
                fav = hotelListInfo.get(position).getFav();
                if (fav == 0) {
                    hotelCollect(position);
                } else {
                    hotelCancelCollect(position);
                }
            }
        });
    }

    public void loadMessage(String key,String value) {
        OkHttpUtils
                .post()
                .url(Api.HOTELLIST)
                .addParams(key,value)
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
                            LogUtils.e(response.toString());
                            LogUtils.e(jsonObject);
                            Gson gson = new Gson();
                            hotelListEntities = gson.fromJson(response.toString(), HotelListEntity.class);
                            LogUtils.e(hotelListEntities.getStatus());
                            if (hotelListEntities.getStatus() == 330) {
                                hotelListInfo = hotelListEntities.getInfo();
                                loadData();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void hotelCollect(final int position) {
        OkHttpUtils
                .post()
                .url(Api.HOTELCOLLECT)
                .addParams("hotel_id", hotelListInfo.get(position).getHotel_id())
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
                            hotelListAdapter.updateItem(hotel_list_lv, position);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void hotelCancelCollect(final int position) {
        OkHttpUtils
                .post()
                .url(Api.HOTELCANCELCOLLECT)
                .addParams("hotel_id", hotelListInfo.get(position).getHotel_id())
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
                            hotelListAdapter.updateItem(hotel_list_lv, position);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hotel_list_select_empty_tv:
                break;
            case R.id.hotel_list_select_result_tv:
                break;
            case R.id.hotel_list_select_ll:
                if (hotel_list_select_dialog.getVisibility() == View.GONE) {
                    hotel_list_select_dialog.setVisibility(View.VISIBLE);
                    if (hotel_list_level_dialog.getVisibility() == View.VISIBLE) {
                        hotel_list_level_dialog.setVisibility(View.GONE);
                    }
                } else {
                    hotel_list_select_dialog.setVisibility(View.GONE);
                }
                break;
            case R.id.hotel_list_score_ll:
                if (isSort) {
                    score = "score_desc";
                    scoreSort(score);
                    isSort=false;
                }else {
                    score = "score_asc";
                    scoreSort(score);
                    isSort=true;
                }
                break;
            case R.id.hotel_list_level_ll:
                if (hotel_list_level_dialog.getVisibility() == View.GONE) {
                    hotel_list_level_dialog.setVisibility(View.VISIBLE);
                    if (hotel_list_select_dialog.getVisibility() == View.VISIBLE) {
                        hotel_list_select_dialog.setVisibility(View.GONE);
                    }
                } else {
                    hotel_list_level_dialog.setVisibility(View.GONE);
                }

                break;
            case R.id.hotel_list_pai_ll:
                break;

        }
    }

    public void isVisibility() {
        if (hotel_list_level_dialog.getVisibility() == View.VISIBLE) {
            hotel_list_level_dialog.setVisibility(View.GONE);
        }
        if (hotel_list_select_dialog.getVisibility() == View.VISIBLE) {
            hotel_list_select_dialog.setVisibility(View.GONE);
        }
    }

    public void hotelListSelectContent() {
        OkHttpUtils
                .post()
                .url(Api.HOTELLISTSELECT)
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
                            Gson gson = new Gson();
                            HotelListSelectEntity hotelListSelectEntity = gson.fromJson(response.toString(), HotelListSelectEntity.class);
                            if (hotelListSelectEntity.getStatus() == 330) {
                                brandInfo = hotelListSelectEntity.getInfo().getBrand();
                                serviceInfo = hotelListSelectEntity.getInfo().getService();
                                roomInfo = hotelListSelectEntity.getInfo().getRoom();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void scoreSort(String score){
        OkHttpUtils
                .post()
                .url(Api.HOTELLIST)
                .addParams("str",score)
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
                            Gson gson=new Gson();
                            hotelListEntities = gson.fromJson(response.toString(),HotelListEntity.class);
                            if (hotelListEntities.getStatus()==330){
                                hotelListInfo = hotelListEntities.getInfo();
                            }
                            loadData();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
