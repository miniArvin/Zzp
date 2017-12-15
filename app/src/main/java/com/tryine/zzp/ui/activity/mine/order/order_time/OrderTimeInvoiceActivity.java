package com.tryine.zzp.ui.activity.mine.order.order_time;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.widget.AddressPickTask;
import com.tryine.zzp.widget.SwitchButton;

import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;

import static com.tryine.zzp.app.constant.Code.RESULT_CODE;

public class OrderTimeInvoiceActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;
    private TextView view_head_cancel;
    private TextView order_time_invoice_common_tv;
    private TextView order_time_invoice_VAT_tv;
    private TextView order_time_invoice_e_tv;
    private TextView order_time_invoice_p_tv;
    private ImageView order_time_invoice_common_iv;
    private ImageView order_time_invoice_e_iv;
    private ImageView order_time_invoice_VAT_iv;
    private ImageView order_time_invoice_p_iv;
    private EditText order_time_invoice_title_et;
    private EditText order_time_invoice_TRN_et;
    private EditText order_time_invoice_USCC_et;
    private EditText order_time_invoice_opening_bank_et;
    private EditText order_time_invoice_opening_account_et;
    private EditText order_time_invoice_tell_et;
    private EditText order_time_invoice_address_et;
    private EditText order_time_invoice_recipients_et;
    private EditText order_time_invoice_phone_et;
    private EditText order_time_invoice_detail_address_et;
    private EditText order_time_invoice_mail_et;
    private LinearLayout order_time_invoice_VAT_ll;
    private LinearLayout order_time_invoice_p_ll;
    private LinearLayout order_time_invoice_mail_ll;
    private LinearLayout order_time_invoice_p_btn;
    private LinearLayout order_time_invoice_e_btn;
    private LinearLayout order_time_invoice_is_need_ll;
    private SwitchButton hotel_order_invoice_need_invoice_btn;
    private TextView order_time_invoice_province_tv;
    private TextView order_time_invoice_city_tv;
    private TextView order_time_invoice_county_tv;
    private String invoice_title;
    private String invoiceTRN;
    private String invoiceUSCC;
    private String invoiceOB;
    private String invoiceOA;
    private String invoice_tell;
    private String invoice_recipients;
    private String invoice_phone;
    private String invoice_detail_address;
    private String invoice_mail;
    private String invoice_address;
    private String invoice_province;
    private String invoice_city;
    private String invoice_county;
    private boolean isCommon=true;
    private boolean isMail=true;
    private boolean isNeed=true;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_time_invoice;
    }

    @Override
    protected void afterOnCreate() {
        initView();
    }

    public void loadData() {
        hotel_order_invoice_need_invoice_btn.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                isNeed = isChecked;
                if (!isChecked) {
                    order_time_invoice_is_need_ll.setVisibility(View.GONE);
                } else {
                    order_time_invoice_is_need_ll.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void loadMessage() {

    }

    public void initView() {
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("发票");
        view_head_cancel = (TextView) findViewById(R.id.view_head_cancel);
        view_head_cancel.setText("确定");
        view_head_cancel.setOnClickListener(this);
        findViewById(R.id.order_time_invoice_VAT_btn).setOnClickListener(this);
        findViewById(R.id.order_time_invoice_common_btn).setOnClickListener(this);
        findViewById(R.id.order_time_invoice_e_btn).setOnClickListener(this);
        findViewById(R.id.order_time_invoice_p_btn).setOnClickListener(this);
        findViewById(R.id.order_time_invoice_address_select_ll).setOnClickListener(this);
        order_time_invoice_title_et = (EditText) findViewById(R.id.order_time_invoice_title_et);
        order_time_invoice_TRN_et = (EditText) findViewById(R.id.order_time_invoice_TRN_et);
        order_time_invoice_USCC_et = (EditText) findViewById(R.id.order_time_invoice_USCC_et);
        order_time_invoice_opening_bank_et = (EditText) findViewById(R.id.order_time_invoice_opening_bank_et);
        order_time_invoice_opening_account_et = (EditText) findViewById(R.id.order_time_invoice_opening_account_et);
        order_time_invoice_tell_et = (EditText) findViewById(R.id.order_time_invoice_tell_et);
        order_time_invoice_address_et = (EditText) findViewById(R.id.order_time_invoice_address_et);
        order_time_invoice_recipients_et = (EditText) findViewById(R.id.order_time_invoice_recipients_et);
        order_time_invoice_phone_et = (EditText) findViewById(R.id.order_time_invoice_phone_et);
        order_time_invoice_detail_address_et = (EditText) findViewById(R.id.order_time_invoice_detail_address_et);
        order_time_invoice_mail_et = (EditText) findViewById(R.id.order_time_invoice_mail_et);
        order_time_invoice_VAT_ll = (LinearLayout) findViewById(R.id.order_time_invoice_VAT_ll);
        order_time_invoice_p_ll = (LinearLayout) findViewById(R.id.order_time_invoice_p_ll);
        order_time_invoice_mail_ll = (LinearLayout) findViewById(R.id.order_time_invoice_mail_ll);
        order_time_invoice_common_tv = (TextView) findViewById(R.id.order_time_invoice_common_tv);
        order_time_invoice_VAT_tv = (TextView) findViewById(R.id.order_time_invoice_VAT_tv);
        order_time_invoice_VAT_iv = (ImageView) findViewById(R.id.order_time_invoice_VAT_iv);
        order_time_invoice_common_iv = (ImageView) findViewById(R.id.order_time_invoice_common_iv);
        order_time_invoice_p_btn = (LinearLayout) findViewById(R.id.order_time_invoice_p_btn);
        order_time_invoice_e_btn = (LinearLayout) findViewById(R.id.order_time_invoice_e_btn);
        order_time_invoice_is_need_ll = (LinearLayout) findViewById(R.id.order_time_invoice_is_need_ll);
        order_time_invoice_p_btn.setOnClickListener(this);
        order_time_invoice_e_btn.setOnClickListener(this);
        order_time_invoice_p_iv = (ImageView) findViewById(R.id.order_time_invoice_p_iv);
        order_time_invoice_p_tv = (TextView) findViewById(R.id.order_time_invoice_p_tv);
        order_time_invoice_e_tv = (TextView) findViewById(R.id.order_time_invoice_e_tv);
        order_time_invoice_e_iv = (ImageView) findViewById(R.id.order_time_invoice_e_iv);
        hotel_order_invoice_need_invoice_btn = (SwitchButton) findViewById(R.id.hotel_order_invoice_need_invoice_btn);
        order_time_invoice_province_tv = (TextView) findViewById(R.id.order_time_invoice_province_tv);
        order_time_invoice_city_tv = (TextView) findViewById(R.id.order_time_invoice_city_tv);
        order_time_invoice_county_tv = (TextView) findViewById(R.id.order_time_invoice_county_tv);
        loadData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view_head_back:
                finish();
                break;
            case R.id.view_head_cancel:
                Bundle bundle = new Bundle();
                if (isNeed) {
                    getInputMessage();
                    if (invoice_title.isEmpty()) {
                        ToastUtils.showShort("请填写发票抬头！");
                        return;
                    } else {
                        bundle.putString("invoice_name", invoice_title);
                    }
                    if (invoiceTRN.isEmpty()) {
                        ToastUtils.showShort("请填写纳税人识别码！");
                        return;
                    } else {
                        bundle.putString("tax_code", invoiceTRN);
                    }
                    if (!isCommon) {
                        bundle.putBoolean("invoice_type",false);
                        if (invoiceUSCC.isEmpty()) {
                            ToastUtils.showShort("请填写社会信用代码！");
                            return;
                        } else {
                            bundle.putString("credit_code", invoiceUSCC);
                        }
                        if (invoiceOB.isEmpty()) {
                            ToastUtils.showShort("请填写开户行！");
                            return;
                        } else {
                            bundle.putString("bank", invoiceOB);
                        }
                        if (invoiceOA.isEmpty()) {
                            ToastUtils.showShort("请填写开户行账号！");
                            return;
                        } else {
                            bundle.putString("company_card", invoiceOA);
                        }
                        if (invoice_tell.isEmpty()) {
                            ToastUtils.showShort("请填写公司电话！");
                            return;
                        } else {
                            bundle.putString("company_tell", invoice_tell);
                        }
                        if (invoice_address.isEmpty()) {
                            ToastUtils.showShort("请填写公司地址！");
                            return;
                        } else {
                            bundle.putString("company_address", invoice_address);
                        }
                    }else {
                        bundle.putBoolean("invoice_type",true);
                    }
                    if (isMail) {
                        bundle.putBoolean("send_type",true);
                        if (invoice_mail.isEmpty()) {
                            ToastUtils.showShort("请填写电子邮箱！");
                            return;
                        } else {
                            bundle.putString("email", invoice_mail);
                        }
                    } else {
                        bundle.putBoolean("send_type",false);
                        if (invoice_recipients.isEmpty()) {
                            ToastUtils.showShort("请填写收件人名字！");
                            return;
                        } else {
                            bundle.putString("name", invoice_recipients);
                        }
                        if (invoice_phone.isEmpty()) {
                            ToastUtils.showShort("请填写手机号码！");
                            return;
                        } else {
                            bundle.putString("mobile", invoice_phone);
                        }
                        if (invoice_province.isEmpty()){
                            ToastUtils.showShort("请填写配送地址！");
                            return;
                        }else {
                            bundle.putString("province",invoice_province);
                            bundle.putString("city",invoice_city);
                            bundle.putString("county",invoice_county);
                        }
                        if (invoice_detail_address.isEmpty()) {
                            ToastUtils.showShort("请填写详细地址！");
                            return;
                        } else {
                            bundle.putString("address", invoice_detail_address);
                        }
                    }

                    setInputMessage(bundle);
                }else {
                    finish();
                }
                break;
            case R.id.order_time_invoice_common_btn:
                if (order_time_invoice_VAT_ll.getVisibility() == View.VISIBLE) {
                    order_time_invoice_VAT_ll.setVisibility(View.GONE);
                    order_time_invoice_common_iv.setImageResource(R.drawable.mine_collect_selected_icon);
                    order_time_invoice_VAT_iv.setImageResource(R.drawable.mine_collect_unselected_icon);
                    order_time_invoice_common_tv.setTextColor(getResources().getColor(R.color.order_title_word));
                    order_time_invoice_VAT_tv.setTextColor(getResources().getColor(R.color.home_location_word));
                    isCommon = true;
                }
                break;
            case R.id.order_time_invoice_VAT_btn:
                if (order_time_invoice_VAT_ll.getVisibility() == View.GONE) {
                    order_time_invoice_VAT_ll.setVisibility(View.VISIBLE);
                    order_time_invoice_common_iv.setImageDrawable(getResources().getDrawable(R.drawable.mine_collect_unselected_icon));
                    order_time_invoice_VAT_iv.setImageDrawable(getResources().getDrawable(R.drawable.mine_collect_selected_icon));
                    order_time_invoice_VAT_tv.setTextColor(getResources().getColor(R.color.order_title_word));
                    order_time_invoice_common_tv.setTextColor(getResources().getColor(R.color.home_location_word));
                    isCommon = false;
                }
                break;
            case R.id.order_time_invoice_p_btn:
                if (order_time_invoice_p_ll.getVisibility() == View.GONE) {
                    order_time_invoice_p_ll.setVisibility(View.VISIBLE);
                    order_time_invoice_mail_ll.setVisibility(View.GONE);
                    order_time_invoice_p_iv.setImageDrawable(getResources().getDrawable(R.drawable.mine_collect_selected_icon));
                    order_time_invoice_p_tv.setTextColor(getResources().getColor(R.color.order_title_word));
                    order_time_invoice_e_iv.setImageDrawable(getResources().getDrawable(R.drawable.mine_collect_unselected_icon));
                    order_time_invoice_e_tv.setTextColor(getResources().getColor(R.color.home_location_word));
                    order_time_invoice_p_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_bg_look));
                    order_time_invoice_e_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.hotel_detail_item_man_fang_bg_btn));
                    isMail = false;
                }
                break;
            case R.id.order_time_invoice_e_btn:
                if (order_time_invoice_mail_ll.getVisibility() == View.GONE) {
                    order_time_invoice_mail_ll.setVisibility(View.VISIBLE);
                    order_time_invoice_p_ll.setVisibility(View.GONE);
                    order_time_invoice_e_iv.setImageDrawable(getResources().getDrawable(R.drawable.mine_collect_selected_icon));
                    order_time_invoice_e_tv.setTextColor(getResources().getColor(R.color.order_title_word));
                    order_time_invoice_p_iv.setImageDrawable(getResources().getDrawable(R.drawable.mine_collect_unselected_icon));
                    order_time_invoice_p_tv.setTextColor(getResources().getColor(R.color.home_location_word));
                    order_time_invoice_e_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_bg_look));
                    order_time_invoice_p_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.hotel_detail_item_man_fang_bg_btn));
                    isMail = true;
                }
                break;
            case R.id.hotel_order_invoice_need_invoice_btn:
                break;
            case R.id.order_time_invoice_address_select_ll:
                addressSelect();
                break;

        }
    }

    public void getInputMessage() {
        invoice_title = order_time_invoice_title_et.getText().toString();
        invoiceTRN = order_time_invoice_TRN_et.getText().toString();
        if (!isCommon) {
            invoiceUSCC = order_time_invoice_USCC_et.getText().toString();
            invoiceOA = order_time_invoice_opening_account_et.getText().toString();
            invoiceOB = order_time_invoice_opening_bank_et.getText().toString();
            invoice_tell = order_time_invoice_tell_et.getText().toString();
            invoice_address = order_time_invoice_address_et.getText().toString();
        }
        if (isMail) {
            invoice_mail = order_time_invoice_mail_et.getText().toString();
        } else {
            invoice_recipients = order_time_invoice_recipients_et.getText().toString();
            invoice_phone = order_time_invoice_phone_et.getText().toString();
            invoice_detail_address = order_time_invoice_detail_address_et.getText().toString();
        }
    }

    public void setInputMessage(Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtra("invoice", bundle);
        setResult(RESULT_CODE, intent);
        finish();
    }

    public void addressSelect(){
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
                invoice_province=province.getAreaName();
                invoice_city=city.getAreaName();
                invoice_county=county.getAreaName();
//                if (county == null) {
//                    ToastUtils.showShort(province.getAreaName() + city.getAreaName());
//                    order_time_invoice_province_tv.setText(invoice_province);
//                    order_time_invoice_city_tv.setText(invoice_city);
//                    order_time_invoice_county_tv.setText("");
//                    if (order_time_invoice_county_tv.getVisibility()==View.VISIBLE)
//                    order_time_invoice_county_tv.setVisibility(View.GONE);
//                } else {
//                    ToastUtils.showShort(province.getAreaName() + city.getAreaName() + county.getAreaName());
                    order_time_invoice_province_tv.setText(invoice_province);
                    order_time_invoice_city_tv.setText(invoice_city);
                    order_time_invoice_county_tv.setText(invoice_county);
//                    if (order_time_invoice_county_tv.getVisibility()==View.GONE)
//                        order_time_invoice_county_tv.setVisibility(View.VISIBLE);
//                }
            }
        });
        task.execute("湖南", "长沙", "岳麓");
    }
}
