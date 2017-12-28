package com.tryine.zzp.ui.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.tryine.zzp.R;
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

import de.hdodenhof.circleimageview.CircleImageView;

import static com.tryine.zzp.app.constant.Cons.SP_USER_TOKEN;


public class MineFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout mine_order_btn;
    private LinearLayout distribution_center_btn;
    private LinearLayout mine_collect_btn;
    private LinearLayout mine_release_btn;
    private TextView mine_cash_pledge_btn;
    private LinearLayout mine_security_center_ll;
    private LinearLayout invoice_template_btn;
    private LinearLayout release_btn;
    private LinearLayout mine_after_sale_ll;
    private LinearLayout mine_vault_ll;
    private ImageView mine_setting_iv;
    private ImageView mine_messages_iv;
    private String token;
    private CircleImageView mine_img_headimg;


    public MineFragment() {

    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        token= SPUtils.getInstance("spConfig").getString(SP_USER_TOKEN);
        if (token.equals("")||token.isEmpty()){
            startAct(LoginActivity.class);
        }
        init();

    }

    public void init(){
        mine_order_btn= (LinearLayout) mView.findViewById(R.id.mine_order_btn);
        distribution_center_btn= (LinearLayout) mView.findViewById(R.id.distribution_center_btn);
        mine_collect_btn= (LinearLayout) mView.findViewById(R.id.mine_collect_btn);
        mine_release_btn= (LinearLayout) mView.findViewById(R.id.mine_release_btn);
        mine_cash_pledge_btn= (TextView) mView.findViewById(R.id.mine_cash_pledge_btn);
        mine_security_center_ll= (LinearLayout) mView.findViewById(R.id.mine_security_center_ll);
        invoice_template_btn= (LinearLayout) mView.findViewById(R.id.invoice_template_btn);
        release_btn= (LinearLayout) mView.findViewById(R.id.release_btn);
        mine_after_sale_ll= (LinearLayout) mView.findViewById(R.id.mine_after_sale_ll);
        mine_vault_ll= (LinearLayout) mView.findViewById(R.id.mine_vault_ll);
        mine_setting_iv= (ImageView) mView.findViewById(R.id.mine_setting_iv);
        mine_messages_iv= (ImageView) mView.findViewById(R.id.mine_messages_iv);
        mine_img_headimg= (CircleImageView) mView.findViewById(R.id.mine_img_headimg);
        mine_img_headimg.setOnClickListener(this);
        mine_order_btn.setOnClickListener(this);
        mine_collect_btn.setOnClickListener(this);
        distribution_center_btn.setOnClickListener(this);
        mine_release_btn.setOnClickListener(this);
        mine_cash_pledge_btn.setOnClickListener(this);
        mine_security_center_ll.setOnClickListener(this);
        invoice_template_btn.setOnClickListener(this);
        release_btn.setOnClickListener(this);
        mine_after_sale_ll.setOnClickListener(this);
        mine_vault_ll.setOnClickListener(this);
        mine_setting_iv.setOnClickListener(this);
        mine_messages_iv.setOnClickListener(this);
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
}
