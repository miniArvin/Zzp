package com.tryine.zzp.ui.activity.mine.wallet;


import android.view.View;
import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MinePublishCommentAdapter;
import com.tryine.zzp.base.BaseStatusMActivity;

public class MineCouponActivity extends BaseStatusMActivity implements View.OnClickListener {
    private ListView mine_coupon_lv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type = 11;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_coupon;
    }

    @Override
    protected void afterOnCreate() {
        init();
    }

    public void init() {
        mine_coupon_lv = (ListView) findViewById(R.id.mine_coupon_lv);
        minePublishCommentAdapter = new MinePublishCommentAdapter(null, this, type);
        mine_coupon_lv.setAdapter(minePublishCommentAdapter);
        findViewById(R.id.get_coupon_tv).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_coupon_tv:
                startAct(GetCouponActivity.class);
                break;
        }
    }
}
