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
    private String tax="";
    private String email="";
    private String name="";
    private String mobile="";
    private String detail_address="";
    private String province="";
    private String city="";
    private String district="";
    private String credit="";
    private String bank="";
    private String card="";
    private String tell="";
    private String company_address="";
    private String s_tax;
    private String s_email;
    private String s_name;
    private String s_mobile;
    private String s_detail_address;
    private String s_province;
    private String s_city;
    private String s_district;
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
                                    bundle.putString("common",common);
                                    mine_invoice_title_tv.setVisibility(View.VISIBLE);
                                    tax = info.getString("tax_code");
                                    bundle.putString("tax_code",tax);
                                    email = info.getString("email");
                                    bundle.putString("email",email);
                                    name = info.getString("name");
                                    bundle.putString("name",name);
                                    mobile = info.getString("mobile");
                                    bundle.putString("mobile",mobile);
                                    province = info.getString("province");
                                    bundle.putString("province",province);
                                    city = info.getString("city");
                                    bundle.putString("city",city);
                                    district = info.getString("district");
                                    bundle.putString("district",district);
                                    detail_address = info.getString("address");
                                    bundle.putString("address",detail_address);
                                }
                            }else {
                                if (jsonObject.getInt("status")==339){
                                    bundle.putInt("nulls",0);
                                }else if (jsonObject.getInt("status")==330){
                                    bundle.putInt("nulls",1);
                                    JSONObject info = new JSONObject(jsonObject.getString("info"));
                                    special = info.getString("invoice_name");
                                    bundle.putString("special",special);
                                    s_tax = info.getString("tax_code");
                                    bundle.putString("tax_codes",s_tax);
                                    s_email = info.getString("email");
                                    bundle.putString("emails",s_email);
                                    s_name = info.getString("name");
                                    bundle.putString("names",s_name);
                                    s_mobile = info.getString("mobile");
                                    bundle.putString("mobiles",s_mobile);
                                    s_province = info.getString("province");
                                    bundle.putString("provinces",s_province);
                                    s_city = info.getString("city");
                                    bundle.putString("citys",s_city);
                                    s_district = info.getString("district");
                                    bundle.putString("districts",s_district);
                                    s_detail_address = info.getString("address");
                                    bundle.putString("addresss",s_detail_address);
                                    credit = info.getString("credit_code");
                                    bundle.putString("credits",credit);
                                    bank = info.getString("bank");
                                    bundle.putString("banks",bank);
                                    card = info.getString("company_card");
                                    bundle.putString("cards",card);
                                    tell = info.getString("company_tell");
                                    bundle.putString("tells",tell);
                                    company_address = info.getString("company_address");
                                    bundle.putString("company_addresss",company_address);
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
            Bundle commonResult = new Bundle();
            Bundle specialResult = new Bundle();
            commonResult = data.getExtras().getBundle("common");
            specialResult = data.getExtras().getBundle("special");
            if (commonResult != null) {
                common = commonResult.getString("invoice_name");
                mine_invoice_title_tv.setText(common);

            }
            if (specialResult != null){
                special = specialResult.getString("invoice_name");
                mine_invoice_title_tv.setText(special);
            }

        }
    }
}
