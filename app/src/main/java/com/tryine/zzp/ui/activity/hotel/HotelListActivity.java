package com.tryine.zzp.ui.activity.hotel;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelListAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.entity.test.remote.HotelListEntity;
import com.tryine.zzp.entity.test.remote.HotelListSelectEntity;
import com.tryine.zzp.ui.fragment.hotel.HotelListLevelFragment;
import com.tryine.zzp.ui.fragment.hotel.HotelListSelectFragment;
import com.tryine.zzp.ui.fragment.hotel.SelectBrandFragment;
import com.tryine.zzp.ui.fragment.hotel.SelectRoomFragment;
import com.tryine.zzp.ui.fragment.hotel.SelectServiceFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class HotelListActivity extends BaseStatusMActivity implements View.OnClickListener,
        HotelListLevelFragment.LevelFragmentListener,
        HotelListSelectFragment.SelectFragmentListener,
        SelectServiceFragment.ServiceFragmentListener,
        SelectRoomFragment.RoomFragmentListener,
        SelectBrandFragment.BrandFragmentListener {
    private ListView hotel_list_lv;
    private HotelListAdapter hotelListAdapter;
    private HotelListEntity hotelListEntities;
    private List<HotelListEntity.InfoBean> hotelListInfo;
    private List<HotelListEntity.InfoBean> hotelListTemp;
    private Bundle bundle;
    private int fav;
    private View hotel_list_fl;
    private TextView hotel_list_score_tv;
    private TextView hotel_list_level_tv;
    private TextView hotel_list_pai_tv;
    private TextView hotel_list_select_tv;
    private ImageView hotel_list_select_iv;
    private ImageView hotel_list_score_iv;
    private ImageView hotel_list_level_iv;
    private ImageView hotel_list_pai_iv;
    private HotelListLevelFragment hotelListLevelFragment;
    private HotelListSelectFragment hotelListSelectFragment;
    private String score;
    private Boolean isSort;
    private Boolean isVisible = false;
    private List<HotelListSelectEntity.InfoBean.BrandBean> brandInfo;
    private List<HotelListSelectEntity.InfoBean.ServiceBean> serviceInfo;
    private List<HotelListSelectEntity.InfoBean.RoomBean> roomInfo;
    private TextView hotel_list_calendar_check_tv;
    private TextView hotel_list_calendar_out_tv;
    private boolean isLoad = false;
    private String price="";
    private String star="";


    @Override
    protected int getLayoutId() {
        return R.layout.activity_hotel_list;
    }

    @Override
    protected void afterOnCreate() {
        price = getIntent().getStringExtra("price");
        star = getIntent().getStringExtra("star");
        initView();
        if (price == null && star == null){
            loadMessage("", "", "", "");
        }else {
            loadMessage("price",price,"star",star);
        }
        hotelListSelectContent();
    }


    public void initView() {
        hotelListInfo = new ArrayList<>();
        hotelListTemp = new ArrayList<>();
        isSort = true;
        brandInfo = new ArrayList<>();
        serviceInfo = new ArrayList<>();
        roomInfo = new ArrayList<>();
        hotel_list_lv = (ListView) findViewById(R.id.hotel_list_lv);
        hotel_list_score_tv = (TextView) findViewById(R.id.hotel_list_score_tv);
        hotel_list_level_tv = (TextView) findViewById(R.id.hotel_list_level_tv);
        hotel_list_pai_tv = (TextView) findViewById(R.id.hotel_list_pai_tv);
        hotel_list_select_tv = (TextView) findViewById(R.id.hotel_list_select_tv);
        hotel_list_select_iv = (ImageView) findViewById(R.id.hotel_list_select_iv);
        hotel_list_score_iv = (ImageView) findViewById(R.id.hotel_list_score_iv);
        hotel_list_level_iv = (ImageView) findViewById(R.id.hotel_list_level_iv);
        hotel_list_pai_iv = (ImageView) findViewById(R.id.hotel_list_pai_iv);
        findViewById(R.id.hotel_list_select_ll).setOnClickListener(this);
        findViewById(R.id.hotel_list_score_ll).setOnClickListener(this);
        findViewById(R.id.hotel_list_level_ll).setOnClickListener(this);
        findViewById(R.id.hotel_list_pai_ll).setOnClickListener(this);
        findViewById(R.id.hotel_list_title_back).setOnClickListener(this);
        findViewById(R.id.hotel_list_calendar_ll).setOnClickListener(this);
        findViewById(R.id.hotel_list_search_ll).setOnClickListener(this);
        hotel_list_calendar_check_tv = (TextView) findViewById(R.id.hotel_list_calendar_check_tv);
        hotel_list_calendar_out_tv = (TextView) findViewById(R.id.hotel_list_calendar_out_tv);
        hotel_list_calendar_check_tv.setOnClickListener(this);
        hotel_list_calendar_out_tv.setOnClickListener(this);
        bundle = new Bundle();
        hotel_list_fl = findViewById(R.id.hotel_list_fl);
    }

    public void loadData() {
        if (hotelListAdapter == null) {
            hotelListAdapter = new HotelListAdapter(this, hotelListInfo);
            hotel_list_lv.setAdapter(hotelListAdapter);
            hotel_list_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    bundle.putString("hotel_id", hotelListInfo.get(position).getHotel_id());
                    bundle.putString("hotel_name", hotelListInfo.get(position).getHotel_name());
                    startAct(HotelDetailActivity.class, bundle);
//                    isVisibility();
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
        } else {
            hotelListAdapter.notifyDataSetChanged();
        }
    }

    public void loadMessage(String key, String value, String key1, String value2) {
        OkHttpUtils
                .post()
                .url(Api.HOTELLIST)
                .addParams(key, value)
                .addParams(key1, value2)
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
                                hotelListTemp = hotelListEntities.getInfo();
                                hotelListInfo.clear();
                                hotelListInfo.addAll(hotelListTemp);
                                hotelListTemp.clear();
                                loadData();
                            } else if (hotelListEntities.getStatus() == 339) {
                                ToastUtils.showShort(hotelListEntities.getMsg());
                                if (hotelListAdapter != null) {
                                    hotelListInfo.clear();
                                    hotelListAdapter.notifyDataSetChanged();
                                }


                            } else {
                                ToastUtils.showShort(hotelListEntities.getMsg());
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
        FragmentManager fm = getSupportFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.hotel_list_select_empty_tv:
                break;
            case R.id.hotel_list_select_result_tv:
                break;
            case R.id.hotel_list_select_ll:
                defaultState();
                hotel_list_select_tv.setTextColor(getResources().getColor(R.color.orange));
                hotel_list_select_iv.setImageResource(R.drawable.hotel_list_filtrate_selected_icon);
                if (isLoad) {
                    if (isVisible) {
                        hotel_list_fl.setVisibility(View.GONE);
                        isVisible = false;
                        notClick(hotel_list_fl, isVisible);
                    } else {
                        hotel_list_fl.setVisibility(View.VISIBLE);
                        isVisible = true;
                        notClick(hotel_list_fl, isVisible);
                    }
                    if (hotelListSelectFragment == null) {
                        hotelListSelectFragment = new HotelListSelectFragment();
                        transaction.add(R.id.hotel_list_fl, hotelListSelectFragment);
                    }
                } else {
                    ToastUtils.showShort("正在加载数据…");
                }
                hideFragment(transaction);
                transaction.show(hotelListSelectFragment);
                break;
            case R.id.hotel_list_score_ll:
                defaultState();
                hotel_list_score_tv.setTextColor(getResources().getColor(R.color.orange));
                hotel_list_score_iv.setImageResource(R.drawable.hotel_list_score_selected_icon);
                if (isSort) {
                    score = "score_desc";
                    scoreSort(score);
                    isSort = false;
                } else {
                    score = "score_asc";
                    scoreSort(score);
                    isSort = true;
                }
                break;
            case R.id.hotel_list_level_ll:
                defaultState();
                hotel_list_level_tv.setTextColor(getResources().getColor(R.color.orange));
                hotel_list_level_iv.setImageResource(R.drawable.hotel_list_price_selected_icon);
                if (isLoad) {
                    if (isVisible) {
                        hotel_list_fl.setVisibility(View.GONE);
                        isVisible = false;
                        notClick(hotel_list_fl, isVisible);
                    } else {
                        hotel_list_fl.setVisibility(View.VISIBLE);
                        isVisible = true;
                        notClick(hotel_list_fl, isVisible);
                    }
                    if (hotelListLevelFragment == null) {
                        hotelListLevelFragment = new HotelListLevelFragment();
                        transaction.add(R.id.hotel_list_fl, hotelListLevelFragment);
                    }
                }else {
                    ToastUtils.showShort("正在加载数据…");
                }
                hideFragment(transaction);
                transaction.show(hotelListLevelFragment);
                break;
            case R.id.hotel_list_pai_ll:
                break;
            case R.id.hotel_list_level_result_tv:
                loadMessage("", "" , "", "" );
                break;
            case R.id.hotel_list_level_empty_tv:
                break;
            case R.id.hotel_list_title_back:
                finish();
                break;
            case R.id.hotel_list_calendar_out_tv:
            case R.id.hotel_list_calendar_check_tv:
            case R.id.hotel_list_calendar_ll:
                startActForResult(SearchDateActivity.class, 101);
                break;
            case R.id.hotel_list_search_ll:
                startActForResult(SearchKeyWordActivity.class, 10);
                break;
            default:
                break;
        }
        transaction.commit();
    }


    public void scoreSort(String score) {
        OkHttpUtils
                .post()
                .url(Api.HOTELLIST)
                .addParams("str", score)
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
                            hotelListEntities = gson.fromJson(response.toString(), HotelListEntity.class);
                            if (hotelListEntities.getStatus() == 330) {
                                hotelListTemp = hotelListEntities.getInfo();
                                hotelListInfo.clear();
                                hotelListInfo.addAll(hotelListTemp);
                                hotelListTemp.clear();
                                loadData();
                            } else if (hotelListEntities.getStatus() == 339) {
                                ToastUtils.showShort(hotelListEntities.getMsg());
                                if (hotelListAdapter != null) {
                                    hotelListInfo.clear();
                                    hotelListAdapter.notifyDataSetChanged();
                                }


                            } else {
                                ToastUtils.showShort(hotelListEntities.getMsg());
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hotelListSelectFragment = new HotelListSelectFragment();
        transaction.add(R.id.hotel_list_fl, hotelListSelectFragment);
        hideFragment(transaction);
        transaction.commit();

    }

    // 实现接口，实现回调
    @Override
    public void level(String price, String star) {
        if (price != null || star != null) {
            loadMessage("price", price, "star", star);
            hotel_list_fl.setVisibility(View.GONE);
        }
    }


    @Override
    public void select(String str) {
        if (str != null) {
            loadMessage("keyword", str, "", "");
            hotel_list_fl.setVisibility(View.GONE);
        }
    }

    public void notClick(View view, final boolean isVisible) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return isVisible; // 阻止事件继续传递
            }
        });
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

                            LogUtils.e(new JSONObject(response.toString()));
                            Gson gson = new Gson();
                            HotelListSelectEntity hotelListSelectEntity = gson.fromJson(response.toString(), HotelListSelectEntity.class);
                            if (hotelListSelectEntity.getStatus() == 330) {
                                brandInfo = hotelListSelectEntity.getInfo().getBrand();
                                serviceInfo = hotelListSelectEntity.getInfo().getService();
                                roomInfo = hotelListSelectEntity.getInfo().getRoom();
                                isLoad = true;
                                setDefaultFragment();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void Room(String str) {

    }

    @Override
    public void Brand(String str) {

    }

    @Override
    public void Service(String str) {

    }

    public List<HotelListSelectEntity.InfoBean.BrandBean> getBrand() {
        return brandInfo;
    }

    public List<HotelListSelectEntity.InfoBean.RoomBean> getRoom() {
        return roomInfo;
    }

    public List<HotelListSelectEntity.InfoBean.ServiceBean> getService() {
        return serviceInfo;
    }

    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){
        if(hotelListLevelFragment != null){
            transaction.hide(hotelListLevelFragment);
        }
        if(hotelListSelectFragment != null){
            transaction.hide(hotelListSelectFragment);
        }
    }

    public void defaultState(){
        hotel_list_select_tv.setTextColor(getResources().getColor(R.color.home_location_word));
        hotel_list_score_tv.setTextColor(getResources().getColor(R.color.home_location_word));
        hotel_list_level_tv.setTextColor(getResources().getColor(R.color.home_location_word));
        hotel_list_select_iv.setImageResource(R.drawable.hotel_list_filtrate_unselected_icon);
        hotel_list_level_iv.setImageResource(R.drawable.hotel_list_price_unselected_icon);
        hotel_list_score_iv.setImageResource(R.drawable.hotel_list_score_unselected_icon);
    }
}
