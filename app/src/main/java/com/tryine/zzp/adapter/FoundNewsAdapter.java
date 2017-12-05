package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tryine.zzp.R;

/**
 * Created by Administrator on 2017/11/6 0006.
 */

public class FoundNewsAdapter extends BaseAdapter {

    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public FoundNewsAdapter(View mParent, Context mContext) {
        mLayoutInflater=LayoutInflater.from(mContext);
        this.mParent = mParent;
        this.mContext = mContext;
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
        convertView = mLayoutInflater.inflate(R.layout.found_news_item,null) ;
        return convertView;

    }
}
