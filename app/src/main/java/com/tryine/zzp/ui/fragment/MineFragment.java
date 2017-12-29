package com.tryine.zzp.ui.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.ui.activity.login.LoginActivity;
import com.tryine.zzp.ui.activity.mine.CashPledgeActivity;
import com.tryine.zzp.ui.activity.mine.message.AccountMessageActivity;
import com.tryine.zzp.ui.activity.mine.message.MessageActivity;
import com.tryine.zzp.ui.activity.mine.securityCenter.SecurityCenterActivity;
import com.tryine.zzp.ui.activity.mine.afterSale.AfterSaleAllOrderActivity;
import com.tryine.zzp.ui.activity.mine.collect.MyCollectActivity;
import com.tryine.zzp.ui.activity.mine.distribution.DistributionCenterActivity;
import com.tryine.zzp.ui.activity.mine.invoice.InvoiceTemplateActivity;
import com.tryine.zzp.ui.activity.mine.message.SettingActivity;
import com.tryine.zzp.ui.activity.mine.order.AllOrderActivity;
import com.tryine.zzp.ui.activity.mine.publish.MyPublishActivity;
import com.tryine.zzp.ui.activity.mine.release.MyReleaseActivity;
import com.tryine.zzp.ui.activity.mine.wallet.WalletActivity;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.utils.UrlUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Cons.SP_USER_LOGIN;
import static com.tryine.zzp.app.constant.Cons.SP_USER_TOKEN;


public class MineFragment extends BaseFragment implements View.OnClickListener {
    private TextView mine_cash_pledge_btn;

    private CircleImageView mine_img_headimg;
    private ImageView mine_member_iv;
    private TextView mine_name_tv;
    private TextView mine_member_tv;
    private TextView mine_money_tv;
    private TextView mine_coupon_tv;
    private TextView mine_day_money_tv;

    public MineFragment() {

    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        loadMessage();
        initView();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void initView(){
        mView.findViewById(R.id.mine_order_btn).setOnClickListener(this);
        mView.findViewById(R.id.distribution_center_btn).setOnClickListener(this);
        mView.findViewById(R.id.mine_collect_btn).setOnClickListener(this);
        mView.findViewById(R.id.mine_release_btn).setOnClickListener(this);
        mine_cash_pledge_btn= (TextView) mView.findViewById(R.id.mine_cash_pledge_btn);
        mView.findViewById(R.id.mine_security_center_ll).setOnClickListener(this);
        mView.findViewById(R.id.invoice_template_btn).setOnClickListener(this);
        mView.findViewById(R.id.release_btn).setOnClickListener(this);
        mView.findViewById(R.id.mine_after_sale_ll).setOnClickListener(this);
        mView.findViewById(R.id.mine_vault_ll).setOnClickListener(this);
        mView.findViewById(R.id.mine_setting_iv).setOnClickListener(this);
        mView.findViewById(R.id.mine_messages_iv).setOnClickListener(this);
        mine_img_headimg= (CircleImageView) mView.findViewById(R.id.mine_img_headimg);
        mine_img_headimg.setOnClickListener(this);
        mine_cash_pledge_btn.setOnClickListener(this);
        mine_member_iv = (ImageView) mView.findViewById(R.id.mine_member_iv);
        mine_name_tv= (TextView) mView.findViewById(R.id.mine_name_tv);
        mine_member_tv= (TextView) mView.findViewById(R.id.mine_member_tv);
        mine_money_tv= (TextView) mView.findViewById(R.id.mine_money_tv);
        mine_coupon_tv= (TextView) mView.findViewById(R.id.mine_coupon_tv);
        mine_day_money_tv= (TextView) mView.findViewById(R.id.mine_day_money_tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_collect_btn:
                startAct(MyCollectActivity.class);
                break;
            case R.id.mine_order_btn:
                startAct(AllOrderActivity.class);
                break;
            case R.id.mine_release_btn:
                startAct(MyPublishActivity.class);
                break;
            case R.id.distribution_center_btn:
                startAct(DistributionCenterActivity.class);
                break;
            case R.id.mine_cash_pledge_btn:
                startAct(CashPledgeActivity.class);
//                BottomDialog.create(getFragmentManager())
//                        .setCancelOutside(false)
//                        .setViewListener(new BottomDialog.ViewListener() {
//                            @Override
//                            public void bindView(View v) {
//
//                            }
//                        })
//                        .setLayoutRes(R.layout.cash_plegde_dialog)
//                        .show();
                break;
            case R.id.mine_security_center_ll:
                startAct(SecurityCenterActivity.class);
                break;
            case R.id.invoice_template_btn:
                startAct(InvoiceTemplateActivity.class);
                break;
            case R.id.release_btn:
                startAct(MyReleaseActivity.class);
                break;
            case R.id.mine_after_sale_ll:
                startAct(AfterSaleAllOrderActivity.class);
                break;
            case R.id.mine_vault_ll:
                startAct(WalletActivity.class);
                break;
            case R.id.mine_setting_iv:
                startAct(SettingActivity.class);
                break;
            case R.id.mine_messages_iv:
                startAct(MessageActivity.class);
                break;
            case R.id.mine_img_headimg:
                startAct(AccountMessageActivity.class);
                break;
            default:
                break;
        }
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.PERSONAL)
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
                                JSONObject info = new JSONObject(jsonObject.getString("info"));
                                Glide.with(mContext).load(UrlUtils.getUrl(info.getString("face"))).placeholder(R.drawable.mine_head_icon).into(mine_img_headimg);
                                Glide.with(mContext).load(UrlUtils.getUrl(info.getString("icon"))).asBitmap().into(mine_member_iv);
                                mine_name_tv.setText(info.getString("nickname"));
                                mine_member_tv.setText(info.getString("rank_name"));
                            }else if (jsonObject.getInt("status")==203){
                                startAct(LoginActivity.class);
                            }else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
