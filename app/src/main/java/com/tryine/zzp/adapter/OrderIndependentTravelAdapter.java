package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.TestEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27 0027.
 */

public class OrderIndependentTravelAdapter extends BaseAdapter {
    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<TestEntity> mData;
    public OrderIndependentTravelAdapter(Context context, View parent) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext=context;
        mParent=parent;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mLayoutInflater.inflate(R.layout.order_independent_travel_fl_item,null) ;
        return convertView;
    }
}
