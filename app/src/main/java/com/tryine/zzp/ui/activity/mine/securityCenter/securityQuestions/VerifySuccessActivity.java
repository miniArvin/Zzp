package com.tryine.zzp.ui.activity.mine.securityCenter.securityQuestions;


import android.view.View;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.app.ActivityCollector;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.ui.MainActivity;

import static com.tryine.zzp.app.constant.Code.RESULT_CODE;

public class VerifySuccessActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_verify_success;
    }

    @Override
    protected void afterOnCreate() {
        loadData();

    }

    public void loadData(){
        view_head_title= (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("安全中心");
        findViewById(R.id.security_center_setting_finish).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.security_center_setting_finish:
                setResult(RESULT_CODE);
                finish();
                break;
            case R.id.view_head_back:
                finish();
                break;
        }
    }
}
