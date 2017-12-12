package com.tryine.zzp.ui.activity.hotel;


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

public class HotelEquipmentDetailActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;
    private TextView hotel_equipment_intro_tv;
    private TextView hotel_equipment_comprehensive_tv;
    private TextView hotel_equipment_remind_tv;
    private TextView hotel_equipment_room_tv;
    private TextView hotel_equipment_service_tv;
    private String hotel_id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hotel_equipment_detail;
    }

    @Override
    protected void afterOnCreate() {
        hotel_id=getIntent().getStringExtra("hotel_id");
        initView();
        loadMessage();
    }

    public void initView(){
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        hotel_equipment_intro_tv = (TextView) findViewById(R.id.hotel_equipment_intro_tv);
        hotel_equipment_comprehensive_tv = (TextView) findViewById(R.id.hotel_equipment_comprehensive_tv);
        hotel_equipment_remind_tv = (TextView) findViewById(R.id.hotel_equipment_remind_tv);
        hotel_equipment_room_tv = (TextView) findViewById(R.id.hotel_equipment_room_tv);
        hotel_equipment_service_tv = (TextView) findViewById(R.id.hotel_equipment_service_tv);
        view_head_title.setText("详情/设备");
    }

    public void loadData(){

    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.HOTELDETAILEQUIPMENT)
                .addParams("hotel_id",hotel_id)
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
                                JSONObject infoJo=new JSONObject(jsonObject.getString("info"));
                                hotel_equipment_intro_tv.setText(infoJo.getString("details"));
                                hotel_equipment_room_tv.setText(infoJo.getString("hotel_kfss"));
                                hotel_equipment_service_tv.setText(infoJo.getString("hotel_fwxm"));
                                hotel_equipment_comprehensive_tv.setText(infoJo.getString("hotel_zhss"));
                                hotel_equipment_remind_tv.setText(infoJo.getString(""));
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
            case R.id.view_head_back:
                finish();
                break;
        }
    }

}
