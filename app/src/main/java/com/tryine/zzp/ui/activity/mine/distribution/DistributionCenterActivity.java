package com.tryine.zzp.ui.activity.mine.distribution;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.DistributionCenterAdapter;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.widget.NoScrollListView;

public class DistributionCenterActivity extends BaseStatusMActivity implements View.OnClickListener {

    private NoScrollListView distribution_center_lv;
    private DistributionCenterAdapter distributionCenterAdapter;
    private TextView distribution_center_all_order_tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_distribution_center;
    }

    @Override
    protected void afterOnCreate() {
        init();
    }

    public void init(){
        distribution_center_lv= (NoScrollListView) findViewById(R.id.distribution_center_lv);
        distributionCenterAdapter=new DistributionCenterAdapter(getApplicationContext());
        distribution_center_lv.setAdapter(distributionCenterAdapter);
        distribution_center_all_order_tv= (TextView) findViewById(R.id.distribution_center_all_order_tv);
        distribution_center_all_order_tv.setOnClickListener(this);
        findViewById(R.id.distribution_center_member_ll).setOnClickListener(this);
        findViewById(R.id.distribution_center_commission_ll).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.distribution_center_all_order_tv:
                startAct(DistributionOrderActivity.class);
                break;
            case R.id.distribution_center_commission_ll:
                startAct(CommissionManageActivity.class);
                break;
            case R.id.distribution_center_member_ll:
                startAct(MineMemberActivity.class);
                break;
        }
    }
}
