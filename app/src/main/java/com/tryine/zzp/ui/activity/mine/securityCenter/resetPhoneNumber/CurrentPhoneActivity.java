package com.tryine.zzp.ui.activity.mine.securityCenter.resetPhoneNumber;

import android.view.View;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.ui.activity.mine.securityCenter.resetPassword.VerifyTypeActivity;

public class CurrentPhoneActivity extends BaseStatusMActivity {
    private TextView current_phone_tv;
    private String currentPhone;
    private TextView view_head_title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_current_phone;
    }

    @Override
    protected void afterOnCreate() {
        currentPhone=getIntent().getStringExtra("phone");
        loadData();
    }

    public void loadData(){
        current_phone_tv= (TextView) findViewById(R.id.current_phone_tv);
        current_phone_tv.setText(currentPhone);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("我的手机号");
        findViewById(R.id.change_phone_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAct(VerifyTypeActivity.class);
            }
        });
        findViewById(R.id.view_head_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
