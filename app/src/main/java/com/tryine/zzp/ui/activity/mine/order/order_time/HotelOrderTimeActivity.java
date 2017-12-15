package com.tryine.zzp.ui.activity.mine.order.order_time;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.NiceDialog;
import com.othershe.nicedialog.ViewConvertListener;
import com.othershe.nicedialog.ViewHolder;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelOrderLinkmanAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.widget.NoScrollListView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Code.REQUEST_CODE;
import static com.tryine.zzp.app.constant.Code.RESULT_CODE;

public class HotelOrderTimeActivity extends BaseStatusMActivity implements View.OnClickListener {
    private String room_id;
    private String hotel_name;
    private TextView view_head_title;
    private String checkDay;
    private String outDay;
    private TextView hotel_order_time_type_tv;
    private TextView hotel_order_time_check_tv;
    private TextView hotel_order_time_out_tv;
    private TextView hotel_order_time_night_tv;
    private TextView hotel_order_time_price_tv;
    private LinearLayout hotel_order_time_pledge_ll;
    private TextView hotel_order_time_pledge_tv;
    private TextView hotel_order_room_count_tv;
    private NoScrollListView hotel_order_linkman_lv;
    private EditText hotel_order_time_phone_et;
    private TextView hotel_order_time_equipment_tv;
    private TextView hotel_order_time_coupon_tv;
    private TextView hotel_order_invoice_tv;
    private TextView hotel_order_time_total_prices_tv;
    private TextView hotel_order_time_pay_tv;
    private HotelOrderLinkmanAdapter hotelOrderLinkmanAdapter;
    private List<String> linkmanName;
    private String roomPrice;
    private int totalPrice;
    private String phone;
    private String roomType;
    private String invoice_name;
    private String tax_code;
    private int invoiceType = 0;
    private String credit_code;
    private String bank;
    private String company_card;
    private String company_tell;
    private String company_address;
    private int sendTyp = 0;
    private String email;
    private String mobile;
    private String province;
    private String city;
    private String county;
    private String address;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hotel_order_time;
    }

    @Override
    protected void afterOnCreate() {
        room_id = getIntent().getStringExtra("room_id");
        hotel_name = getIntent().getStringExtra("hotel_name");
        checkDay = getIntent().getStringExtra("check");
        outDay = getIntent().getStringExtra("out");
        loadMessage();
        initView();
    }

    public void loadData() {
        linkmanName.add("刘辰");
        hotelOrderLinkmanAdapter = new HotelOrderLinkmanAdapter(linkmanName, this);
        hotel_order_linkman_lv.setAdapter(hotelOrderLinkmanAdapter);

    }

    public void initView() {
        linkmanName = new ArrayList<>();
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText(hotel_name);
        hotel_order_time_check_tv = (TextView) findViewById(R.id.hotel_order_time_check_tv);
        hotel_order_time_type_tv = (TextView) findViewById(R.id.hotel_order_time_type_tv);
        hotel_order_time_out_tv = (TextView) findViewById(R.id.hotel_order_time_out_tv);
        hotel_order_time_night_tv = (TextView) findViewById(R.id.hotel_order_time_night_tv);
        hotel_order_time_price_tv = (TextView) findViewById(R.id.hotel_order_time_price_tv);
        hotel_order_time_pledge_tv = (TextView) findViewById(R.id.hotel_order_time_pledge_tv);
        hotel_order_room_count_tv = (TextView) findViewById(R.id.hotel_order_room_count_tv);
        hotel_order_time_phone_et = (EditText) findViewById(R.id.hotel_order_time_phone_et);
        hotel_order_time_equipment_tv = (TextView) findViewById(R.id.hotel_order_time_equipment_tv);
        hotel_order_time_coupon_tv = (TextView) findViewById(R.id.hotel_order_time_coupon_tv);
        hotel_order_invoice_tv = (TextView) findViewById(R.id.hotel_order_invoice_tv);
        hotel_order_time_total_prices_tv = (TextView) findViewById(R.id.hotel_order_time_total_prices_tv);
        findViewById(R.id.hotel_order_time_pay_tv).setOnClickListener(this);
        hotel_order_time_pledge_ll = (LinearLayout) findViewById(R.id.hotel_order_time_pledge_ll);
        hotel_order_linkman_lv = (NoScrollListView) findViewById(R.id.hotel_order_linkman_lv);
        findViewById(R.id.hotel_order_time_linkman_iv).setOnClickListener(this);
        findViewById(R.id.hotel_order_time_phone_iv).setOnClickListener(this);
        findViewById(R.id.hotel_order_time_equipment_iv).setOnClickListener(this);
        findViewById(R.id.hotel_order_time_coupon_iv).setOnClickListener(this);
        findViewById(R.id.hotel_order_invoice_iv).setOnClickListener(this);
        findViewById(R.id.hotel_order_time_price_detail_tv).setOnClickListener(this);
        hotel_order_time_out_tv.setText(outDay);
        hotel_order_time_check_tv.setText(checkDay);
        loadData();
    }

    public void loadMessage() {
        OkHttpUtils
                .post()
                .url(Api.HOTELORDERS)
                .addParams("room_id", room_id)
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
                                JSONObject info = new JSONObject(jsonObject.getString("info"));
                                roomPrice = info.getString("price");
                                totalPrice = Integer.valueOf(info.getString("price")) + Integer.valueOf(info.getString("money"));
                                roomType = info.getString("title");
                                hotel_order_time_type_tv.setText(roomType);
                                hotel_order_time_price_tv.setText("￥" + roomPrice);
                                if (info.getInt("deposit") != 0) {
                                    hotel_order_time_pledge_ll.setVisibility(View.GONE);
                                    hotel_order_time_total_prices_tv.setText("￥" + roomPrice);
                                } else {
                                    hotel_order_time_pledge_tv.setText("￥" + info.getString("money"));
                                    hotel_order_time_total_prices_tv.setText("(含押金):￥" + totalPrice);
                                }
                            } else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
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
            case R.id.hotel_order_time_linkman_iv:
                break;
            case R.id.hotel_order_time_phone_iv:
                break;
            case R.id.hotel_order_time_equipment_iv:
                otherEquipmentDialog();
                break;
            case R.id.hotel_order_time_coupon_iv:
                loadCouponMessage(roomPrice);
                break;
            case R.id.hotel_order_invoice_iv:
                startActForResult(OrderTimeInvoiceActivity.class, REQUEST_CODE);
                break;
            case R.id.hotel_order_time_price_detail_tv:
                costDetailDialog();
                break;
            case R.id.hotel_order_time_pay_tv:
                getInputMessage();
                if (!phone.isEmpty()) {
                    loadCommitOrderMessage();
                } else {
                    ToastUtils.showShort("请输入手机号码！");
                }

                break;
            default:
                break;
        }
    }

    public void otherEquipmentDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.order_time_other_requirement_dialog)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    protected void convertView(ViewHolder viewHolder, BaseNiceDialog baseNiceDialog) {
                        View dialogView = viewHolder.getConvertView();
                    }
                })
                .setOutCancel(true)
                .setShowBottom(true)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());

    }

    public void couponDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.order_time_coupon_dialog)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    protected void convertView(ViewHolder viewHolder, BaseNiceDialog baseNiceDialog) {
                        View dialogView = viewHolder.getConvertView();
                        dialogView.findViewById(R.id.order_time_coupon_dialog_lv);
                    }
                })
                .setOutCancel(true)
                .setShowBottom(true)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }

    public void costDetailDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.order_time_cost_dialog)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    protected void convertView(ViewHolder viewHolder, BaseNiceDialog baseNiceDialog) {
                        View dialogView = viewHolder.getConvertView();
                    }
                })
                .setShowBottom(true)
                .setOutCancel(true)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }

    public void loadCouponMessage(String price) {
        OkHttpUtils
                .post()
                .url(Api.HOTELCOUPON)
                .addParams("price", price)
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

                            } else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                            couponDialog();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void loadCommitOrderMessage() {
        OkHttpUtils
                .post()
                .url(Api.HOTELSUBMITORDER)
                .addParams("room_id", room_id)
                .addParams("stime", checkDay)
                .addParams("ltime", outDay)
                .addParams("num", "2")
                .addParams("realname", "[刘辰,刘辰1,li]")
                .addParams("mobile", phone)
                .addParams("user_pay_fee", "200")
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
                                JSONObject info = new JSONObject(jsonObject.getString("info"));
                                Bundle bundle = new Bundle();
                                bundle.putString("order_id", info.getString("order_id"));
                                bundle.putString("realname", "[刘辰,刘辰1,li]");
                                bundle.putString("stime", checkDay);
                                bundle.putString("ltime", outDay);
                                bundle.putString("num", "2");
                                bundle.putString("phone", phone);
                                bundle.putString("room_price", roomPrice);
                                bundle.putString("room_type", roomType);
                                bundle.putString("hotel_name", hotel_name);
                                startAct(OrderTimeSubmitActivity.class, bundle);
                            } else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void getInputMessage() {
        phone = hotel_order_time_phone_et.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_CODE) {
            setResult(RESULT_CODE);
            Bundle resultBundle = new Bundle();
            resultBundle = data.getExtras().getBundle("invoice");
            if (resultBundle != null) {
                invoice_name = resultBundle.getString("invoice_name");
                tax_code = resultBundle.getString("tax_code");
                boolean invoice_type = resultBundle.getBoolean("invoice_type");
                if (!invoice_type) {
                    credit_code = resultBundle.getString("credit_code");
                    bank = resultBundle.getString("bank");
                    company_card = resultBundle.getString("company_card");
                    company_tell = resultBundle.getString("company_tell");
                    company_address = resultBundle.getString("company_address");
                }
                boolean send_type = resultBundle.getBoolean("send_type");
                if (send_type) {
                    email = resultBundle.getString("email");
                }else {
                    mobile = resultBundle.getString("mobile");
                    province = resultBundle.getString("province");
                    city = resultBundle.getString("city");
                    county = resultBundle.getString("county");
                    address = resultBundle.getString("address");
                }
            } else {

            }
        }
    }
}
