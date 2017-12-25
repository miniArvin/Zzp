package com.tryine.zzp.ui.activity.mine.invoice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Code.RESULT_CODE;

public class CommonInvoiceTemplateActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;
    private TextView view_head_cancel;
    private TextView common_invoice_save_tv;
    private EditText common_invoice_bill_et;
    private EditText common_invoice_tax_et;
    private EditText common_invoice_email_et;
    private EditText common_invoice_name_et;
    private EditText common_invoice_mobile_et;
    private EditText common_invoice_detail_address_et;
    private String bill;
    private String tax;
    private String email;
    private String name;
    private String mobile;
    private String detail_address;
    private String province;
    private String city;
    private String district;
    private int isNull;
    private Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_common_invoice_template;
    }

    @Override
    protected void afterOnCreate() {
        isNull = getIntent().getIntExtra("null", 0);
        initView();
    }

    public void initView() {
        findViewById(R.id.view_head_back).setOnClickListener(this);
        common_invoice_save_tv = (TextView) findViewById(R.id.common_invoice_save_tv);
        common_invoice_save_tv.setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_cancel = (TextView) findViewById(R.id.view_head_cancel);
        common_invoice_mobile_et = (EditText) findViewById(R.id.common_invoice_mobile_et);
        common_invoice_name_et = (EditText) findViewById(R.id.common_invoice_name_et);
        common_invoice_email_et = (EditText) findViewById(R.id.common_invoice_email_et);
        common_invoice_tax_et = (EditText) findViewById(R.id.common_invoice_tax_et);
        common_invoice_bill_et = (EditText) findViewById(R.id.common_invoice_bill_et);
        common_invoice_detail_address_et = (EditText) findViewById(R.id.common_invoice_detail_address_et);
        view_head_cancel.setOnClickListener(this);
        view_head_cancel.setText("编辑");
        if (isNull != 0) {
            view_head_cancel.setVisibility(View.VISIBLE);
            common_invoice_bill_et.setEnabled(false);
            common_invoice_mobile_et.setEnabled(false);
            common_invoice_name_et.setEnabled(false);
            common_invoice_tax_et.setEnabled(false);
            common_invoice_bill_et.setEnabled(false);
            common_invoice_email_et.setEnabled(false);
            common_invoice_detail_address_et.setEnabled(false);
            common_invoice_save_tv.setVisibility(View.GONE);
        } else {

        }
        view_head_title.setText("普通发票");
        bundle = new Bundle();
    }

    public void loadMessage() {
        inputMessage();
        if (bill.isEmpty()) {
            ToastUtils.showShort("请填写发票抬头！");
            return;
        }else {
            bundle.putString("invoice_name",bill);
        }
        if (tax.isEmpty()) {
            ToastUtils.showShort("请填写纳税人识别码！");
            return;
        }else {
            bundle.putString("tax_code",tax);
        }
        if (email.isEmpty()) {
            ToastUtils.showShort("请填写接收邮箱！");
            return;
        }else {
            bundle.putString("email",email);
        }
        if (name.isEmpty()) {
            ToastUtils.showShort("请填写收件人！");
            return;
        }else {
            bundle.putString("name",name);
        }
        if (mobile.isEmpty()) {
            ToastUtils.showShort("请填写手机号码！");
            return;
        }else {
            bundle.putString("mobile",mobile);
        }
        if (detail_address.isEmpty()) {
            ToastUtils.showShort("请填写详细的配送地址");
            return;
        }else {
            bundle.putString("address",detail_address);
        }
        OkHttpUtils
                .post()
                .url(Api.COMMONINVOICE)
                .addParams("invoice_name",bill)
                .addParams("tax_code",tax)
                .addParams("email",email)
                .addParams("name",name)
                .addParams("mobile",mobile)
                .addParams("province","湖南省")
                .addParams("city","长沙市")
                .addParams("district","岳麓区")
                .addParams("address",detail_address)
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

                            if (jsonObject.getInt("status")==330){
                                Intent intent = new Intent();
                                intent.putExtra("common", bundle);
                                setResult(RESULT_CODE,intent);
                                ToastUtils.showShort("保存成功！");
                                finish();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view_head_back:
                finish();
                break;
            case R.id.view_head_cancel:

                break;
            case R.id.common_invoice_save_tv:
                loadMessage();
                break;
        }
    }

    public void inputMessage() {
        bill = common_invoice_bill_et.getText().toString();
        tax = common_invoice_tax_et.getText().toString();
        email = common_invoice_email_et.getText().toString();
        name = common_invoice_name_et.getText().toString();
        mobile = common_invoice_mobile_et.getText().toString();
        detail_address = common_invoice_detail_address_et.getText().toString();
    }
}
