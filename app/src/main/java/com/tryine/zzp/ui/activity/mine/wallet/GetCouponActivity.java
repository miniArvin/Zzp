package com.tryine.zzp.ui.activity.mine.wallet;


import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MinePublishCommentAdapter;
import com.tryine.zzp.base.BaseStatusMActivity;

public class GetCouponActivity extends BaseStatusMActivity {
    private ListView get_coupon_lv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type=13;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_get_coupon;
    }

    @Override
    protected void afterOnCreate() {
        initView();
    }

    public void initView(){
        get_coupon_lv= (ListView) findViewById(R.id.get_coupon_lv);
        minePublishCommentAdapter=new MinePublishCommentAdapter(null,this,type);
        get_coupon_lv.setAdapter(minePublishCommentAdapter);
    }
}
