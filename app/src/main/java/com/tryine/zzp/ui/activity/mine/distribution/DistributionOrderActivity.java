package com.tryine.zzp.ui.activity.mine.distribution;


import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MinePublishCommentAdapter;
import com.tryine.zzp.base.BaseStatusMActivity;

public class DistributionOrderActivity extends BaseStatusMActivity {
    private ListView distribution_order_lv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type=7;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_distribution_order;
    }

    @Override
    protected void afterOnCreate() {
        init();
    }

    public void init() {
        distribution_order_lv= (ListView) findViewById(R.id.distribution_order_lv);
        minePublishCommentAdapter=new MinePublishCommentAdapter(null,this,type);
        distribution_order_lv.setAdapter(minePublishCommentAdapter);

    }
}
