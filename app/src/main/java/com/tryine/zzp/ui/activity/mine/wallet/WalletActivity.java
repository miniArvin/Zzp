package com.tryine.zzp.ui.activity.mine.wallet;


import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MineWalletAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.widget.NoScrollListView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class WalletActivity extends BaseStatusMActivity implements View.OnClickListener {
    private NoScrollListView mine_wallet_lv;
    private MineWalletAdapter mineWalletAdapter;
    private TextView view_head_title;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_wallet;
    }

    @Override
    protected void afterOnCreate() {
        loadMessage();
        initView();
    }

    public void initView(){
        mine_wallet_lv= (NoScrollListView) findViewById(R.id.mine_wallet_lv);
        mineWalletAdapter=new MineWalletAdapter(this);
        mine_wallet_lv.setAdapter(mineWalletAdapter);
        findViewById(R.id.mine_wallet_all_coupon_tv).setOnClickListener(this);
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("领券中心");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_wallet_all_coupon_tv:
                startAct(MineCouponActivity.class);
                break;
            case R.id.view_head_back:
                finish();
                break;
        }
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.WALLET)
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
