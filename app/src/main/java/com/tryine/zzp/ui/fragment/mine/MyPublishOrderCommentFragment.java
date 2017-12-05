package com.tryine.zzp.ui.fragment.mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MinePublishCommentAdapter;
import com.tryine.zzp.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPublishOrderCommentFragment extends BaseFragment {

    private ListView mine_publish_order_comment_lv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type=0;

    public MyPublishOrderCommentFragment() {
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_my_publish_order_comment;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        init();
    }

    public void init(){
        mine_publish_order_comment_lv= (ListView) mView.findViewById(R.id.mine_publish_order_comment_lv);
        minePublishCommentAdapter=new MinePublishCommentAdapter(mView,mContext,type);
        mine_publish_order_comment_lv.setAdapter(minePublishCommentAdapter);
    }

}
