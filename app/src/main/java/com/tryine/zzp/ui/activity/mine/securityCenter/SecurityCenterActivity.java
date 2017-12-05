package com.tryine.zzp.ui.activity.mine.securityCenter;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.ui.activity.mine.securityCenter.resetPassword.ResetPasswordActivity;
import com.tryine.zzp.ui.activity.mine.securityCenter.resetPhoneNumber.CurrentPhoneActivity;
import com.tryine.zzp.ui.activity.mine.securityCenter.resetPhoneNumber.MyPhoneActivity;
import com.tryine.zzp.ui.activity.mine.securityCenter.securityQuestions.FillOutQuestionsActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class SecurityCenterActivity extends BaseStatusMActivity implements View.OnClickListener {

    private TextView security_center_name_tv;
    private TextView security_center_level_tv;
    private ProgressBar level_progress_pb;
    private TextView security_answer_tv;
    private TextView view_head_title;
    private TextView email_tv;
    private TextView phone_tv;
    private TextView questions_tv;
    private String level;
    private int proportion;
    private String email;
    private String mobile;
    private String cash_password;
    private String user_answer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_security_center;
    }

    @Override
    protected void afterOnCreate() {
        loadData();
        init();
    }

    public void init() {
        security_center_name_tv= (TextView) findViewById(R.id.security_center_name_tv);
        security_center_level_tv= (TextView) findViewById(R.id.security_center_level_tv);
        level_progress_pb= (ProgressBar) findViewById(R.id.level_progress_pb);
        findViewById(R.id.account_rv).setOnClickListener(this);
        findViewById(R.id.password_rv).setOnClickListener(this);
        findViewById(R.id.email_rv).setOnClickListener(this);
        findViewById(R.id.phone_rv).setOnClickListener(this);
        findViewById(R.id.questions_rv).setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("安全中心");
        findViewById(R.id.view_head_back).setOnClickListener(this);
        email_tv = (TextView) findViewById(R.id.email_tv);
        phone_tv = (TextView) findViewById(R.id.phone_tv);
        questions_tv = (TextView) findViewById(R.id.questions_tv);
        email_tv.setOnClickListener(this);
        phone_tv.setOnClickListener(this);
        questions_tv.setOnClickListener(this);
    }

    public void loadData() {
        OkHttpUtils
                .post()
                .url(Api.SECURITYCENTER)
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
                        LogUtils.e(response.toString());
                        try {
                            JSONObject jo = new JSONObject(response.toString());
                            LogUtils.e(jo);
                            if (jo.getInt("status") == 330) {
                                LogUtils.e(jo.getInt("status"));
                                String joData=jo.getString("data");
                                JSONObject data = new JSONObject(joData);
                                JSONObject info = data.getJSONObject("info");
                                LogUtils.e(data);
                                level = data.getString("level");
                                security_center_level_tv.setText("安全等级："+level);
                                proportion = data.getInt("proportion");
                                level_progress_pb.setProgress(proportion);
                                LogUtils.e(proportion);
                                email = info.optString("email");
                                if (email.equals("null")){
                                    email_tv.setText("未设置");
                                }else {
                                    email_tv.setText(email);
                                }
                                mobile = info.optString("mobile");
                                if (mobile.equals("null")){
                                    phone_tv.setText("未设置");
                                }else {
                                    phone_tv.setText(mobile);
                                }
                                cash_password = info.optString("cash_password");
                                user_answer = info.optString("user_answer");
                                JSONObject answerInfo=new JSONObject(user_answer);
                                String statu=answerInfo.optString("statu");
                                if (user_answer.equals("null")){
                                    questions_tv.setText("未设置");
                                }else {
                                    questions_tv.setText(statu);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        Bundle bundle=new Bundle();
        switch (v.getId()) {
            case R.id.view_head_back:
                finish();
                break;
            case R.id.account_rv:
                startAct(ResetPasswordActivity.class, false);
                break;
            case R.id.password_rv:
                startAct(ResetPasswordActivity.class);
                break;
            case R.id.email_tv:
            case R.id.email_rv:
                startAct(MyPhoneActivity.class);
                break;
            case R.id.phone_tv:
            case R.id.phone_rv:
                if (!mobile.isEmpty()){
                    bundle.putString("phone",mobile);
                    startAct(CurrentPhoneActivity.class,bundle);
                }else {
                    bundle.putString("text","很抱歉，当前未绑定手机号");
                    startAct(MyPhoneActivity.class,bundle);
                }

                break;
            case R.id.questions_rv:
                startAct(FillOutQuestionsActivity.class);
                break;
            default:
                break;
        }
    }

}
