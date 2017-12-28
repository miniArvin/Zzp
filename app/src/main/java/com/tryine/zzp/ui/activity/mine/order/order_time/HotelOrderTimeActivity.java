package com.tryine.zzp.ui.activity.mine.order.order_time;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.NiceDialog;
import com.othershe.nicedialog.ViewConvertListener;
import com.othershe.nicedialog.ViewHolder;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelOrderLinkmanAdapter;
import com.tryine.zzp.adapter.HotelOrderRoomCountAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.widget.NoScrollGirdView;
import com.tryine.zzp.widget.NoScrollListView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Code.REQUEST_CODE;
import static com.tryine.zzp.app.constant.Code.RESULT_CODE;
import static com.tryine.zzp.app.constant.Cons.SP_USER_NAME;

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
    private ImageView hotel_order_room_count_iv;
    private HotelOrderLinkmanAdapter hotelOrderLinkmanAdapter;
    private HotelOrderRoomCountAdapter hotelOrderRoomCountAdapter;
    private NoScrollGirdView hotel_order_room_count_gv;
    private List<String> linkmanName;
    private String roomPrice;
    private double totalPrice;
    private String phone;
    private String roomType;
    private int deposit = 1;
    private String bill_name = "";
    private String invoice_name = "";
    private String tax_code = "";
    private int sku;
    private int invoiceType = 0;
    private String credit_code = "";
    private String bank = "";
    private String company_card = "";
    private String company_tell = "";
    private String company_address = "";
    private String sendType = "";
    private String email = "";
    private String name = "";
    private String mobile = "";
    private String province = "";
    private String city = "";
    private String county = "";
    private String address = "";
    private String requirement = "";
    private String note = "";
    private String room = "";
    private String quiet = "";
    private String high = "";
    private String voice = "";
    private boolean isNeed = true;
    private String needStr = "";
    private boolean isCoupon = false;
    private String coupon = "";
    private String user_pay_fee = "";
    private int roomNum = 1;
    private String[] linkmanNames;

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
        linkmanName.add("");
        hotelOrderLinkmanAdapter = new HotelOrderLinkmanAdapter(linkmanName, this);
        hotel_order_linkman_lv.setAdapter(hotelOrderLinkmanAdapter);
        hotelOrderRoomCountAdapter = new HotelOrderRoomCountAdapter(this, sku);
        hotel_order_room_count_gv.setAdapter(hotelOrderRoomCountAdapter);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) hotel_order_room_count_gv.getLayoutParams();
        params.height = 200;
        hotel_order_room_count_gv.setLayoutParams(params);
        hotelOrderRoomCountAdapter.setDefSelect(0);
        hotel_order_room_count_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                hotelOrderRoomCountAdapter.setDefSelect(position);
                hotel_order_room_count_tv.setText(position + 1 + "间");
                int count = Math.abs(position + 1 - linkmanName.size());
                if (linkmanName.size() < position + 1) {
                    for (int i = 0; i < count; i++) {
                        addLinkman();
                    }
                } else if (linkmanName.size() > position + 1) {
                    for (int i = 0; i < count; i++) {
                        delLinkman();
                    }
                }
                roomNum = position + 1;
                hotel_order_room_count_gv.setVisibility(View.GONE);
            }
        });
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
        hotel_order_room_count_gv = (NoScrollGirdView) findViewById(R.id.hotel_order_room_count_gv);
        findViewById(R.id.hotel_order_room_count_rl).setOnClickListener(this);
        hotel_order_room_count_iv = (ImageView) findViewById(R.id.hotel_order_room_count_iv);
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
                                user_pay_fee = info.getString("money");
                                roomType = info.getString("title");
                                hotel_order_time_type_tv.setText(roomType);
                                hotel_order_time_price_tv.setText("￥" + roomPrice);
                                deposit = info.getInt("deposit");
                                if (deposit != 0) {
                                    totalPrice = info.getDouble("price");
                                    hotel_order_time_pledge_ll.setVisibility(View.GONE);
                                    hotel_order_time_total_prices_tv.setText("￥" + totalPrice);
                                } else {
                                    totalPrice = info.getDouble("price") + info.getDouble("money");
                                    hotel_order_time_pledge_tv.setText("￥" + info.getString("money"));
                                    hotel_order_time_total_prices_tv.setText("(含押金):￥" + totalPrice);
                                }
                                sku = info.getInt("sku");
                                loadData();
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
                if (linkmanNames.toString().equals("[]")) {
                    ToastUtils.showShort("请填写入住人姓名！");
                    return;
                }
                if (phone.isEmpty()) {
                    ToastUtils.showShort("请填写手机号码！");
                    return;
                }

                if (isCoupon) {

                } else {
                    loadCommitOrderMessage();
                }
                break;
            case R.id.hotel_order_room_count_rl:
                if (hotel_order_room_count_gv.getVisibility() == View.GONE) {
                    hotel_order_room_count_gv.setVisibility(View.VISIBLE);
                    hotel_order_room_count_iv.setImageResource(R.drawable.order_time_linkman_selected_icon);
                } else {
                    hotel_order_room_count_gv.setVisibility(View.GONE);
                    hotel_order_room_count_iv.setImageResource(R.drawable.more_right_icon);
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
                    protected void convertView(ViewHolder viewHolder, final BaseNiceDialog baseNiceDialog) {
                        View dialogView = viewHolder.getConvertView();
                        final ImageView order_time_requirement_dialog_iv = (ImageView) dialogView.findViewById(R.id.order_time_requirement_dialog_iv);
                        final ImageView order_time_unrequirement_dialog_iv = (ImageView) dialogView.findViewById(R.id.order_time_unrequirement_dialog_iv);
                        final LinearLayout order_time_requirement_dialog_ll = (LinearLayout) dialogView.findViewById(R.id.order_time_requirement_dialog_ll);
                        if (isNeed) {
                            order_time_requirement_dialog_ll.setVisibility(View.VISIBLE);
                            order_time_requirement_dialog_iv.setImageResource(R.drawable.order_time_requirement_dialog_selected_icon);
                            order_time_unrequirement_dialog_iv.setImageResource(R.drawable.order_time_requirement_dialog_unselected_icon);
                        } else {
                            order_time_requirement_dialog_ll.setVisibility(View.GONE);
                            order_time_unrequirement_dialog_iv.setImageResource(R.drawable.order_time_requirement_dialog_selected_icon);
                            order_time_requirement_dialog_iv.setImageResource(R.drawable.order_time_requirement_dialog_unselected_icon);
                        }
                        viewHolder.setOnClickListener(R.id.order_time_requirement_dialog_rl, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (order_time_requirement_dialog_ll.getVisibility() == View.GONE) {
                                    order_time_requirement_dialog_ll.setVisibility(View.VISIBLE);
                                    order_time_requirement_dialog_iv.setImageResource(R.drawable.order_time_requirement_dialog_selected_icon);
                                    order_time_unrequirement_dialog_iv.setImageResource(R.drawable.order_time_requirement_dialog_unselected_icon);
                                    isNeed = true;
                                }
                            }
                        });
                        viewHolder.setOnClickListener(R.id.order_time_unrequirement_dialog_rl, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (order_time_requirement_dialog_ll.getVisibility() == View.VISIBLE) {
                                    order_time_requirement_dialog_ll.setVisibility(View.GONE);
                                    order_time_unrequirement_dialog_iv.setImageResource(R.drawable.order_time_requirement_dialog_selected_icon);
                                    order_time_requirement_dialog_iv.setImageResource(R.drawable.order_time_requirement_dialog_unselected_icon);
                                    isNeed = false;
                                }
                            }
                        });

                        final EditText order_time_requirement_dialog_et = (EditText) dialogView.findViewById(R.id.order_time_requirement_dialog_et);
                        if (!needStr.isEmpty()) {
                            order_time_requirement_dialog_et.setText(needStr);
                        }


                        final TextView order_time_requirement_room_tv = (TextView) dialogView.findViewById(R.id.order_time_requirement_room_tv);
                        final TextView order_time_requirement_quiet_tv = (TextView) dialogView.findViewById(R.id.order_time_requirement_quiet_tv);
                        final TextView order_time_requirement_high_tv = (TextView) dialogView.findViewById(R.id.order_time_requirement_high_tv);
                        final TextView order_time_requirement_voice_tv = (TextView) dialogView.findViewById(R.id.order_time_requirement_voice_tv);

                        if (room.isEmpty()) {
                            order_time_requirement_room_tv.setTextColor(getResources().getColor(R.color.order_cash_pledge_word));
                            order_time_requirement_room_tv.setBackgroundResource(R.drawable.other_requirement_dialog_border_gray);
                        } else {
                            order_time_requirement_room_tv.setTextColor(getResources().getColor(R.color.home_location_btn));
                            order_time_requirement_room_tv.setBackgroundResource(R.drawable.login_bg_look);
                        }

                        if (quiet.isEmpty()) {
                            order_time_requirement_quiet_tv.setTextColor(getResources().getColor(R.color.order_cash_pledge_word));
                            order_time_requirement_quiet_tv.setBackgroundResource(R.drawable.other_requirement_dialog_border_gray);
                        } else {
                            order_time_requirement_quiet_tv.setTextColor(getResources().getColor(R.color.home_location_btn));
                            order_time_requirement_quiet_tv.setBackgroundResource(R.drawable.login_bg_look);
                        }
                        if (high.isEmpty()) {
                            order_time_requirement_high_tv.setTextColor(getResources().getColor(R.color.order_cash_pledge_word));
                            order_time_requirement_high_tv.setBackgroundResource(R.drawable.other_requirement_dialog_border_gray);
                        } else {
                            order_time_requirement_high_tv.setTextColor(getResources().getColor(R.color.home_location_btn));
                            order_time_requirement_high_tv.setBackgroundResource(R.drawable.login_bg_look);
                        }
                        if (voice.isEmpty()) {
                            order_time_requirement_voice_tv.setTextColor(getResources().getColor(R.color.order_cash_pledge_word));
                            order_time_requirement_voice_tv.setBackgroundResource(R.drawable.other_requirement_dialog_border_gray);
                        } else {
                            order_time_requirement_voice_tv.setTextColor(getResources().getColor(R.color.home_location_btn));
                            order_time_requirement_voice_tv.setBackgroundResource(R.drawable.login_bg_look);
                        }
                        viewHolder.setOnClickListener(R.id.order_time_requirement_room_tv, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (room.isEmpty()) {
                                    order_time_requirement_room_tv.setTextColor(getResources().getColor(R.color.home_location_btn));
                                    order_time_requirement_room_tv.setBackgroundResource(R.drawable.login_bg_look);
                                    room = order_time_requirement_room_tv.getText().toString();
                                } else {
                                    order_time_requirement_room_tv.setTextColor(getResources().getColor(R.color.order_cash_pledge_word));
                                    order_time_requirement_room_tv.setBackgroundResource(R.drawable.other_requirement_dialog_border_gray);
                                    room = "";
                                }
                            }
                        });
                        viewHolder.setOnClickListener(R.id.order_time_requirement_quiet_tv, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (quiet.isEmpty()) {
                                    order_time_requirement_quiet_tv.setTextColor(getResources().getColor(R.color.home_location_btn));
                                    order_time_requirement_quiet_tv.setBackgroundResource(R.drawable.login_bg_look);
                                    quiet = order_time_requirement_quiet_tv.getText().toString();
                                } else {
                                    order_time_requirement_quiet_tv.setTextColor(getResources().getColor(R.color.order_cash_pledge_word));
                                    order_time_requirement_quiet_tv.setBackgroundResource(R.drawable.other_requirement_dialog_border_gray);
                                    quiet = "";
                                }
                            }
                        });
                        viewHolder.setOnClickListener(R.id.order_time_requirement_high_tv, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (high.isEmpty()) {
                                    order_time_requirement_high_tv.setTextColor(getResources().getColor(R.color.home_location_btn));
                                    order_time_requirement_high_tv.setBackgroundResource(R.drawable.login_bg_look);
                                    high = order_time_requirement_high_tv.getText().toString();
                                } else {
                                    order_time_requirement_high_tv.setTextColor(getResources().getColor(R.color.order_cash_pledge_word));
                                    order_time_requirement_high_tv.setBackgroundResource(R.drawable.other_requirement_dialog_border_gray);
                                    high = "";
                                }
                            }
                        });
                        viewHolder.setOnClickListener(R.id.order_time_requirement_voice_tv, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (voice.isEmpty()) {
                                    order_time_requirement_voice_tv.setTextColor(getResources().getColor(R.color.home_location_btn));
                                    order_time_requirement_voice_tv.setBackgroundResource(R.drawable.login_bg_look);
                                    voice = order_time_requirement_voice_tv.getText().toString();
                                } else {
                                    order_time_requirement_voice_tv.setTextColor(getResources().getColor(R.color.order_cash_pledge_word));
                                    order_time_requirement_voice_tv.setBackgroundResource(R.drawable.other_requirement_dialog_border_gray);
                                    voice = "";
                                }
                            }
                        });
                        viewHolder.setOnClickListener(R.id.order_time_requirement_result_tv, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                requirement = (!room.isEmpty() ? room : (!quiet.isEmpty() ? quiet : (!high.isEmpty() ? high : (!voice.isEmpty() ? voice : ""))));
                                hotel_order_time_equipment_tv.setText(requirement);
                                needStr = order_time_requirement_dialog_et.getText().toString();
                                baseNiceDialog.dismiss();
                            }
                        });
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

    /**
     * 添加item
     */
    public void addLinkman() {
        hotelOrderLinkmanAdapter.addData("入住人" + linkmanName.size() + "名字");
        hotelOrderLinkmanAdapter.notifyDataSetChanged();
    }

    /**
     * 移除item
     */
    public void delLinkman() {
        hotelOrderLinkmanAdapter.delData();
        hotelOrderLinkmanAdapter.notifyDataSetChanged();
        // 判断是否>1
//        if (linkmanName.size() > 1);
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
        PostFormBuilder object = OkHttpUtils
                .post()
                .url(Api.HOTELSUBMITORDER)
                .addParams("room_id", room_id)
                .addParams("stime", "2017-12-28")
                .addParams("ltime", "2017-12-30")
                .addParams("num", roomNum + "")
                .addParams("phone", phone)
                .addParams("user_pay_fee", user_pay_fee)
                .addParams("demand", requirement)
                .addParams("note", note)
                .addParams("coupon", coupon)
                .addParams("invoice_type", invoiceType + "")
                .addParams("bill_name", bill_name)
                .addParams("invoice_name", invoice_name)
                .addParams("tax_code", tax_code)
                .addParams("credit_code", credit_code)
                .addParams("bank", bank)
                .addParams("company_card", company_card)
                .addParams("company_tell", company_tell)
                .addParams("company_address", company_address)
                .addParams("name", name)
                .addParams("mobile", mobile)
                .addParams("province", province)
                .addParams("city", city)
                .addParams("district", county)
                .addParams("address", address)
                .addParams("send_type", sendType)
                .addParams("email", email);
        for (int i = 0; i < linkmanNames.length; i++) {
            object.addParams("realname[" + i + "]", linkmanNames[i]);
        }
        object.build()
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
        linkmanNames = new String[hotel_order_linkman_lv.getChildCount()];
        phone = hotel_order_time_phone_et.getText().toString();
        for (int i = 0; i < hotel_order_linkman_lv.getChildCount(); i++) {
            LinearLayout layout = (LinearLayout) hotel_order_linkman_lv.getChildAt(i);
            EditText editText = (EditText) layout.findViewById(R.id.hotel_order_linkman_et);
            linkmanNames[i] = editText.getText().toString();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_CODE) {
            setResult(RESULT_CODE);
            Bundle resultBundle = new Bundle();
            bill_name = "平台";
            resultBundle = data.getExtras().getBundle("invoice");
            if (resultBundle != null) {
                invoice_name = resultBundle.getString("invoice_name");
                tax_code = resultBundle.getString("tax_code");
                boolean invoice_type = resultBundle.getBoolean("invoice_type");
                if (!invoice_type) {
                    invoiceType = 2;
                    credit_code = resultBundle.getString("credit_code");
                    bank = resultBundle.getString("bank");
                    company_card = resultBundle.getString("company_card");
                    company_tell = resultBundle.getString("company_tell");
                    company_address = resultBundle.getString("company_address");
                } else {
                    invoiceType = 1;
                }
                boolean send_type = resultBundle.getBoolean("send_type");
                if (send_type) {
                    sendType = "email";
                    email = resultBundle.getString("email");
                } else {
                    sendType = "express";
                    mobile = resultBundle.getString("mobile");
                    name = resultBundle.getString("name");
                    province = resultBundle.getString("province");
                    city = resultBundle.getString("city");
                    county = resultBundle.getString("county");
                    address = resultBundle.getString("address");
                }
            } else {
                invoiceType = 0;
            }
        }
    }
}
