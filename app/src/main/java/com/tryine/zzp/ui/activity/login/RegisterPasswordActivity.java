package com.tryine.zzp.ui.activity.login;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;

public class RegisterPasswordActivity extends BaseStatusMActivity implements View.OnClickListener {
    private EditText register_password;
    private EditText register_password_again;
    private TextView register_finish;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register_password;
    }

    @Override
    protected void afterOnCreate() {
        initView();
    }

    public void initView(){
        register_password= (EditText) findViewById(R.id.register_password);
        register_password_again= (EditText) findViewById(R.id.register_password_again);
        register_finish= (TextView) findViewById(R.id.register_finish);
        register_finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.register_finish:
                break;
            default:
                break;
        }
    }
}
