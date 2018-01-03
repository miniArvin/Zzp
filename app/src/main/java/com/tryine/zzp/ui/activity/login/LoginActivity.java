package com.tryine.zzp.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;

import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;

import com.tryine.zzp.ui.MainActivity;
import com.tryine.zzp.ui.activity.mine.securityCenter.resetPassword.PhoneVerityActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;


import org.json.JSONException;
import org.json.JSONObject;


import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Code.REQUEST_CODE;
import static com.tryine.zzp.app.constant.Code.RESULT_CODE;
import static com.tryine.zzp.app.constant.Cons.SP_USER_ACCOUNT;
import static com.tryine.zzp.app.constant.Cons.SP_USER_EMAIL;
import static com.tryine.zzp.app.constant.Cons.SP_USER_FACE;
import static com.tryine.zzp.app.constant.Cons.SP_USER_ID;
import static com.tryine.zzp.app.constant.Cons.SP_USER_NAME;
import static com.tryine.zzp.app.constant.Cons.SP_USER_PHONE;
import static com.tryine.zzp.app.constant.Cons.SP_USER_TOKEN;

public class LoginActivity extends BaseStatusMActivity implements View.OnClickListener {
    private EditText login_phone;
    private EditText login_password;
    private String phone;
    private String password;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void afterOnCreate() {
        loadData();
    }

    public void loadData() {
        login_phone = (EditText) findViewById(R.id.login_phone);
        login_password = (EditText) findViewById(R.id.login_password);
        findViewById(R.id.login_btn).setOnClickListener(this);
        findViewById(R.id.login_new).setOnClickListener(this);
        findViewById(R.id.login_forget_password).setOnClickListener(this);
        findViewById(R.id.login_third_wx).setOnClickListener(this);
        findViewById(R.id.login_third_qq).setOnClickListener(this);
        findViewById(R.id.login_third_wb).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                userLogin();
                break;
            case R.id.login_new:
                startActForResult(RegisterActivity.class,REQUEST_CODE);
                break;
            case R.id.login_forget_password:
                startAct(PhoneVerityActivity.class);
                break;
            case R.id.login_third_wx:
                break;
            case R.id.login_third_qq:
                break;
            case R.id.login_third_wb:
                break;
            default:
                break;

        }
    }

    public void getUserMessage() {
        phone = login_phone.getText().toString().trim();
        password = login_password.getText().toString().trim();
    }

    public void userLogin() {
        getUserMessage();
        if (!RegexUtils.isMobileExact(phone)) {
            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length()<6){
            Toast.makeText(this, "请输入六位数以上密码", Toast.LENGTH_SHORT).show();
            return;
        }
        OkHttpUtils
                .post()
                .url(Api.LOGIN)
                .addParams("account", phone)
                .addParams("password", password)
                .build()
                .execute(new Callback() {

                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        LogUtils.e("response.body", string);
                        return string;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e(e);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        LogUtils.e("user,user", response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            if (jsonObject.getInt("status") == 202) {
                                LogUtils.e("user,status", jsonObject.getInt("status") + "");
                                JSONObject userInfo = jsonObject.getJSONObject("user_info");
                                JSONObject userToken = jsonObject.getJSONObject("user_token");
                                SPUtils.getInstance().put(SP_USER_ID,userInfo.getString("user_id"));
                                SPUtils.getInstance().put(SP_USER_TOKEN,userToken.getString("token"));
                                SPUtils.getInstance().put(SP_USER_PHONE,phone);
                                SPUtils.getInstance().put(SP_USER_EMAIL,userInfo.getString("email"));
                                SPUtils.getInstance().put(SP_USER_ACCOUNT,userInfo.getString("account"));
                                SPUtils.getInstance().put(SP_USER_NAME,userInfo.getString("nickname"));
                                SPUtils.getInstance().put(SP_USER_FACE,userInfo.getString("face"));
                                finish();
                            }else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CODE&&resultCode==RESULT_CODE){
            finish();
        }
    }
}
