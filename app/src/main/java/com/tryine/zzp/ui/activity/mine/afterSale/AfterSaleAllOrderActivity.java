package com.tryine.zzp.ui.activity.mine.afterSale;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MineAfterSaleAllOrderAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class AfterSaleAllOrderActivity extends BaseStatusMActivity implements View.OnClickListener {
    private ListView mine_after_sale_all_lv;
    private MineAfterSaleAllOrderAdapter mineAfterSaleAllOrderAdapter;
    private TextView view_head_title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_after_sale_all_order;
    }

    @Override
    protected void afterOnCreate() {
        loadMessage();
        initView();
    }

    public void initView(){
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("全部订单");
        mine_after_sale_all_lv= (ListView) findViewById(R.id.mine_after_sale_all_lv);
        mineAfterSaleAllOrderAdapter=new MineAfterSaleAllOrderAdapter(this);
        mine_after_sale_all_lv.setAdapter(mineAfterSaleAllOrderAdapter);
        mine_after_sale_all_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startAct(AfterSaleStateActivity.class);
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

    public void loadData(){

    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.APPLYLIST)
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
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
