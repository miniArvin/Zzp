package com.tryine.zzp.ui.activity.mine.wallet;


import android.view.View;
import android.widget.ListView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MinePublishCommentAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class MineCouponActivity extends BaseStatusMActivity implements View.OnClickListener {
    private ListView mine_coupon_lv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type = 11;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_coupon;
    }

    @Override
    protected void afterOnCreate() {
        initView();
    }

    public void initView() {
        mine_coupon_lv = (ListView) findViewById(R.id.mine_coupon_lv);
        minePublishCommentAdapter = new MinePublishCommentAdapter(null, this, type);
        mine_coupon_lv.setAdapter(minePublishCommentAdapter);
        findViewById(R.id.get_coupon_tv).setOnClickListener(this);
        findViewById(R.id.view_head_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_coupon_tv:
                startAct(GetCouponActivity.class);
                break;
            case R.id.view_head_back:
                break;
        }
    }

    public void loadMessage(String act){
        OkHttpUtils
                .post()
                .url(Api.COUPON)
                .addParams("act",act)
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
                            if (jsonObject.getInt("status")==300){

                            }else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
