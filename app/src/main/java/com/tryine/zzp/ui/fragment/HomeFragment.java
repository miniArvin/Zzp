package com.tryine.zzp.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.CityNameAdapter;
import com.tryine.zzp.adapter.HotelRecommendAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.entity.test.remote.HomeEntity;
import com.tryine.zzp.entity.test.remote.HotelBean;
import com.tryine.zzp.ui.activity.hotel.HotelListActivity;
import com.tryine.zzp.ui.activity.hotel.HotelSearchActivity;
import com.tryine.zzp.ui.activity.hotel.SearchDateActivity;
import com.tryine.zzp.ui.activity.hotel.SearchKeyWordActivity;
import com.tryine.zzp.ui.fragment.home.HomeCoastalCityFragment;
import com.tryine.zzp.ui.fragment.home.HomeGourmetCityFragment;
import com.tryine.zzp.ui.fragment.home.HomeHistoricalCultureFragment;
import com.tryine.zzp.ui.fragment.home.HomeWaterFragment;
import com.tryine.zzp.utils.GlideImageLoader;
import com.tryine.zzp.utils.SpaceItemDecoration;
import com.tryine.zzp.utils.UrlUtils;
import com.tryine.zzp.widget.BottomDialog.BottomDialog;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.widget.NoScrollViewPager;
import com.youth.banner.Banner;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;


public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout home_gonglue_hotel;
    private LinearLayout home_gonglue_mall;
    private LinearLayout home_gonglue_gonglue;
    private LinearLayout home_gonglue_question;
    private NoScrollViewPager home_city_name_vp;
    private RecyclerView home_recommend_hotel;
    private Banner home_banner;
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
    private List<HotelBean> hotelBeanList;
    private MagicIndicator magicIndicator;
    private List<Fragment> fragments;
    private String[] titles = new String[]{"沿海城市", "历史文化", "江南水乡", "美食城市"};
    private Integer[] imgs = new Integer[]{R.drawable.home_theme_coastal_unselect, R.drawable.home_theme_history_unselect, R.drawable.home_theme_water_unselect, R.drawable.home_theme_food_unselect};
    private Integer[] unImgs = new Integer[]{R.drawable.home_theme_coastal_selected, R.drawable.home_theme_history_selected, R.drawable.home_theme_water_selected, R.drawable.home_theme_food_selected};
    private List<String> titlesList = Arrays.asList(titles);
    private List<Integer> imgList = Arrays.asList(imgs);
    private List<Integer> unimgList = Arrays.asList(unImgs);
    private Bundle bundle ;


    public HomeFragment() {
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        loadMessage();
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void initView() {
        homeInfo = new ArrayList<>();
        hotelInfo = new ArrayList<>();
        waterInfo = new ArrayList<>();
        historicalCultureInfo = new ArrayList<>();
        gourmetCityInfo = new ArrayList<>();
        coastalCityInfo = new ArrayList<>();
        bannerInfo = new ArrayList<>();
        hotelBeanList = new ArrayList<>();
        fragments = new ArrayList<>();
        bundle = new Bundle();
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
        home_city_name_vp = (NoScrollViewPager) mView.findViewById(R.id.home_city_name_vp);
        home_recommend_hotel = (RecyclerView) mView.findViewById(R.id.home_recommend_hotel);
        home_banner = (Banner) mView.findViewById(R.id.home_banner);
        home_middle_ad_iv= (ImageView) mView.findViewById(R.id.home_middle_ad_iv);
        magicIndicator = (MagicIndicator) mView.findViewById(R.id.home_city_indicator);
    }

    public void loadData() {
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.home_city_item_div);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        home_recommend_hotel.setLayoutManager(linearLayoutManager);
        home_recommend_hotel.setNestedScrollingEnabled(false);
        hotelRecommendAdapter = new HotelRecommendAdapter(mContext, hotelInfo, mView);
        home_recommend_hotel.addItemDecoration(new SpaceItemDecoration(spacingInPixels,SpaceItemDecoration.HORIZONTAL_LIST));
        home_recommend_hotel.setAdapter(hotelRecommendAdapter);

        HomeCoastalCityFragment homeCoastalCityFragment = new HomeCoastalCityFragment();
        HomeHistoricalCultureFragment homeHistoricalCultureFragment = new HomeHistoricalCultureFragment();
        HomeWaterFragment homeWaterFragment= new HomeWaterFragment();
        HomeGourmetCityFragment homeGourmetCityFragment = new HomeGourmetCityFragment();

        bundle.putSerializable("coastal", (Serializable) coastalCityInfo);
        homeCoastalCityFragment.setArguments(bundle);
        bundle.putSerializable("historical", (Serializable) historicalCultureInfo);
        homeHistoricalCultureFragment.setArguments(bundle);
        bundle.putSerializable("water", (Serializable) waterInfo);
        homeWaterFragment.setArguments(bundle);
        bundle.putSerializable("gourmet", (Serializable) gourmetCityInfo);
        homeGourmetCityFragment.setArguments(bundle);

        fragments.add(homeCoastalCityFragment);
        fragments.add(homeHistoricalCultureFragment);
        fragments.add(homeWaterFragment);
        fragments.add(homeGourmetCityFragment);

        home_city_name_vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        initMagicIndicator();
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
                                home_banner.setImages(bannerUrls)
                                        .setImageLoader(new GlideImageLoader())
                                        .start();
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
                startAct(HotelListActivity.class);
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

    private void initMagicIndicator() {
        CommonNavigator commonNavigator = new CommonNavigator(mContext);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);

                // load custom layout
                View customLayout = LayoutInflater.from(context).inflate(R.layout.home_city_item, null);
                final ImageView titleImg = (ImageView) customLayout.findViewById(R.id.home_city_icon_iv);
                final TextView titleText = (TextView) customLayout.findViewById(R.id.home_city_content_tv);
                titleImg.setImageResource(imgList.get(index));
                titleText.setText(titlesList.get(index));
                commonPagerTitleView.setContentView(customLayout);

                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {

                    @Override
                    public void onSelected(int index, int totalCount) {
                        titleText.setTextColor(getResources().getColor(R.color.orange));
                    }

                    @Override
                    public void onDeselected(int index, int totalCount) {
                        titleText.setTextColor(getResources().getColor(R.color.home_location_word));
                    }

                    @Override
                    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
                        titleImg.setImageResource(imgList.get(index));
                    }

                    @Override
                    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
                        titleImg.setImageResource(unimgList.get(index));
                    }
                });

                commonPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        home_city_name_vp.setCurrentItem(index);
                    }
                });

                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, home_city_name_vp);
    }

}
