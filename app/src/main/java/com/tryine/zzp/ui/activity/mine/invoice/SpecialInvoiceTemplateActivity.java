package com.tryine.zzp.ui.activity.mine.invoice;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.widget.AddressPickTask;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;
import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Code.RESULT_CODE;

public class SpecialInvoiceTemplateActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;
    private TextView view_head_cancel;
    private TextView common_invoice_save_tv;
    private EditText common_invoice_bill_et;
    private EditText common_invoice_tax_et;
    private EditText common_invoice_credit_et;
    private EditText common_invoice_bank_et;
    private EditText common_invoice_card_et;
    private EditText common_invoice_email_et;
    private EditText common_invoice_tell_et;
    private EditText common_invoice_address_et;
    private EditText common_invoice_name_et;
    private EditText common_invoice_mobile_et;
    private EditText common_invoice_detail_address_et;
    private TextView common_invoice_province_tv;
    private TextView common_invoice_city_tv;
    private TextView common_invoice_district_tv;
    private LinearLayout common_invoice_address_ll;
    private String bill;
    private String tax;
    private String credit;
    private String bank;
    private String card;
    private String tell;
    private String company_address;
    private String email;
    private String name;
    private String mobile;
    private String detail_address;
    private String add_province;
    private String add_city;
    private String add_district;
    private int isNull;
    private Bundle bundle;
    private boolean isEdit = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_special_invoice_template;
    }

    @Override
    protected void afterOnCreate() {
        isNull = getIntent().getIntExtra("nulls", 0);
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
        common_invoice_credit_et = (EditText) findViewById(R.id.common_invoice_credit_et);
        common_invoice_bank_et = (EditText) findViewById(R.id.common_invoice_bank_et);
        common_invoice_card_et = (EditText) findViewById(R.id.common_invoice_card_et);
        common_invoice_tell_et = (EditText) findViewById(R.id.common_invoice_tell_et);
        common_invoice_address_et = (EditText) findViewById(R.id.common_invoice_address_et);
        common_invoice_email_et = (EditText) findViewById(R.id.common_invoice_email_et);
        common_invoice_tax_et = (EditText) findViewById(R.id.common_invoice_tax_et);
        common_invoice_bill_et = (EditText) findViewById(R.id.common_invoice_bill_et);
        common_invoice_detail_address_et = (EditText) findViewById(R.id.common_invoice_detail_address_et);
        common_invoice_district_tv = (TextView) findViewById(R.id.common_invoice_district_tv);
        common_invoice_province_tv = (TextView) findViewById(R.id.common_invoice_province_tv);
        common_invoice_city_tv = (TextView) findViewById(R.id.common_invoice_city_tv);
        common_invoice_address_ll = (LinearLayout) findViewById(R.id.common_invoice_address_ll);
        findViewById(R.id.common_invoice_address_ll).setOnClickListener(this);
        view_head_cancel.setOnClickListener(this);
        view_head_cancel.setText("编辑");
        if (isNull != 0) {
            bill = getIntent().getStringExtra("special");
            tax = getIntent().getStringExtra("tax_codes");
            email = getIntent().getStringExtra("emails");
            name = getIntent().getStringExtra("names");
            mobile = getIntent().getStringExtra("mobiles");
            add_province = getIntent().getStringExtra("provinces");
            add_city = getIntent().getStringExtra("citys");
            add_district = getIntent().getStringExtra("districts");
            detail_address = getIntent().getStringExtra("addresss");
            credit = getIntent().getStringExtra("credits");
            card = getIntent().getStringExtra("cards");
            bank = getIntent().getStringExtra("banks");
            tell = getIntent().getStringExtra("tells");
            company_address = getIntent().getStringExtra("company_addresss");
            view_head_cancel.setVisibility(View.VISIBLE);
            common_invoice_bill_et.setEnabled(false);
            common_invoice_mobile_et.setEnabled(false);
            common_invoice_name_et.setEnabled(false);
            common_invoice_tax_et.setEnabled(false);
            common_invoice_bill_et.setEnabled(false);
            common_invoice_email_et.setEnabled(false);
            common_invoice_detail_address_et.setEnabled(false);
            common_invoice_address_ll.setEnabled(false);
            common_invoice_credit_et.setEnabled(false);
            common_invoice_bank_et.setEnabled(false);
            common_invoice_card_et.setEnabled(false);
            common_invoice_tell_et.setEnabled(false);
            common_invoice_address_et.setEnabled(false);
            common_invoice_save_tv.setVisibility(View.GONE);
            common_invoice_bill_et.setText(bill);
            common_invoice_tax_et.setText(tax);
            common_invoice_email_et.setText(email);
            common_invoice_name_et.setText(name);
            common_invoice_mobile_et.setText(mobile);
            common_invoice_detail_address_et.setText(detail_address);
            common_invoice_province_tv.setText(add_province);
            common_invoice_city_tv.setText(add_city);
            common_invoice_district_tv.setText(add_district);
            common_invoice_credit_et.setText(credit);
            common_invoice_bank_et.setText(bank);
            common_invoice_card_et.setText(card);
            common_invoice_tell_et.setText(tell);
            common_invoice_address_et.setText(company_address);
        }
        view_head_title.setText("普通发票");
        bundle = new Bundle();
    }

    public void loadMessage() {
        inputMessage();
        if (bill.isEmpty()) {
            ToastUtils.showShort("请填写发票抬头！");
            return;
        } else {
            bundle.putString("invoice_name", bill);
        }
        if (tax.isEmpty()) {
            ToastUtils.showShort("请填写纳税人识别码！");
            return;
        } else {
            bundle.putString("tax_code", tax);
        }
        if (credit.isEmpty()) {
            ToastUtils.showShort("请填写统一社会信用代码！");
            return;
        } else {
            bundle.putString("credit", credit);
        }
        if (credit.isEmpty()) {
            ToastUtils.showShort("请填写统一社会信用代码！");
            return;
        } else {
            bundle.putString("credit", credit);
        }
        if (RegexUtils.isEmail(email)) {
            ToastUtils.showShort("请填写正确的接收邮箱！");
            return;
        } else {
            bundle.putString("email", email);
        }
        if (RegexUtils.isTel(tell)) {
            ToastUtils.showShort("请填写正确的公司电话！");
            return;
        } else {
            bundle.putString("tell", tell);
        }
        if (company_address.isEmpty()) {
            ToastUtils.showShort("请填写公司地址！");
            return;
        } else {
            bundle.putString("company_address", company_address);
        }
        if (name.isEmpty()) {
            ToastUtils.showShort("请填写收件人！");
            return;
        } else {
            bundle.putString("name", name);
        }
        if (RegexUtils.isMobileExact(mobile)) {
            ToastUtils.showShort("请填写正确的手机号码！");
            return;
        } else {
            bundle.putString("mobile", mobile);
        }
        if (detail_address.isEmpty()) {
            ToastUtils.showShort("请填写详细的配送地址");
            return;
        } else {
            bundle.putString("address", detail_address);
        }

        bundle.putString("bank",bank);
        bundle.putString("card",card);
        OkHttpUtils
                .post()
                .url(Api.SPECIALINVOICE)
                .addParams("invoice_name", bill)
                .addParams("tax_code", tax)
                .addParams("credit_code", credit)
                .addParams("bank", bank)
                .addParams("company_card", card)
                .addParams("company_tell", tell)
                .addParams("company_address", company_address)
                .addParams("email", email)
                .addParams("name", name)
                .addParams("mobile", mobile)
                .addParams("province", add_province)
                .addParams("city", add_city)
                .addParams("district", add_district)
                .addParams("address", detail_address)
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

                            if (jsonObject.getInt("status") == 330) {
                                Intent intent = new Intent();
                                intent.putExtra("special", bundle);
                                setResult(RESULT_CODE, intent);
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
                if (!isEdit) {
                    isEdit = true;
                    common_invoice_bill_et.setEnabled(true);
                    common_invoice_mobile_et.setEnabled(true);
                    common_invoice_name_et.setEnabled(true);
                    common_invoice_tax_et.setEnabled(true);
                    common_invoice_bill_et.setEnabled(true);
                    common_invoice_email_et.setEnabled(true);
                    common_invoice_detail_address_et.setEnabled(true);
                    common_invoice_address_ll.setEnabled(true);
                    common_invoice_credit_et.setEnabled(true);
                    common_invoice_bank_et.setEnabled(true);
                    common_invoice_card_et.setEnabled(true);
                    common_invoice_tell_et.setEnabled(true);
                    common_invoice_address_et.setEnabled(true);
                    common_invoice_save_tv.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.common_invoice_save_tv:
                loadMessage();
                break;
            case R.id.common_invoice_address_ll:
                addressSelect();
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
        credit = common_invoice_credit_et.getText().toString();
        card = common_invoice_card_et.getText().toString();
        bank = common_invoice_bank_et.getText().toString();
        tell = common_invoice_tell_et.getText().toString();
        company_address = common_invoice_address_et.getText().toString();
    }

    public void addressSelect() {
        AddressPickTask task = new AddressPickTask(this);
        task.setHideProvince(false);
        task.setHideCounty(false);
        task.setCallback(new AddressPickTask.Callback() {
            @Override
            public void onAddressInitFailed() {
                ToastUtils.showShort("数据初始化失败");
            }

            @Override
            public void onAddressPicked(Province province, City city, County county) {
                add_province = province.getAreaName();
                add_city = city.getAreaName();
                add_district = county.getAreaName();
                common_invoice_province_tv.setText(add_province);
                common_invoice_city_tv.setText(add_city);
                common_invoice_district_tv.setText(add_district);
            }
        });
        if (isNull != 0) {
            task.execute(add_province, add_city, add_district);
        } else {
            task.execute("湖南", "长沙", "岳麓");
        }

    }
}
