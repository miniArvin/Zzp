package com.tryine.zzp.ui.activity.mine.securityCenter.resetPassword;

import android.view.View;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;

public class PhoneVerityActivity extends BaseStatusMActivity implements View.OnClickListener {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_phone_verity;
    }

    @Override
    protected void afterOnCreate() {
        loadData();
    }

    public void loadData(){
        findViewById(R.id.view_head_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_head_back:
                mActivity.finish();
                break;
        }
    }
}
