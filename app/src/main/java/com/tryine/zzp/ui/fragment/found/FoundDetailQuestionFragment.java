package com.tryine.zzp.ui.fragment.found;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.FoundDetailQuestionAdapter;
import com.tryine.zzp.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundDetailQuestionFragment extends BaseFragment {
    private ListView found_detail_question_fl_lv;
    private FoundDetailQuestionAdapter foundDetailQuestionAdapter;

    public FoundDetailQuestionFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_found_detail_question;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        init();
    }

    public void init(){
        found_detail_question_fl_lv= (ListView) mView.findViewById(R.id.found_detail_question_fl_lv);
        foundDetailQuestionAdapter=new FoundDetailQuestionAdapter(mContext);
        found_detail_question_fl_lv.setAdapter(foundDetailQuestionAdapter);
    }

}
