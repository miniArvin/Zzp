package com.tryine.zzp.ui.activity.mine.securityCenter.email;


import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class BindingEmailActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;
    private String bindingType;
    private EditText binding_type_tv;
    private EditText binding_type_code_tv;
    private String code;
    private String account;
    private ImageView binding_type_icon;
    private String url;
    private String accountType;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_binding_email;
    }

    @Override
    protected void afterOnCreate() {
        bindingType=getIntent().getStringExtra("style");
        loadData();
    }

    public void loadData(){
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title= (TextView) findViewById(R.id.view_head_title);
        binding_type_tv= (EditText) findViewById(R.id.binding_type_tv);
        binding_type_code_tv= (EditText) findViewById(R.id.binding_type_code_tv);
        findViewById(R.id.binding_finish_tv).setOnClickListener(this);
        binding_type_icon= (ImageView) findViewById(R.id.binding_type_icon);
        findViewById(R.id.binding_get_code_tv).setOnClickListener(this);
        if (bindingType.equals("phone")) {
            view_head_title.setText("绑定手机号");
            binding_type_tv.setHint("请输入手机号码");
            binding_type_code_tv.setHint("手机验证码");
            binding_type_icon.setImageDrawable(getResources().getDrawable(R.drawable.security_center_people_icon));
            url= Api.PHONECODE;
            accountType="mobile";
        }else {
            view_head_title.setText("绑定邮箱");
            binding_type_tv.setHint("请输入邮箱");
            binding_type_code_tv.setHint("邮箱验证码");
            binding_type_icon.setImageDrawable(getResources().getDrawable(R.drawable.security_center_email_icon));
            url=Api.EMAILCODE;
            accountType="email";
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_head_back:
                finish();
                break;
            case R.id.view_head_title:
                break;
            case R.id.binding_finish_tv:
                inputMessage();
                if ((!account.isEmpty())&&(!code.isEmpty())){
                    bindingAccount(url,code,account);
                }else {
                    if (bindingType.equals("phone")) {
                        if (account.isEmpty()){
                            ToastUtils.showShort("请输入手机号");
                            return;
                        }
                        if (code.isEmpty()){
                            ToastUtils.showShort("请输入手机验证码");
                            return;
                        }
                    }else {
                        if (account.isEmpty()){
                            ToastUtils.showShort("请输入邮箱");
                            return;
                        }
                        if (code.isEmpty()){
                            ToastUtils.showShort("请输入邮箱验证码");
                            return;
                        }
                    }

                }
                break;
            case R.id.binding_get_code_tv:
                inputMessage();
                if ((!account.isEmpty())){
                    loadCode(url,account);
                }else {
                    if (bindingType.equals("phone")) {
                        if (account.isEmpty()){
                            ToastUtils.showShort("请输入手机号");
                            return;
                        }
                    } else {
                        if (account.isEmpty()){
                            ToastUtils.showShort("请输入邮箱");
                            return;
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    public void inputMessage(){
        account=binding_type_tv.getText().toString();
        code=binding_type_code_tv.getText().toString();
    }

    public void loadCode(String url,String codeType){
        OkHttpUtils
                .post()
                .url(url)
                .addParams(accountType,codeType)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        LogUtils.e(response.body().toString());
                        return response.body().toString();
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e(e);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                            ToastUtils.showShort(jsonObject.getString("msg"));
                        }catch (Exception e){

                        }
                    }
                });
    }

    public void bindingAccount(String url,String codeType,String account){
        OkHttpUtils
                .post()
                .url(url)
                .addParams(accountType,account)
                .addParams("code",codeType)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        LogUtils.e(response.body().toString());
                        return response.body().toString();
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e(e);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        try {
                            JSONObject jsonObject= new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                        }catch (Exception e){

                        }
                    }
                });
    }
}
