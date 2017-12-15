package com.tryine.zzp.ui.activity.login;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;

public class RegisterPhoneActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView register_num;
    private EditText register_phone;
    private EditText register_input_code;
    private TextView register_get_code;
    private TextView register_next;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register_phone;
    }

    @Override
    protected void afterOnCreate() {
        initView();
    }

    public void initView(){
        register_num= (TextView) findViewById(R.id.register_num);
        register_phone= (EditText) findViewById(R.id.register_phone);
        register_input_code= (EditText) findViewById(R.id.register_input_code);
        register_get_code= (TextView) findViewById(R.id.register_get_code);
        register_get_code.setOnClickListener(this);
        register_next= (TextView) findViewById(R.id.register_next);
        register_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_get_code:
                break;
            case R.id.register_next:
                break;
            default:
                break;
        }
    }
}
