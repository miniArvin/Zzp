package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tryine.zzp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/20 0020.
 */

public class HotelOrderRoomCountAdapter extends BaseAdapter {
    private Context context;
    private int sku;
    private LayoutInflater inflater;
    private int defItem;

    public HotelOrderRoomCountAdapter(Context context, int sku) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.sku = sku;
    }

    @Override
    public int getCount() {
        return sku>7?6:sku;
    }

    @Override
    public Object getItem(int position) {
        return sku;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        convertView = inflater.inflate(R.layout.hotel_list_level_item,null);
        viewHolder.hotel_list_level_item_tv = (TextView) convertView.findViewById(R.id.hotel_list_level_item_tv);
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) viewHolder.hotel_list_level_item_tv.getLayoutParams();
        params.width=130;
        params.height=65;
        viewHolder.hotel_list_level_item_tv.setLayoutParams(params);
        viewHolder.hotel_list_level_item_tv.setText(position+1+"间");
        if (defItem == position) {
            viewHolder.hotel_list_level_item_tv.setTextColor(context.getResources().getColor(R.color.white));
            viewHolder.hotel_list_level_item_tv.setBackgroundResource(R.drawable.login_bg_btn);
        } else {
            viewHolder.hotel_list_level_item_tv.setTextColor(context.getResources().getColor(R.color.home_location_word));
            viewHolder.hotel_list_level_item_tv.setBackgroundResource(R.drawable.login_bg_code);
        }
        return convertView;
    }

    public class ViewHolder{
        TextView hotel_list_level_item_tv;
    }

    /**
     适配器中添加这个方法
     */
    public void setDefSelect(int position) {
        this.defItem = position;
        notifyDataSetChanged();
    }
}
