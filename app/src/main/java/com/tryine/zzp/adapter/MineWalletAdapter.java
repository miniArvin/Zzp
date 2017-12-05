package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tryine.zzp.R;

/**
 * Created by Administrator on 2017/11/7 0007.
 */

public class MineWalletAdapter extends BaseAdapter{
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public MineWalletAdapter( Context context) {
        mLayoutInflater=LayoutInflater.from(context);
        this.mContext = context;
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
        convertView = mLayoutInflater.inflate(R.layout.mine_wallet_item,null) ;
        return convertView;
    }
}
