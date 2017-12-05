package com.tryine.zzp.ui.activity.mine.securityCenter.resetPassword;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.ui.activity.mine.securityCenter.email.BindingEmailActivity;
import com.tryine.zzp.ui.activity.mine.securityCenter.securityQuestions.FillOutQuestionsActivity;
import com.tryine.zzp.ui.activity.mine.securityCenter.securityQuestions.VerifyQuestionsActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class VerifyTypeActivity extends BaseStatusMActivity implements View.OnClickListener {
    private String security;
    private String email;
    private String phone;
    private TextView view_head_title;
    private String answer_id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_verify_type;
    }

    @Override
    protected void afterOnCreate() {
        loadData();
        getMessage();
    }

    public void loadData(){
        findViewById(R.id.verity_email_rl).setOnClickListener(this);
        findViewById(R.id.verity_phone_rl).setOnClickListener(this);
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title= (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("选择验证方式");
    }

    public void getMessage(){
        OkHttpUtils
                .post()
                .url(Api.VERITYTYPE)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        LogUtils.e(string);
                        return string;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e(e);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.toString());
                            if (jsonObject.getInt("status")==330){
                                JSONObject info=jsonObject.getJSONObject("info");
                                phone=info.optString("mobile");
                                email=info.optString("email");
                                security=info.optString("security");
                                if (!security.isEmpty()){
                                    JSONObject joSecurity = new JSONObject(security);
                                    answer_id=joSecurity.getString("answer_id");
                                }
                            }
                        }catch (Exception e){

                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        Bundle bundle=new Bundle();
        switch (v.getId()){
            case R.id.verity_email_rl:
                bundle.putString("style","email");
                if (email.equals("null")){
                    startAct(BindingEmailActivity.class,bundle);
                }else {
                    if (security.isEmpty()){
                        startAct(FillOutQuestionsActivity.class);
                    }else {
                        bundle.putString("answer_id",answer_id);
                        startAct(VerifyQuestionsActivity.class,bundle);
                    }
                }
                break;
            case R.id.verity_phone_rl:
                bundle.putString("style","phone");
                if (bundle.equals("null")){
                    startAct(BindingEmailActivity.class,bundle);
                }else {
                    if (security.isEmpty()){
                        startAct(FillOutQuestionsActivity.class);
                    }else {
                        bundle.putString("answer_id",answer_id);
                        startAct(VerifyQuestionsActivity.class,bundle);
                    }
                }
                break;
            case R.id.view_head_back:
                finish();
                break;
            default:
                break;
        }
    }
}
