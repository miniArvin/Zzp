package com.tryine.zzp.ui.fragment.found;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.blankj.utilcode.util.LogUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.FoundDetailFoodAdapter;
import com.tryine.zzp.adapter.FoundFoodViewAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundDetailFoodFragment extends BaseFragment {
    private GridView found_detail_food_fl_gv;
    private FoundDetailFoodAdapter foundDetailFoodAdapter;


    public FoundDetailFoodFragment() {

    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_found_detail_food;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        initView();
    }

    public void initView(){
        found_detail_food_fl_gv= (GridView) mView.findViewById(R.id.found_detail_food_fl_gv);
        foundDetailFoodAdapter=new FoundDetailFoodAdapter(mContext);
        found_detail_food_fl_gv.setAdapter(foundDetailFoodAdapter);
    }


}
