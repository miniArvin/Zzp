package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tryine.zzp.R;

/**
 * Created by Administrator on 2017/11/10 0010.
 */

public class FoundDetailFoodAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public FoundDetailFoodAdapter(Context mContext) {
        mLayoutInflater=LayoutInflater.from(mContext);
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 11;
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
        convertView = mLayoutInflater.inflate(R.layout.found_food_view_item,null) ;
        return convertView;
    }
}
