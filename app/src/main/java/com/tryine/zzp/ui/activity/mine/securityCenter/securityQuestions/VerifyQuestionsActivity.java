package com.tryine.zzp.ui.activity.mine.securityCenter.securityQuestions;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.ActivityCollector;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.ui.MainActivity;
import com.tryine.zzp.ui.activity.login.RegisterSuccessActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.angmarch.views.NiceSpinner;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Code.REQUEST_CODE;
import static com.tryine.zzp.app.constant.Code.RESULT_CODE;

public class VerifyQuestionsActivity extends BaseStatusMActivity implements View.OnClickListener {

    private EditText security_center_answer_et1;
    private EditText security_center_answer_et2;
    private EditText security_center_answer_et3;
    private NiceSpinner security_center_question_tv1;
    private NiceSpinner security_center_question_tv2;
    private NiceSpinner security_center_question_tv3;
    private TextView view_head_title;
    private String answer1;
    private String answer2;
    private String answer3;
    private String question1;
    private String question2;
    private String question3;
    private String answer_id;
    private ImageView security_center_1_icon;
    private String style;
    private List<String> questionArray;
    private LinearLayout security_center_title_ll;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_verify_questions;
    }

    @Override
    protected void afterOnCreate() {
        style = getIntent().getStringExtra("style");
        answer_id = getIntent().getStringExtra("answer_id");
        LogUtils.e(answer_id);
        question1 = getIntent().getStringExtra("questionOne");
        question2 = getIntent().getStringExtra("questionTwo");
        question3 = getIntent().getStringExtra("questionThree");
        answer1 = getIntent().getStringExtra("answer1");
        answer2 = getIntent().getStringExtra("answer2");
        answer3 = getIntent().getStringExtra("answer3");
        loadData();
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
        findViewById(R.id.security_center_verity_next).setOnClickListener(this);
        security_center_1_icon = (ImageView) findViewById(R.id.security_center_1_icon);
        security_center_title_ll= (LinearLayout) findViewById(R.id.security_center_title_ll);
        if (!style.equals("Fill_question")) {
            questionArray = new ArrayList<>(Arrays.asList("请选择密保问题？", "q1", "q2", "q3"));
            security_center_question_tv1.attachDataSource(questionArray);
            security_center_question_tv2.attachDataSource(questionArray);
            security_center_question_tv3.attachDataSource(questionArray);
            security_center_title_ll.setVisibility(View.GONE);
        } else {
            security_center_question_tv1.setText(question1);
            security_center_question_tv2.setText(question2);
            security_center_question_tv3.setText(question3);
            security_center_question_tv1.setClickable(false);
            security_center_question_tv1.hideArrow();
            security_center_question_tv2.setClickable(false);
            security_center_question_tv2.hideArrow();
            security_center_question_tv3.setClickable(false);
            security_center_question_tv3.hideArrow();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.security_center_verity_next:
                getAnswer();
                if (style.equals("Fill_question")) {
                    question1 = "q1";
                    question2 = "q2";
                    question3 = "q3";
                    answer1 = "a1";
                    answer2 = "a2";
                    answer3 = "a3";
                    if (StringUtils.isEmpty(answer1)) {
                        ToastUtils.showShort("请设置答案一");
                        return;
                    }
                    if (StringUtils.isEmpty(answer2)) {
                        ToastUtils.showShort("请设置答案二");
                        return;
                    }
                    if (StringUtils.isEmpty(answer3)) {
                        ToastUtils.showShort("请设置答案三");
                        return;
                    }
                    veritySettingAnswer();
                } else {

                    if (StringUtils.isEmpty(answer1)) {
                        ToastUtils.showShort("请设置答案一");
                        return;
                    }

                    if (question1.equals("请选择密保问题？")) {
                        ToastUtils.showShort("请设置问题一");
                        return;
                    }
                    if (StringUtils.isEmpty(answer2)) {
                        ToastUtils.showShort("请设置答案二");
                        return;
                    }
                    if (question2.equals("请选择密保问题？")) {
                        ToastUtils.showShort("请设置问题二");
                        return;
                    }
                    if (question3.equals("请选择密保问题？")) {
                        ToastUtils.showShort("请设置问题三");
                        return;
                    }
                    if (StringUtils.isEmpty(answer3)) {
                        ToastUtils.showShort("请设置答案三");
                        return;
                    }
                    resettingMessage();
                }
                break;
            case R.id.security_center_question_tv1:
                break;
            case R.id.security_center_question_tv2:
                break;
            case R.id.security_center_question_tv3:
                break;
            case R.id.view_head_back:
                mActivity.finish();
                break;
            default:
                break;
        }
    }

    public void getAnswer() {
        question1 = security_center_question_tv1.getText().toString();
        answer1 = security_center_answer_et1.getText().toString();
        question2 = security_center_question_tv2.getText().toString();
        answer2 = security_center_answer_et2.getText().toString();
        question3 = security_center_question_tv3.getText().toString();
        answer3 = security_center_answer_et3.getText().toString();
    }

    public void veritySettingAnswer() {
        OkHttpUtils
                .post()
                .url(Api.COMMITQUESTION)
                .addParams("answer_id", answer_id)
                .addParams("answerOne", answer1)
                .addParams("answerTwo", answer2)
                .addParams("answerThree", answer3)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        LogUtils.e(string);
                        JSONObject jsonObject = new JSONObject(string);
                        LogUtils.e(jsonObject.getString("msg"));
                        startActForResult(VerifySuccessActivity.class,REQUEST_CODE);
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

    public void resettingMessage() {
        OkHttpUtils
                .post()
                .url(Api.ENCRYPTED)
                .addParams("answer_id", answer_id)
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
                        String string = response.body().toString();
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
                            JSONObject jsonObject = new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                            ToastUtils.showShort(jsonObject.getString("msg"));
                            if (jsonObject.getInt("status") == 330) {
                                Bundle bundle=new Bundle();
                                bundle.putString("resettingMessage","resettingMessage");
                                startActForResult(VerifySuccessActivity.class,bundle ,REQUEST_CODE);
                            }
                        } catch (Exception e) {

                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CODE&&resultCode==RESULT_CODE){
            setResult(RESULT_CODE);
            finish();
        }
    }
}
