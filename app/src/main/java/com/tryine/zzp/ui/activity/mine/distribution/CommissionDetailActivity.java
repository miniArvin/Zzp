package com.tryine.zzp.ui.activity.mine.distribution;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MinePublishCommentAdapter;
import com.tryine.zzp.base.BaseStatusMActivity;

public class CommissionDetailActivity extends BaseStatusMActivity {
    private ListView commission_detail_lv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type=7;
    private LinearLayout commission_detail_income_ll;
    private LinearLayout commission_detail_expend_ll;
    private TextView commission_detail_income_tv;
    private View commission_detail_income_v;
    private TextView commission_detail_expend_tv;
    private View commission_detail_expend_v;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_commission_detail;
    }

    @Override
    protected void afterOnCreate() {
        init();
    }

    public void init(){
        commission_detail_lv= (ListView) findViewById(R.id.commission_detail_lv);
        minePublishCommentAdapter=new MinePublishCommentAdapter(null,this,type);
        commission_detail_lv.setAdapter(minePublishCommentAdapter);
    }
}
