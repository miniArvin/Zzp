package com.tryine.zzp.ui.activity.mine.order;

import android.view.View;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.widget.BottomDialog.BottomDialog;

public class OrderActivity extends BaseStatusMActivity implements View.OnClickListener {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void afterOnCreate() {

    }

    public void init(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order_cost_tv:
                BottomDialog.create(getSupportFragmentManager())
                        .setViewListener(new BottomDialog.ViewListener() {
                            @Override
                            public void bindView(View v) {

                            }
                        })
                        .setLayoutRes(R.layout.order_cost_dialog)
                        .setCancelOutside(false)
                        .show();
                break;
        }
    }
}
