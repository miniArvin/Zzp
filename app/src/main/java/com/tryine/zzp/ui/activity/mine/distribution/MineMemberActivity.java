package com.tryine.zzp.ui.activity.mine.distribution;


import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MinePublishCommentAdapter;
import com.tryine.zzp.base.BaseStatusMActivity;

public class MineMemberActivity extends BaseStatusMActivity {
    private ListView distribution_member_lv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type=9;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_member;
    }

    @Override
    protected void afterOnCreate() {
        init();
    }
    public void init(){
        distribution_member_lv= (ListView) findViewById(R.id.distribution_member_lv);
        minePublishCommentAdapter=new MinePublishCommentAdapter(null,this,type);
        distribution_member_lv.setAdapter(minePublishCommentAdapter);
    }
}
