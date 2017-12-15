package com.tryine.zzp.ui.activity.mine.order.order_time;


import android.view.View;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;

public class PaymentSuccessActivity extends BaseStatusMActivity implements View.OnClickListener {
    private String amount;
    private TextView hotel_order_submit_success_price_tv;
    private TextView view_head_title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_payment_success;
    }

    @Override
    protected void afterOnCreate() {
        amount = getIntent().getStringExtra("amount");
        initView();
    }

    public void loadData(){

    }

    public void initView(){
        hotel_order_submit_success_price_tv = (TextView) findViewById(R.id.hotel_order_submit_success_price_tv);
        hotel_order_submit_success_price_tv.setText("￥"+amount);
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("支付成功");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_head_back:
                finish();
                break;
            case R.id.hotel_order_submit_continue_order_tv:
                break;
            case R.id.hotel_order_submit_check_order_tv:
                break;
        }
    }
}
