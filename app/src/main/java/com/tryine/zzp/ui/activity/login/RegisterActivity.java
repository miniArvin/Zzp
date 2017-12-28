package com.tryine.zzp.ui.activity.login;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.ActivityCollector;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;

import com.tryine.zzp.ui.MainActivity;
import com.tryine.zzp.utils.TimerUtils;


import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;


import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Code.REQUEST_CODE;
import static com.tryine.zzp.app.constant.Code.RESULT_CODE;


public class RegisterActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView register_finish_num;
    private EditText register_finish_phone;
    private EditText register_finish_password;
    private EditText register_finish_input_code;
    private TextView register_finish_get_code;
    private ImageView register_finish_agree;
    private TextView register_finish_rule;
    private String phone;
    private String code;
    private String password;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void afterOnCreate() {
        initVIew();
    }

    public void initVIew() {
        register_finish_num = (TextView) findViewById(R.id.register_finish_num);
        register_finish_phone = (EditText) findViewById(R.id.register_finish_phone);
        register_finish_password = (EditText) findViewById(R.id.register_finish_password);
        register_finish_input_code = (EditText) findViewById(R.id.register_finish_input_code);
        register_finish_get_code = (TextView) findViewById(R.id.register_finish_get_code);
        register_finish_get_code.setOnClickListener(this);
        findViewById(R.id.register_finish_btn).setOnClickListener(this);
        register_finish_agree = (ImageView) findViewById(R.id.register_finish_agree);
        register_finish_agree.setOnClickListener(this);
        register_finish_rule = (TextView) findViewById(R.id.register_finish_rule);
        register_finish_rule.setOnClickListener(this);
        findViewById(R.id.view_head_back).setOnClickListener(this);
    }

    public void getUserMessage() {
        phone = register_finish_phone.getText().toString().trim();
        password = register_finish_password.getText().toString().trim();
        code = register_finish_input_code.getText().toString().trim();
    }

    public void getCode() {
        getUserMessage();
        if (!phone.isEmpty()) {
            OkHttpUtils
                    .post()
                    .url(Api.CODE)
                    .addParams("mobile", phone)
                    .build()
                    .execute(new Callback() {
                        private String msg;
                        private int status;
                        @Override
                        public Object parseNetworkResponse(Response response, int id) throws Exception {
                            String string = response.body().string();
                            LogUtils.e("one_string", string);
                            return string;
                        }

                        @Override
                        public void onError(Call call, Exception e, int id) {
                            LogUtils.e("one_1111111", "exception" + e.getMessage());
                        }

                        @Override
                        public void onResponse(Object response, int id) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.toString());
                                LogUtils.e(jsonObject);
                                status=jsonObject.getInt("status");
                                msg=jsonObject.getString("msg");
                                LogUtils.e(status);
                                LogUtils.e(msg);
                                ToastUtils.showShort(msg);
                                if (status==381) {
                                    String mobileCode = jsonObject.getJSONObject("info").getString("MobileCode");
                                    register_finish_input_code.setText(mobileCode);
                                    TimerUtils.CountDownTimer(register_finish_get_code, 60000, "重新获取(", ")", new TimerUtils.OnCountDownFinishListener() {
                                        @Override
                                        public void OnCountDownFinish() {
                                        }
                                    });
                                } else {
                                    LogUtils.e("one_!200", "123456");
                                    register_finish_input_code.requestFocus();
                                    TimerUtils.CountDownTimer(register_finish_get_code, 60000, "重新获取(", ")", new TimerUtils.OnCountDownFinishListener() {
                                        @Override
                                        public void OnCountDownFinish() {
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

        } else {
            ToastUtils.showShort("请输入手机号码");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_finish_btn:
                onRegister();
                break;
            case R.id.register_finish_agree:
                break;
            case R.id.register_finish_rule:
                break;
            case R.id.register_finish_get_code:
                getCode();
                break;
            case R.id.view_head_back:
                finish();
                break;
            default:
                break;
        }
    }

    public void onRegister() {
        getUserMessage();
        if (password.length() < 6) {
            ToastUtils.showShort("请设置6位以上密码");
            return;
        }
        OkHttpUtils
                .post()
                .url(Api.REGISTER)
                .addParams("account", phone)
                .addParams("scode", code)
                .addParams("password", password)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        Log.e("one_toString_body", string);
                        return string;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        Log.e("one_result", response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            Log.e("one_jsonObject", jsonObject.getString("status"));
                            if (jsonObject.getInt("status") == 200) {
                                Log.e("one_status", jsonObject.getInt("status") + "");
                                loadData();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void loadData(){
        startAct(RegisterSuccessActivity.class);
        setResult(RESULT_CODE);
        finish();
    }
}
