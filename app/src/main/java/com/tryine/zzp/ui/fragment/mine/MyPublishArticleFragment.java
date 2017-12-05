package com.tryine.zzp.ui.fragment.mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.GridView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MinePublishCommentAdapter;
import com.tryine.zzp.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPublishArticleFragment extends BaseFragment {
    private GridView mine_publish_comment_gv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type=1;

    public MyPublishArticleFragment() {
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_my_publish_article;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        init();
    }

    public void init(){
        mine_publish_comment_gv= (GridView) mView.findViewById(R.id.mine_publish_comment_gv);
        minePublishCommentAdapter=new MinePublishCommentAdapter(mView,mContext,type);
        mine_publish_comment_gv.setNumColumns(1);
        mine_publish_comment_gv.setAdapter(minePublishCommentAdapter);
    }
}
