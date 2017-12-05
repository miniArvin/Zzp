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
public class MyPublishQuestionsFragment extends BaseFragment {
    private ListView mine_publish_questions_lv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type=3;

    public MyPublishQuestionsFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_my_publish_questions;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        init();
    }

    public void init(){
        mine_publish_questions_lv= (ListView) mView.findViewById(R.id.mine_publish_questions_lv);
        minePublishCommentAdapter=new MinePublishCommentAdapter(mView,mContext,type);
        mine_publish_questions_lv.setAdapter(minePublishCommentAdapter);
    }

}
