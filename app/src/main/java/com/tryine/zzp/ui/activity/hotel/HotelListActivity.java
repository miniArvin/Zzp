package com.tryine.zzp.ui.activity.hotel;


import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelListAdapter;
import com.tryine.zzp.adapter.HotelListLevelDialogAdapter;
import com.tryine.zzp.adapter.HotelListSelectContentDialogAdapter;
import com.tryine.zzp.adapter.HotelListSelectDialogAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.entity.test.remote.HotelListEntity;
import com.tryine.zzp.entity.test.remote.HotelListSelectEntity;
import com.tryine.zzp.widget.NoScrollGirdView;
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
    private List<HotelListEntity.InfoBean> hotelListTemp;
    private Bundle bundle;
    private int fav;
    private ListView hotel_list_select_lv;
    private ListView hotel_list_select_content_lv;
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
    private List<String> levelPriceList;
    private List<String> levelStarList;
    private HotelListSelectDialogAdapter hotelListSelectDialogAdapter;
    private HotelListSelectContentDialogAdapter hotelListSelectContentDialogAdapter;
    private List<HotelListSelectEntity.InfoBean.BrandBean> brandInfo;
    private List<HotelListSelectEntity.InfoBean.ServiceBean> serviceInfo;
    private List<HotelListSelectEntity.InfoBean.RoomBean> roomInfo;
    private String score;
    private Boolean isSort;
    private int content = 0;
    private NoScrollGirdView hotel_list_level_price_gv;
    private NoScrollGirdView hotel_list_level_star_gv;
    private HotelListLevelDialogAdapter hotelListLevelPrice;
    private HotelListLevelDialogAdapter hotelListLevelStar;
    private String starPos;
    private String pricePos;
    private String starKey;
    private String priceKey;
    private TextView hotel_list_calendar_check_tv;
    private TextView hotel_list_calendar_out_tv;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_hotel_list;
    }

    @Override
    protected void afterOnCreate() {
        initView();
        loadMessage("", "", "", "");
        hotelListSelectContent();
    }

    public void locationData() {
        selectList = new ArrayList<>();
        selectList.add("住宿类型");
        selectList.add("品牌");
        selectList.add("酒店设备");
        levelPriceList = new ArrayList<>();
        levelPriceList.add("不限");
        levelPriceList.add("￥100以下");
        levelPriceList.add("￥101-￥200");
        levelPriceList.add("￥201-￥300");
        levelPriceList.add("￥301-￥450");
        levelPriceList.add("￥451-￥600");
        levelPriceList.add("￥601-￥1000");
        levelPriceList.add("￥1001-￥2000");
        levelPriceList.add("￥2001-￥3000");
        levelPriceList.add("￥3000以上");
        levelStarList = new ArrayList<>();
        levelStarList.add("不限");
        levelStarList.add("一星级");
        levelStarList.add("二星级");
        levelStarList.add("三星级");
        levelStarList.add("四星级");
        levelStarList.add("五星级");
    }

    public void initView() {
        locationData();
        hotelListInfo = new ArrayList<>();
        hotelListTemp = new ArrayList<>();
        brandInfo = new ArrayList<>();
        serviceInfo = new ArrayList<>();
        roomInfo = new ArrayList<>();
        isSort = true;
        hotel_list_lv = (ListView) findViewById(R.id.hotel_list_lv);
        hotel_list_select_lv = (ListView) findViewById(R.id.hotel_list_select_lv);
        hotel_list_select_content_lv = (ListView) findViewById(R.id.hotel_list_select_content_lv);
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
        findViewById(R.id.hotel_list_level_empty_tv).setOnClickListener(this);
        findViewById(R.id.hotel_list_select_empty_tv).setOnClickListener(this);
        findViewById(R.id.hotel_list_level_result_tv).setOnClickListener(this);
        findViewById(R.id.hotel_level_dialog_title_tv).setVisibility(View.GONE);
        findViewById(R.id.hotel_list_title_back).setOnClickListener(this);
        findViewById(R.id.hotel_list_calendar_ll).setOnClickListener(this);
        findViewById(R.id.hotel_list_search_ll).setOnClickListener(this);
        hotel_list_calendar_check_tv = (TextView) findViewById(R.id.hotel_list_calendar_check_tv);
        hotel_list_calendar_out_tv = (TextView) findViewById(R.id.hotel_list_calendar_out_tv);
        hotel_list_calendar_check_tv.setOnClickListener(this);
        hotel_list_calendar_out_tv.setOnClickListener(this);
        hotel_list_level_dialog = (LinearLayout) findViewById(R.id.hotel_list_level_dialog);
        hotel_list_select_dialog = (LinearLayout) findViewById(R.id.hotel_list_select_dialog);
        hotelListSelectDialogAdapter = new HotelListSelectDialogAdapter(this, selectList);
        hotel_list_select_lv.setAdapter(hotelListSelectDialogAdapter);
        hotelListSelectDialogAdapter.setDefSelect(0);
        hotel_list_select_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    content = 0;
                    hotelListSelectDialogAdapter.setDefSelect(position);
                    hotelListSelectContentData(roomInfo, null, null);
                } else if (position == 1) {
                    content = 1;
                    hotelListSelectDialogAdapter.setDefSelect(position);
                    hotelListSelectContentData(null, brandInfo, null);
                } else if (position == 2) {
                    content = 2;
                    hotelListSelectDialogAdapter.setDefSelect(position);
                    hotelListSelectContentData(null, null, serviceInfo);
                }
            }
        });
        hotel_list_level_price_gv = (NoScrollGirdView) findViewById(R.id.hotel_list_level_price_gv);
        hotel_list_level_star_gv = (NoScrollGirdView) findViewById(R.id.hotel_list_level_star_gv);
        hotelListLevelPrice = new HotelListLevelDialogAdapter(this, levelPriceList, 1);
        hotel_list_level_price_gv.setAdapter(hotelListLevelPrice);
        hotelListLevelPrice.setDefSelect(0);
        hotelListLevelStar = new HotelListLevelDialogAdapter(this, levelStarList, 2);
        hotel_list_level_star_gv.setAdapter(hotelListLevelStar);
        hotelListLevelStar.setDefSelect(0);
        bundle = new Bundle();

        hotel_list_level_star_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    starPos="";
                }else if (position==1){
                    starPos="5";
                }else if (position==2){
                    starPos="4";
                }else if (position==3){
                    starPos="3";
                }else if (position==4){
                    starPos="2";
                }else if (position==5){
                    starPos="1";
                }
                starKey = "star";
                hotelListLevelStar.setDefSelect(position);
            }
        });
        hotel_list_level_price_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                hotelListLevelPrice.setDefSelect(position);
                priceKey = "price";
                pricePos = (position + 1) + "";
            }
        });

    }

    public void loadData() {
        if (hotelListAdapter == null) {
            hotelListAdapter = new HotelListAdapter(this, hotelListInfo);
            hotel_list_lv.setAdapter(hotelListAdapter);
            hotel_list_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    bundle.putString("hotel_id", hotelListInfo.get(position).getHotel_id());
                    bundle.putString("hotel_name",hotelListInfo.get(position).getHotel_name());
                    startAct(HotelDetailActivity.class, bundle);
                    isVisibility();
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
                    isSort = false;
                } else {
                    score = "score_asc";
                    scoreSort(score);
                    isSort = true;
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
            case R.id.hotel_list_level_result_tv:
                loadMessage(starKey, starPos + "", priceKey, pricePos + "");
                isVisibility();
                break;
            case R.id.hotel_list_level_empty_tv:
                hotelListLevelStar.setDefSelect(0);
                hotelListLevelPrice.setDefSelect(0);
                starPos = "";
                pricePos = "";
                starKey = "";
                priceKey = "";
                break;
            case R.id.hotel_list_title_back:
                finish();
                break;
            case R.id.hotel_list_calendar_out_tv:
            case R.id.hotel_list_calendar_check_tv:
            case R.id.hotel_list_calendar_ll:
                startActForResult(SearchDateActivity.class,101);
                break;
            case R.id.hotel_list_search_ll:
                startActForResult(SearchKeyWordActivity.class,10);
                break;
            default:
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

                            LogUtils.e(new JSONObject(response.toString()));
                            Gson gson = new Gson();
                            HotelListSelectEntity hotelListSelectEntity = gson.fromJson(response.toString(), HotelListSelectEntity.class);
                            if (hotelListSelectEntity.getStatus() == 330) {
                                brandInfo = hotelListSelectEntity.getInfo().getBrand();
                                serviceInfo = hotelListSelectEntity.getInfo().getService();
                                roomInfo = hotelListSelectEntity.getInfo().getRoom();
                                hotelListSelectContentData(roomInfo, null, null);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
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

    public void hotelListSelectContentData(List<HotelListSelectEntity.InfoBean.RoomBean> roomBeen,
                                           List<HotelListSelectEntity.InfoBean.BrandBean> brandBeen,
                                           List<HotelListSelectEntity.InfoBean.ServiceBean> serviceBeen) {
        hotelListSelectContentDialogAdapter=null;
        hotelListSelectContentDialogAdapter = new HotelListSelectContentDialogAdapter(this, roomBeen, serviceBeen, brandBeen);
        hotel_list_select_content_lv.setAdapter(hotelListSelectContentDialogAdapter);
        hotel_list_select_content_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (content == 0) {

                } else if (content == 1) {

                } else if (content == 2) {

                }
            }
        });
    }


}
