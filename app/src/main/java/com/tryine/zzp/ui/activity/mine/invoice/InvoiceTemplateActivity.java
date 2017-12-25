package com.tryine.zzp.ui.activity.mine.invoice;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Code.REQUEST_CODE;
import static com.tryine.zzp.app.constant.Code.RESULT_CODE;

public class InvoiceTemplateActivity extends BaseStatusMActivity implements View.OnClickListener {
    private LinearLayout mine_invoice_add_title_ll;
    private TextView mine_invoice_title_tv;
    private TextView view_head_title;
    private String common="";
    private String special="";
    private boolean isCommon=true;
    private LinearLayout mine_invoice_special_ll;
    private LinearLayout mine_invoice_common_ll;
    private TextView mine_invoice_common_tv;
    private TextView mine_invoice_special_tv;
    private View mine_invoice_common_v;
    private View mine_invoice_special_v;
    private Bundle bundle;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_invoice_template;
    }

    @Override
    protected void afterOnCreate() {
        loadMessage(Api.COMMONINVOICE);
        loadMessage(Api.SPECIALINVOICE);
        initView();
    }

    public void initView(){
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        mine_invoice_add_title_ll = (LinearLayout) findViewById(R.id.mine_invoice_add_title_ll);
        mine_invoice_title_tv = (TextView) findViewById(R.id.mine_invoice_title_tv);
        mine_invoice_add_title_ll.setOnClickListener(this);
        mine_invoice_title_tv.setOnClickListener(this);
        view_head_title.setText("发票模板");
        mine_invoice_special_tv = (TextView) findViewById(R.id.mine_invoice_special_tv);
        mine_invoice_common_tv = (TextView) findViewById(R.id.mine_invoice_common_tv);
        mine_invoice_common_v = findViewById(R.id.mine_invoice_common_v);
        mine_invoice_special_v = findViewById(R.id.mine_invoice_special_v);
        mine_invoice_special_ll = (LinearLayout) findViewById(R.id.mine_invoice_special_ll);
        mine_invoice_special_ll.setOnClickListener(this);
        mine_invoice_common_ll = (LinearLayout) findViewById(R.id.mine_invoice_common_ll);
        mine_invoice_common_ll.setOnClickListener(this);
        bundle = new Bundle();
    }

    public void loadMessage(final String url){
        OkHttpUtils
                .post()
                .url(url)
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
                            JSONObject jsonObject = new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                            if (url.equals(Api.COMMONINVOICE)){
                                if (jsonObject.getInt("status")==339){
                                    bundle.putInt("null",0);
                                    mine_invoice_add_title_ll.setVisibility(View.VISIBLE);
                                }else if (jsonObject.getInt("status")==330){
                                    bundle.putInt("null",1);
                                    JSONObject info = new JSONObject(jsonObject.getString("info"));
                                    common = info.getString("invoice_name");
                                    mine_invoice_title_tv.setText(common);
                                    mine_invoice_title_tv.setVisibility(View.VISIBLE);
                                }
                            }else {
                                if (jsonObject.getInt("status")==339){
                                    bundle.putInt("null",0);
                                }else if (jsonObject.getInt("status")==330){
                                    bundle.putInt("null",1);
                                    JSONObject info = new JSONObject(jsonObject.getString("info"));
                                    special = info.getString("invoice_name");
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
        switch (v.getId()){
            case R.id.view_head_back:
                finish();
                break;
            case R.id.mine_invoice_title_tv:
                if (isCommon){
                    startActForResult(CommonInvoiceTemplateActivity.class,bundle,RESULT_CODE);
                }else {
                    startActForResult(SpecialInvoiceTemplateActivity.class,bundle,RESULT_CODE);
                }
                break;
            case R.id.mine_invoice_add_title_ll:
                if (isCommon){
                    startActForResult(CommonInvoiceTemplateActivity.class,bundle,RESULT_CODE);
                }else {
                    startActForResult(SpecialInvoiceTemplateActivity.class,bundle,RESULT_CODE);
                }
                break;
            case R.id.mine_invoice_common_ll:
                if (!isCommon){
                    isCommon=true;
                    mine_invoice_common_tv.setTextColor(getResources().getColor(R.color.orange));
                    mine_invoice_common_v.setBackgroundResource(R.color.orange);
                    mine_invoice_special_tv.setTextColor(getResources().getColor(R.color.black));
                    mine_invoice_special_v.setBackgroundResource(R.color.black);
                    mine_invoice_special_v.setVisibility(View.GONE);
                    mine_invoice_common_v.setVisibility(View.VISIBLE);
                    if (!common.equals("")){
                        if (mine_invoice_title_tv.getVisibility()==View.GONE) {
                            mine_invoice_title_tv.setVisibility(View.VISIBLE);
                            mine_invoice_add_title_ll.setVisibility(View.GONE);
                            mine_invoice_title_tv.setText(common);
                        }else {
                            mine_invoice_title_tv.setText(common);
                        }
                    }else {
                        if (mine_invoice_title_tv.getVisibility()==View.VISIBLE){
                            mine_invoice_title_tv.setVisibility(View.GONE);
                            mine_invoice_add_title_ll.setVisibility(View.VISIBLE);
                        }
                    }
                }
                break;
            case R.id.mine_invoice_special_ll:
                if (isCommon){
                    isCommon=false;
                    mine_invoice_special_tv.setTextColor(getResources().getColor(R.color.orange));
                    mine_invoice_special_v.setBackgroundResource(R.color.orange);
                    mine_invoice_common_tv.setTextColor(getResources().getColor(R.color.black));
                    mine_invoice_common_v.setBackgroundResource(R.color.black);
                    mine_invoice_common_v.setVisibility(View.GONE);
                    mine_invoice_special_v.setVisibility(View.VISIBLE);
                    if (!special.equals("")){
                        if (mine_invoice_title_tv.getVisibility()==View.GONE) {
                            mine_invoice_title_tv.setVisibility(View.VISIBLE);
                            mine_invoice_add_title_ll.setVisibility(View.GONE);
                            mine_invoice_title_tv.setText(special);
                        }else {
                            mine_invoice_title_tv.setText(special);
                        }
                    }else {
                        if (mine_invoice_title_tv.getVisibility()==View.VISIBLE){
                            mine_invoice_title_tv.setVisibility(View.GONE);
                            mine_invoice_add_title_ll.setVisibility(View.VISIBLE);
                        }
                    }
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CODE&&resultCode==RESULT_CODE){
            setResult(RESULT_CODE);
            Bundle resultBundle = new Bundle();
            resultBundle = data.getExtras().getBundle("common");
            if (resultBundle != null) {
                common = resultBundle.getString("invoice_name");
                mine_invoice_title_tv.setText(common);

            }else {

            }
        }
    }
}
