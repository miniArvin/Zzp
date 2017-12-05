package com.tryine.zzp.ui.fragment.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.AllOrderAdapter;
import com.tryine.zzp.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZZPOrderFragment extends BaseFragment {
    private ListView all_order_lv;
    private AllOrderAdapter allOrderAdapter;

    public ZZPOrderFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_zzporder;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        init();
    }

    public void init(){
        all_order_lv= (ListView) mView.findViewById(R.id.all_order_lv);
        allOrderAdapter=new AllOrderAdapter(mContext);
        all_order_lv.setAdapter(allOrderAdapter);
    }

}
