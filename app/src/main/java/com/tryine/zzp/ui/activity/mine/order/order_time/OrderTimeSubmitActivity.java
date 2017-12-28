package com.tryine.zzp.ui.activity.mine.order.order_time;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class OrderTimeSubmitActivity extends BaseStatusMActivity implements View.OnClickListener {
    private String order_id;
    private String realname;
    private String room_name;
    private String stime;
    private String ltime;
    private String num;
    private String night_num;
    private String coupon;
    private String mobile;
    private String room_price;
    private String room_type;
    private String hotel_name;
    private String requirement;
    private TextView hotel_order_submit_title_tv;
    private TextView hotel_order_submit_type_tv;
    private TextView hotel_order_submit_check_tv;
    private TextView hotel_order_submit_out_tv;
    private TextView hotel_order_submit_room_tv;
    private TextView hotel_order_submit_price_tv;
    private TextView hotel_order_submit_linkman_tv;
    private TextView hotel_order_submit_phone_tv;
    private TextView view_head_title;
    private TextView hotel_order_submit_equipment_tv;
    private TextView hotel_order_submit_price_detail1_tv;
    private TextView hotel_order_submit_price_detail2_tv;
    private TextView hotel_order_submit_day_tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_time_submit;
    }

    @Override
    protected void afterOnCreate() {
        order_id = getIntent().getStringExtra("order_id");
        loadMessage();
        initView();
    }

    public void loadData() {
        hotel_order_submit_title_tv.setText(hotel_name);
        hotel_order_submit_type_tv.setText(room_type);
        hotel_order_submit_check_tv.setText(stime);
        hotel_order_submit_out_tv.setText(ltime);
        hotel_order_submit_room_tv.setText(num);
        hotel_order_submit_price_tv.setText(room_price);
        hotel_order_submit_linkman_tv.setText(realname);
        hotel_order_submit_phone_tv.setText(mobile);
        hotel_order_submit_equipment_tv.setText(requirement);
        hotel_order_submit_price_detail1_tv.setText("商品总价：+￥"+room_price);
        hotel_order_submit_price_detail2_tv.setText("优惠券减扣：-￥"+coupon);
        hotel_order_submit_day_tv.setText(night_num);
    }

    public void initView() {
        hotel_order_submit_title_tv = (TextView) findViewById(R.id.hotel_order_submit_title_tv);
        hotel_order_submit_type_tv = (TextView) findViewById(R.id.hotel_order_submit_type_tv);
        hotel_order_submit_check_tv = (TextView) findViewById(R.id.hotel_order_submit_check_tv);
        hotel_order_submit_out_tv = (TextView) findViewById(R.id.hotel_order_submit_out_tv);
        hotel_order_submit_room_tv = (TextView) findViewById(R.id.hotel_order_submit_room_tv);
        hotel_order_submit_price_tv = (TextView) findViewById(R.id.hotel_order_submit_price_tv);
        hotel_order_submit_linkman_tv = (TextView) findViewById(R.id.hotel_order_submit_linkman_tv);
        hotel_order_submit_phone_tv = (TextView) findViewById(R.id.hotel_order_submit_phone_tv);
        hotel_order_submit_equipment_tv = (TextView) findViewById(R.id.hotel_order_submit_equipment_tv);
        hotel_order_submit_price_detail1_tv = (TextView) findViewById(R.id.hotel_order_submit_price_detail1_tv);
        hotel_order_submit_price_detail2_tv = (TextView) findViewById(R.id.hotel_order_submit_price_detail2_tv);
        hotel_order_submit_day_tv = (TextView) findViewById(R.id.hotel_order_submit_day_tv);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("提交成功");
        findViewById(R.id.hotel_order_submit_pay_ll).setOnClickListener(this);
        findViewById(R.id.view_head_back).setOnClickListener(this);

    }

    public void loadMessage() {
        OkHttpUtils
                .post()
                .url(Api.HOTELSUBMITSUCCESE)
                .addParams("order_id", order_id)
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
                            if (jsonObject.getInt("status") == 330) {
                                Bundle bundle = new Bundle();
                                JSONObject info = new JSONObject(jsonObject.getString("info"));
                                hotel_name = info.getString("hotel_name");
                                room_name = info.getString("room_name");
                                stime = info.getString("stime");
                                ltime = info.getString("ltime");
                                num = info.getString("num");
                                night_num = info.getString("night_num");
                                coupon = info.getString("coupon");
                                realname = info.getString("name");
                                mobile = info.getString("mobile");
                                requirement = info.getString("note");
                                room_price = info.getString("amount");
                                loadData();
                            } else {
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
        switch (v.getId()) {
            case R.id.hotel_order_submit_pay_ll:
                break;
            case R.id.hotel_order_submit_zfb_iv:
                break;
            case R.id.hotel_order_submit_wx_iv:
                break;
            case R.id.view_head_back:
                finish();
                break;
        }
    }

}
