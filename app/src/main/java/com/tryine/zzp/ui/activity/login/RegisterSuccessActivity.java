package com.tryine.zzp.ui.activity.login;

import android.view.View;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;

public class RegisterSuccessActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView register_success_login;
    private TextView register_success_look;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register_success;
    }

    @Override
    protected void afterOnCreate() {
        initView();
    }

    public void initView(){
        register_success_login= (TextView) findViewById(R.id.register_success_login);
        register_success_login.setOnClickListener(this);
        register_success_look= (TextView) findViewById(R.id.register_success_look);
        register_success_look.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_success_login:
                break;
            case R.id.register_success_look:
                break;
            default:
                break;
        }
    }
}
