package com.tryine.zzp.ui.activity.mine.distribution;

import android.view.View;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;

public class CommissionManageActivity extends BaseStatusMActivity implements View.OnClickListener {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_commission_manage;
    }

    @Override
    protected void afterOnCreate() {
        init();
    }
    public void init(){
        findViewById(R.id.commission_manage_detail_tv).setOnClickListener(this);
        findViewById(R.id.commission_manage_withdraw_tv).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.commission_manage_detail_tv:
                startAct(CommissionDetailActivity.class);
                break;
            case R.id.commission_manage_withdraw_tv:
                startAct(CommissionWithdrawActivity.class);
                break;
            default:
                break;
        }
    }
}
