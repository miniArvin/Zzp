package com.tryine.zzp.ui.activity.mine.afterSale;


import android.view.View;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;

public class AfterSaleStateActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_after_sale_state;
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
    }

    public void loadMessage(){

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
