package com.tryine.zzp.ui.activity.mine.wallet;


import android.view.View;
import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MineWalletAdapter;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.widget.NoScrollListView;

public class WalletActivity extends BaseStatusMActivity implements View.OnClickListener {
    private NoScrollListView mine_wallet_lv;
    private MineWalletAdapter mineWalletAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_wallet;
    }

    @Override
    protected void afterOnCreate() {
        init();
    }

    public void init(){
        mine_wallet_lv= (NoScrollListView) findViewById(R.id.mine_wallet_lv);
        mineWalletAdapter=new MineWalletAdapter(this);
        mine_wallet_lv.setAdapter(mineWalletAdapter);
        findViewById(R.id.mine_wallet_all_coupon_tv).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_wallet_all_coupon_tv:
                startAct(MineCouponActivity.class);
                break;
        }
    }
}
