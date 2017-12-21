package com.tryine.zzp.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.FoundFoodViewAdapter;
import com.tryine.zzp.adapter.FoundHotelRecommendAdapter;
import com.tryine.zzp.adapter.FoundLocationNameAdapter;
import com.tryine.zzp.adapter.FoundNewsAdapter;
import com.tryine.zzp.adapter.FoundQuestionsAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.entity.test.remote.FoundEntity;
import com.tryine.zzp.ui.activity.found.FoundDetailActivity;
import com.tryine.zzp.ui.activity.hotel.HotelListActivity;
import com.tryine.zzp.utils.GlideImageLoader;
import com.tryine.zzp.utils.UrlUtils;
import com.tryine.zzp.widget.FlowLayout.SpaceItemDecoration;
import com.tryine.zzp.widget.NoScrollListView;
import com.tryine.zzp.base.BaseFragment;
import com.youth.banner.Banner;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class FoundFragment extends BaseFragment implements View.OnClickListener {

    private RecyclerView found_location_name_rv;
    private List<FoundEntity.InfoBean.ImgBean> imgBeen;
    private List<FoundEntity.InfoBean.CityBean> cityBeen;
    private List<FoundEntity.InfoBean.AnswerBean> answerBeen;
    private List<FoundEntity.InfoBean.ArticleBean> articleBeen;
    private List<FoundEntity.InfoBean.HotelBean> hotelBeen;
    private List<FoundEntity.InfoBean.PostBean> postBeen;
    private FoundLocationNameAdapter foundLocationNameAdapter;
    private RecyclerView found_food_view_rv;
    private FoundFoodViewAdapter foundFoodViewAdapter;
    private NoScrollListView found_news_lv;
    private FoundNewsAdapter foundNewsAdapter;
    private LinearLayout found_food_view_more_ll;
    private LinearLayout found_question_more_ll;
    private LinearLayout found_news_more_ll;
    private LinearLayout found_hotel_more_ll;
    private NoScrollListView found_question_lv;
    private FoundQuestionsAdapter foundQuestionsAdapter;
    private Banner found_banner;
    private RecyclerView found_recommend_hotel_rv;
    private FoundHotelRecommendAdapter foundHotelRecommendAdapter;
    private Bundle bundle;

    public FoundFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_found;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        initView();
        loadMessage();
        loadData();
    }

    public void initView(){
        imgBeen=new ArrayList<>();
        cityBeen = new ArrayList<>();
        answerBeen = new ArrayList<>();
        articleBeen = new ArrayList<>();
        hotelBeen = new ArrayList<>();
        postBeen = new ArrayList<>();
        bundle = new Bundle();
        found_location_name_rv= (RecyclerView) mView.findViewById(R.id.found_location_name_rv);
        found_food_view_rv= (RecyclerView) mView.findViewById(R.id.found_food_view_rv);
        found_news_lv= (NoScrollListView) mView.findViewById(R.id.found_news_lv);
        found_question_lv= (NoScrollListView) mView.findViewById(R.id.found_question_lv);
        found_food_view_more_ll= (LinearLayout) mView.findViewById(R.id.found_food_view_more_ll);
        found_question_more_ll= (LinearLayout) mView.findViewById(R.id.found_question_more_ll);
        found_news_more_ll= (LinearLayout) mView.findViewById(R.id.found_news_more_ll);
        found_hotel_more_ll= (LinearLayout) mView.findViewById(R.id.found_hotel_more_ll);
        found_recommend_hotel_rv = (RecyclerView) mView.findViewById(R.id.found_recommend_hotel_rv);
        found_food_view_more_ll.setOnClickListener(this);
        found_news_more_ll.setOnClickListener(this);
        found_question_more_ll.setOnClickListener(this);
        found_hotel_more_ll.setOnClickListener(this);
        found_banner = (Banner) mView.findViewById(R.id.found_banner);
    }

    public void loadData(){

    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.FOUND)
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
                                FoundEntity foundEntity = gson.fromJson(response.toString(),FoundEntity.class);
                                cityBeen = foundEntity.getInfo().getCity();
                                answerBeen=foundEntity.getInfo().getAnswer();
                                articleBeen=foundEntity.getInfo().getArticle();
                                hotelBeen=foundEntity.getInfo().getHotel();
                                imgBeen=foundEntity.getInfo().getImg();
                                postBeen=foundEntity.getInfo().getPost();

                                //轮播图
                                List<String> bannerUrls = new ArrayList<>();
                                if (imgBeen!= null) {
                                    for (int i = 0; i < imgBeen.size(); i++) {
                                        bannerUrls.add(UrlUtils.getUrl(imgBeen.get(i).getPhoto()));
                                    }
                                }
                                found_banner.setImages(bannerUrls)
                                        .setImageLoader(new GlideImageLoader())
                                        .start();

                                //目的地
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
                                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                                found_location_name_rv.setLayoutManager(linearLayoutManager);
                                found_location_name_rv.setNestedScrollingEnabled(false);
                                foundLocationNameAdapter=new FoundLocationNameAdapter(mView,mContext,cityBeen);
                                found_location_name_rv.setAdapter(foundLocationNameAdapter);

                                //美食美景
                                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(mView.getContext());
                                linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
                                found_food_view_rv.setLayoutManager(linearLayoutManager1);
                                found_food_view_rv.setNestedScrollingEnabled(false);
                                found_food_view_rv.addItemDecoration(new SpaceItemDecoration(dp2px(5)));
                                foundFoodViewAdapter=new FoundFoodViewAdapter(mView,mContext,postBeen);
                                found_food_view_rv.setAdapter(foundFoodViewAdapter);

                                //新闻资讯
                                foundNewsAdapter =new FoundNewsAdapter(mView,mContext,articleBeen);
                                found_news_lv.setAdapter(foundNewsAdapter);

                                //趣味问答
                                foundQuestionsAdapter=new FoundQuestionsAdapter(mView,mContext,answerBeen);
                                found_question_lv.setAdapter(foundQuestionsAdapter);

                                //推荐酒店
                                int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.home_city_item_div);
                                LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(mView.getContext());
                                linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
                                found_recommend_hotel_rv.setLayoutManager(linearLayoutManager2);
                                found_recommend_hotel_rv.setNestedScrollingEnabled(false);
                                foundHotelRecommendAdapter = new FoundHotelRecommendAdapter(mContext, hotelBeen, mView);
                                found_recommend_hotel_rv.addItemDecoration(new com.tryine.zzp.utils.SpaceItemDecoration(spacingInPixels, com.tryine.zzp.utils.SpaceItemDecoration.HORIZONTAL_LIST));
                                found_recommend_hotel_rv.setAdapter(foundHotelRecommendAdapter);
                            }else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.found_food_view_more_ll:
                bundle.putInt("found",0);
                startAct(FoundDetailActivity.class,bundle);
                break;
            case R.id.found_news_more_ll:
                bundle.putInt("found",2);
                startAct(FoundDetailActivity.class,bundle);
                break;
            case R.id.found_question_more_ll:
                bundle.putInt("found",1);
                startAct(FoundDetailActivity.class,bundle);
                break;
            case R.id.found_hotel_more_ll:
                startAct(HotelListActivity.class);
                break;
        }
    }

    public int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
