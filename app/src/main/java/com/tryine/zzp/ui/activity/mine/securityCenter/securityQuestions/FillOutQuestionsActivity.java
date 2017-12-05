package com.tryine.zzp.ui.activity.mine.securityCenter.securityQuestions;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.ActivityCollector;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.ui.MainActivity;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;


import org.angmarch.views.NiceSpinner;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Code.REQUEST_CODE;
import static com.tryine.zzp.app.constant.Code.RESULT_CODE;


public class FillOutQuestionsActivity extends BaseStatusMActivity implements View.OnClickListener {
    private EditText security_center_answer_et1;
    private EditText security_center_answer_et2;
    private EditText security_center_answer_et3;
    private NiceSpinner security_center_question_tv1;
    private NiceSpinner security_center_question_tv2;
    private NiceSpinner security_center_question_tv3;
    private ImageView security_center_2_icon;
    private ImageView security_center_3_icon;
    private TextView view_head_title;
    private String answer1;
    private String answer2;
    private String answer3;
    private String question1;
    private String question2;
    private String question3;
    private TextView security_center_fill_next;
    private String style ;
    private String answer_id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fill_out_questions;
    }

    @Override
    protected void afterOnCreate() {
        loadData();
        Utils.init(getApplication());
    }

    public void loadData() {
        security_center_answer_et1 = (EditText) findViewById(R.id.security_center_answer_et1);
        security_center_answer_et2 = (EditText) findViewById(R.id.security_center_answer_et2);
        security_center_answer_et3 = (EditText) findViewById(R.id.security_center_answer_et3);
        security_center_question_tv1 = (NiceSpinner) findViewById(R.id.security_center_question_tv1);
        security_center_question_tv2 = (NiceSpinner) findViewById(R.id.security_center_question_tv2);
        security_center_question_tv3 = (NiceSpinner) findViewById(R.id.security_center_question_tv3);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("安全中心");
        security_center_question_tv1.setOnClickListener(this);
        security_center_question_tv2.setOnClickListener(this);
        security_center_question_tv3.setOnClickListener(this);
        findViewById(R.id.view_head_back).setOnClickListener(this);
        security_center_fill_next = (TextView) findViewById(R.id.security_center_fill_next);
        security_center_fill_next.setOnClickListener(this);
        security_center_2_icon = (ImageView) findViewById(R.id.security_center_2_icon);
        security_center_3_icon = (ImageView) findViewById(R.id.security_center_3_icon);
    }


    public void getAnswer() {
        question1 = security_center_question_tv1.getText().toString();
        answer1 = security_center_answer_et1.getText().toString();
        question2 = security_center_question_tv2.getText().toString();
        answer2 = security_center_answer_et2.getText().toString();
        question3 = security_center_question_tv3.getText().toString();
        answer3 = security_center_answer_et3.getText().toString();
    }

    public void commitAnswer() {
        OkHttpUtils
                .post()
                .url(Api.FILLANSWER)
                .addParams("questionOne", question1)
                .addParams("answerOne", answer1)
                .addParams("questionTwo", question2)
                .addParams("answerTwo", answer2)
                .addParams("questionThree", question3)
                .addParams("answerThree", answer3)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        LogUtils.e(string);
                        JSONObject jsonObject=new JSONObject(string);
                        LogUtils.e(jsonObject.getString("0"));
                        int status = jsonObject.getInt("status");
                        ToastUtils.showShort(jsonObject.getString("msg"));
                        if (status == 330) {
                            JSONObject info = new JSONObject(jsonObject.getString("0"));
                            LogUtils.e(info.getString("answer_id"));
                            answer_id = info.getString("answer_id");
                            style="Fill_question";
                            Bundle bundle=new Bundle();
                            bundle.putString("answer_id",answer_id);
                            bundle.putString("questionOne",question1);
                            bundle.putString("questionTwo",question2);
                            bundle.putString("questionThree",question3);
                            bundle.putString("answerOne",answer1);
                            bundle.putString("answerTwo",answer2);
                            bundle.putString("answerThree",answer3);
                            bundle.putString("style",style);
                            startActForResult(VerifyQuestionsActivity.class,bundle,REQUEST_CODE);
                            ActivityCollector.saveActivity(MainActivity.class);
                        }
                        return string;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e(e);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        LogUtils.e(response.toString());
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.security_center_fill_next:
                getAnswer();
                question1 = "q1";
                question2 = "q2";
                question3 = "q3";
                answer1 = "a1";
                answer2 = "a2";
                answer3 = "a3";
                if (StringUtils.isEmpty(question1)) {
                    ToastUtils.showShort("请设置问题一");
                    return;
                }
                if (StringUtils.isEmpty(answer1)) {
                    ToastUtils.showShort("请设置回答一");
                    return;
                }
                if (StringUtils.isEmpty(question2)) {
                    ToastUtils.showShort("请设置问题二");
                    return;
                }
                if (StringUtils.isEmpty(answer2)) {
                    ToastUtils.showShort("请设置回答二");
                    return;
                }
                if (StringUtils.isEmpty(question3)) {
                    ToastUtils.showShort("请设置问题三");
                    return;
                }
                if (StringUtils.isEmpty(answer3)) {
                    ToastUtils.showShort("请设置回答三");
                    return;
                }
                commitAnswer();
                break;
            case R.id.security_center_question_tv1:
                break;
            case R.id.security_center_question_tv2:
                break;
            case R.id.security_center_question_tv3:
                break;
            case R.id.view_head_back:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CODE&&resultCode==RESULT_CODE){
            setResult(RESULT_CODE);
            finish();
        }
    }
}
