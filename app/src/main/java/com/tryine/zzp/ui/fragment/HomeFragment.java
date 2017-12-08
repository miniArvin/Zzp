package com.tryine.zzp.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.CityNameAdapter;
import com.tryine.zzp.adapter.HotelRecommendAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.entity.test.remote.HomeEntity;
import com.tryine.zzp.ui.activity.hotel.HotelListActivity;
import com.tryine.zzp.ui.activity.hotel.HotelSearchActivity;
import com.tryine.zzp.ui.activity.hotel.SearchDateActivity;
import com.tryine.zzp.ui.activity.hotel.SearchKeyWordActivity;
import com.tryine.zzp.utils.BannerHelper;
import com.tryine.zzp.utils.SpaceItemDecoration;
import com.tryine.zzp.utils.UrlUtils;
import com.tryine.zzp.widget.BottomDialog.BottomDialog;
import com.tryine.zzp.base.BaseFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout home_gonglue_hotel;
    private LinearLayout home_gonglue_mall;
    private LinearLayout home_gonglue_gonglue;
    private LinearLayout home_gonglue_question;
    private RecyclerView home_city_name;
    private HorizontalScrollView home_city_name_sh;
    private RecyclerView home_recommend_hotel;
    private ConvenientBanner home_banner;
    private CityNameAdapter cityNameAdapter;
    private HotelRecommendAdapter hotelRecommendAdapter;
    private List<HomeEntity.InfoBean> homeInfo;
    private List<HomeEntity.InfoBean.WaterBean> waterInfo;
    private List<HomeEntity.InfoBean.CoastalCityBean> coastalCityInfo;
    private List<HomeEntity.InfoBean.GourmetCityBean> gourmetCityInfo;
    private List<HomeEntity.InfoBean.HistoricalCultureBean> historicalCultureInfo;
    private List<HomeEntity.InfoBean.HotelBean> hotelInfo;
    private List<HomeEntity.InfoBean.BannerBean> bannerInfo;
    private LinearLayout home_location_ll;
    private LinearLayout home_hotel_date_ll;
    private TextView home_hotel_search_word_tv;
    private TextView home_hotel_level_tv;
    private TextView home_hotel_search_tv;
    private LinearLayout home_hotel_all_ll;
    private ImageView home_middle_ad_iv;
    private HomeEntity homeEntity;

    public HomeFragment() {
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadMessage();
    }

    public void initView() {
        homeInfo = new ArrayList<>();
        hotelInfo = new ArrayList<>();
        waterInfo = new ArrayList<>();
        historicalCultureInfo = new ArrayList<>();
        gourmetCityInfo = new ArrayList<>();
        coastalCityInfo = new ArrayList<>();
        bannerInfo = new ArrayList<>();
        home_gonglue_hotel = (LinearLayout) mView.findViewById(R.id.home_gonglue_hotel);
        home_gonglue_hotel.setOnClickListener(this);
        home_gonglue_mall = (LinearLayout) mView.findViewById(R.id.home_gonglue_mall);
        home_gonglue_mall.setOnClickListener(this);
        home_gonglue_gonglue = (LinearLayout) mView.findViewById(R.id.home_gonglue_gonglue);
        home_gonglue_gonglue.setOnClickListener(this);
        home_gonglue_question = (LinearLayout) mView.findViewById(R.id.home_gonglue_question);
        home_gonglue_question.setOnClickListener(this);
        home_location_ll = (LinearLayout) mView.findViewById(R.id.home_location_ll);
        home_location_ll.setOnClickListener(this);
        home_hotel_date_ll = (LinearLayout) mView.findViewById(R.id.home_hotel_date_ll);
        home_hotel_date_ll.setOnClickListener(this);
        home_hotel_search_word_tv = (TextView) mView.findViewById(R.id.home_hotel_search_word_tv);
        home_hotel_search_word_tv.setOnClickListener(this);
        home_hotel_level_tv = (TextView) mView.findViewById(R.id.home_hotel_level_tv);
        home_hotel_level_tv.setOnClickListener(this);
        home_hotel_search_tv = (TextView) mView.findViewById(R.id.home_hotel_search_tv);
        home_hotel_search_tv.setOnClickListener(this);
        home_hotel_all_ll = (LinearLayout) mView.findViewById(R.id.home_hotel_all_ll);
        home_hotel_all_ll.setOnClickListener(this);
        home_city_name = (RecyclerView) mView.findViewById(R.id.home_city_name);
        home_recommend_hotel = (RecyclerView) mView.findViewById(R.id.home_recommend_hotel);
        home_banner = (ConvenientBanner) mView.findViewById(R.id.home_banner);
        home_middle_ad_iv= (ImageView) mView.findViewById(R.id.home_middle_ad_iv);
    }

    public void loadData() {
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.home_city_item_div);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        home_city_name.setLayoutManager(linearLayoutManager);
        home_city_name.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(mView.getContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        home_recommend_hotel.setLayoutManager(linearLayoutManager2);
        home_recommend_hotel.setNestedScrollingEnabled(false);
        cityNameAdapter = new CityNameAdapter(mContext, waterInfo, mView);
        home_city_name.addItemDecoration(new SpaceItemDecoration(spacingInPixels,SpaceItemDecoration.HORIZONTAL_LIST));
        home_city_name.setAdapter(cityNameAdapter);
        hotelRecommendAdapter = new HotelRecommendAdapter(mContext, hotelInfo, mView);
        home_recommend_hotel.addItemDecoration(new SpaceItemDecoration(spacingInPixels,SpaceItemDecoration.HORIZONTAL_LIST));
        home_recommend_hotel.setAdapter(hotelRecommendAdapter);
    }

    public void loadMessage() {
        OkHttpUtils
                .post()
                .url(Api.HOME)
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
                            JSONObject jsonObject=new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                            Gson gson = new Gson();
                            homeEntity = gson.fromJson(response.toString(), HomeEntity.class);
                            LogUtils.e(homeEntity.getStatus());
                            if (homeEntity.getStatus() == 330) {
                                waterInfo = homeEntity.getInfo().getWater();
                                coastalCityInfo = homeEntity.getInfo().getCoastal_city();
                                gourmetCityInfo = homeEntity.getInfo().getGourmet_city();
                                historicalCultureInfo = homeEntity.getInfo().getHistorical_culture();
                                hotelInfo = homeEntity.getInfo().getHotel();
                                bannerInfo = homeEntity.getInfo().getBanner();
                                List<String> bannerUrls = new ArrayList<>();
                                if (bannerInfo!= null) {
                                    for (int i = 0; i < bannerInfo.size(); i++) {
                                        bannerUrls.add(UrlUtils.getUrl(bannerInfo.get(i).getPhoto()));
                                    }
                                }
                                BannerHelper.getInstance().config(home_banner,bannerUrls);
                                Glide.with(mContext).load(UrlUtils.getUrl(homeEntity.getInfo().getImg().getPhoto())).asBitmap().into(home_middle_ad_iv);
                                loadData();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_gonglue_hotel:
                break;
            case R.id.home_gonglue_mall:
                break;
            case R.id.home_gonglue_gonglue:
                break;
            case R.id.home_gonglue_question:
                break;
            case R.id.home_hotel_all_ll:
                startAct(HotelListActivity.class);
                break;
            case R.id.home_hotel_date_ll:
                startAct(SearchDateActivity.class);
                break;
            case R.id.home_hotel_level_tv:
                BottomDialog.create(getFragmentManager())
                        .setViewListener(new BottomDialog.ViewListener() {
                            @Override
                            public void bindView(View v) {

                            }
                        })
                        .setGravity(1)
                        .setCancelOutside(false)
                        .setLayoutRes(R.layout.hotel_level_dialog)
                        .setDimAmount(0.4f)
                        .show();
                break;
            case R.id.home_hotel_search_tv:
                startAct(SearchKeyWordActivity.class);
                break;
            case R.id.home_hotel_search_word_tv:
                startAct(HotelSearchActivity.class);
                break;
            case R.id.home_location_ll:
                break;
            default:
                break;
        }
    }


}
