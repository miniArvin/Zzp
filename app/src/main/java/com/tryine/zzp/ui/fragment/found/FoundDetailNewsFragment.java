package com.tryine.zzp.ui.fragment.found;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.FoundNewsAdapter;
import com.tryine.zzp.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundDetailNewsFragment extends BaseFragment {
    private ListView found_detail_news_fl_lv;
    private FoundNewsAdapter foundNewsAdapter;

    public FoundDetailNewsFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_found_detail_news;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        init();
    }

    public void init() {
        found_detail_news_fl_lv = (ListView) mView.findViewById(R.id.found_detail_news_fl_lv);
        foundNewsAdapter=new FoundNewsAdapter(mView,mContext);
        found_detail_news_fl_lv.setAdapter(foundNewsAdapter);
    }

}
