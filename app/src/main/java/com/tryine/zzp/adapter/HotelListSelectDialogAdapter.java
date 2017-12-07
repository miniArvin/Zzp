package com.tryine.zzp.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tryine.zzp.R;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6 0006.
 */

public class HotelListSelectDialogAdapter extends BaseAdapter {
    private Context context;
    private List<String> data;
    private LayoutInflater mLayoutInflater;
    private ViewHolder viewHolder;
    private int defItem;

    public HotelListSelectDialogAdapter(Context context, List<String> data) {
        mLayoutInflater= LayoutInflater.from(context);
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mLayoutInflater.inflate(R.layout.hotel_list_select_item,null);
        viewHolder=new ViewHolder();
        viewHolder.hotel_list_select_item_tv= (TextView) convertView.findViewById(R.id.hotel_list_select_item_tv);
        viewHolder.hotel_list_select_item_tv.setText(data.get(position));
        if (defItem == position) {
            viewHolder.hotel_list_select_item_tv.setTextColor(context.getResources().getColor(R.color.home_location_word));
        } else {
            viewHolder.hotel_list_select_item_tv.setTextColor(context.getResources().getColor(R.color.home_recommend_location_word));
        }
        return convertView;
    }

    public class ViewHolder{
        TextView hotel_list_select_item_tv;
    }

    /**
     适配器中添加这个方法
     */
    public void setDefSelect(int position) {
        this.defItem = position;
        notifyDataSetChanged();
    }
}
