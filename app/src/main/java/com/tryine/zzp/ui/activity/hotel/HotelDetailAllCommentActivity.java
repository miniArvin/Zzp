package com.tryine.zzp.ui.activity.hotel;


import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelCommentAdapter;
import com.tryine.zzp.adapter.HotelCommentTagAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.entity.test.remote.HotelAllCommentEntity;
import com.tryine.zzp.widget.FlowLayout.FlowLayoutManager;
import com.tryine.zzp.widget.FlowLayout.SpaceItemDecoration;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class HotelDetailAllCommentActivity extends BaseStatusMActivity implements View.OnClickListener {
    private String hotel_id;
    private HotelAllCommentEntity hotelAllCommentEntities;
    private View hotel_detail_comment_hot_v;
    private View hotel_detail_comment_new_v;
    private View hotel_detail_comment_img_v;
    private TextView hotel_detail_comment_hot_tv;
    private TextView hotel_detail_comment_new_tv;
    private TextView hotel_detail_comment_img_tv;
    private LinearLayout hotel_all_comment_ll;
    private RecyclerView hotel_all_comment_tag_rv;
    private RecyclerView hotel_all_comment_rv;
    private List<HotelAllCommentEntity.InfoBean.ApplyBean> applyBeen;
    private List<HotelAllCommentEntity.InfoBean.ApplyBean> applyTemp;
    private List<HotelAllCommentEntity.InfoBean.TagBean> tagBeen;
    private List<HotelAllCommentEntity.InfoBean.TagBean> tagTemp;
    private HotelCommentTagAdapter hotelCommentTagAdapter;
    private HotelCommentAdapter hotelCommentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hotel_detail_all_comment;
    }

    @Override
    protected void afterOnCreate() {
        hotel_id = getIntent().getStringExtra("hotel_id");
        initView();
        loadMessage("","");
    }

    public void initView() {
        hotel_detail_comment_hot_v = findViewById(R.id.hotel_detail_comment_hot_v);
        hotel_detail_comment_new_v = findViewById(R.id.hotel_detail_comment_new_v);
        hotel_detail_comment_img_v = findViewById(R.id.hotel_detail_comment_img_v);
        hotel_detail_comment_hot_tv = (TextView) findViewById(R.id.hotel_detail_comment_hot_tv);
        hotel_detail_comment_new_tv = (TextView) findViewById(R.id.hotel_detail_comment_new_tv);
        hotel_detail_comment_img_tv = (TextView) findViewById(R.id.hotel_detail_comment_img_tv);
        findViewById(R.id.hotel_detail_comment_hot_ll).setOnClickListener(this);
        findViewById(R.id.hotel_detail_comment_new_ll).setOnClickListener(this);
        findViewById(R.id.hotel_detail_comment_img_ll).setOnClickListener(this);
        hotel_all_comment_ll = (LinearLayout) findViewById(R.id.hotel_all_comment_ll);
        applyBeen=new ArrayList<>();
        tagBeen = new ArrayList<>();
        hotel_all_comment_tag_rv = (RecyclerView) findViewById(R.id.hotel_all_comment_tag_rv);
        hotel_all_comment_rv = (RecyclerView) findViewById(R.id.hotel_all_comment_rv);
    }

    public void loadData(){
        //评论
        if (hotelCommentAdapter==null){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            hotel_all_comment_rv.setLayoutManager(linearLayoutManager);
            hotel_all_comment_rv.addItemDecoration(new com.tryine.zzp.utils.SpaceItemDecoration(dp2px(10), com.tryine.zzp.utils.SpaceItemDecoration.VERTICAL_LIST));
            hotelCommentAdapter = new HotelCommentAdapter(mContext,applyBeen);
            hotel_all_comment_rv.setAdapter(hotelCommentAdapter);
        }else {
            hotelCommentAdapter.notifyDataSetChanged();
        }


        //tag
        if (hotelCommentTagAdapter==null){
            FlowLayoutManager flowLayoutManagerComment = new FlowLayoutManager();
            hotel_all_comment_tag_rv.addItemDecoration(new SpaceItemDecoration(dp2px(5)));
            hotel_all_comment_tag_rv.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_CANCEL, 0, 0, 0));
            hotel_all_comment_tag_rv.setLayoutManager(flowLayoutManagerComment);
            hotel_all_comment_tag_rv.setNestedScrollingEnabled(false);
            hotelCommentTagAdapter = new HotelCommentTagAdapter(mContext,tagBeen);
            hotel_all_comment_tag_rv.setAdapter(hotelCommentTagAdapter);
        }else {
            hotelCommentTagAdapter.notifyDataSetChanged();
        }

    }

    public void loadMessage(String typeKey, String typeValue) {
        OkHttpUtils
                .post()
                .url(Api.HOTELDETAILCOMMENT)
                .addParams("hotel_id", hotel_id)
                .addParams(typeKey, typeValue)
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
                            hotelAllCommentEntities = gson.fromJson(response.toString(), HotelAllCommentEntity.class);
                            if (hotelAllCommentEntities.getStatus() == 330) {
                                applyTemp = hotelAllCommentEntities.getInfo().getApply();
                                applyBeen.clear();
                                applyBeen.addAll(applyTemp);
                                applyTemp.clear();
                                tagTemp = hotelAllCommentEntities.getInfo().getTag();
                                tagBeen.clear();
                                tagBeen.addAll(tagTemp);
                                tagTemp.clear();
                                loadData();
                            }else if (hotelAllCommentEntities.getStatus() == 339){
                                ToastUtils.showShort(hotelAllCommentEntities.getMsg());
                                if (hotelCommentTagAdapter!=null){
                                    tagBeen.clear();
                                    hotelCommentTagAdapter.notifyDataSetChanged();
                                }
                                if (hotelCommentAdapter!=null){
                                    applyBeen.clear();
                                    hotelCommentAdapter.notifyDataSetChanged();
                                }
                            }else {
                                ToastUtils.showShort(hotelAllCommentEntities.getMsg());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void selectTitle(int position) {
        if (position == 1) {
            if (hotel_detail_comment_hot_v.getVisibility() == View.VISIBLE)
                hotel_detail_comment_hot_v.setVisibility(View.GONE);
            if (hotel_detail_comment_img_v.getVisibility() == View.VISIBLE)
                hotel_detail_comment_img_v.setVisibility(View.GONE);
            if (hotel_detail_comment_new_v.getVisibility()==View.GONE)
                hotel_detail_comment_new_v.setVisibility(View.VISIBLE);
            if (hotel_all_comment_ll.getVisibility()==View.GONE)
                hotel_all_comment_ll.setVisibility(View.VISIBLE);
            hotel_detail_comment_hot_tv.setTextColor(getResources().getColor(R.color.black));
            hotel_detail_comment_img_tv.setTextColor(getResources().getColor(R.color.black));
            hotel_detail_comment_new_tv.setTextColor(getResources().getColor(R.color.home_location_btn));
        }

        if (position == 2) {
            if (hotel_detail_comment_new_v.getVisibility() == View.VISIBLE)
                hotel_detail_comment_new_v.setVisibility(View.GONE);
            if (hotel_detail_comment_img_v.getVisibility() == View.VISIBLE)
                hotel_detail_comment_img_v.setVisibility(View.GONE);
            if (hotel_detail_comment_hot_v.getVisibility()==View.GONE)
                hotel_detail_comment_hot_v.setVisibility(View.VISIBLE);
            if (hotel_all_comment_ll.getVisibility()==View.VISIBLE)
                hotel_all_comment_ll.setVisibility(View.GONE);
            hotel_detail_comment_new_tv.setTextColor(getResources().getColor(R.color.black));
            hotel_detail_comment_img_tv.setTextColor(getResources().getColor(R.color.black));
            hotel_detail_comment_hot_tv.setTextColor(getResources().getColor(R.color.home_location_btn));
        }

        if (position == 3) {
            if (hotel_detail_comment_hot_v.getVisibility() == View.VISIBLE)
                hotel_detail_comment_hot_v.setVisibility(View.GONE);
            if (hotel_detail_comment_new_v.getVisibility() == View.VISIBLE)
                hotel_detail_comment_new_v.setVisibility(View.GONE);
            if (hotel_detail_comment_img_v.getVisibility()==View.GONE)
                hotel_detail_comment_img_v.setVisibility(View.VISIBLE);
            if (hotel_all_comment_ll.getVisibility()==View.VISIBLE)
                hotel_all_comment_ll.setVisibility(View.GONE);
            hotel_detail_comment_hot_tv.setTextColor(getResources().getColor(R.color.black));
            hotel_detail_comment_new_tv.setTextColor(getResources().getColor(R.color.black));
            hotel_detail_comment_img_tv.setTextColor(getResources().getColor(R.color.home_location_btn));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hotel_detail_comment_hot_ll:
                selectTitle(2);
                loadMessage("act","hot");
                break;
            case R.id.hotel_detail_comment_new_ll:
                selectTitle(1);
                loadMessage("","");
                break;
            case R.id.hotel_detail_comment_img_ll:
                selectTitle(3);
                loadMessage("act","img");
                break;
        }
    }
    public int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
