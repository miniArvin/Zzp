package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tryine.zzp.R;

import java.util.List;

/**
 * Created by Administrator on 2017/12/7 0007.
 */

public class HotelListLevelDialogAdapter extends BaseAdapter {
    private Context context;
    private List<String> data;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;
    private int defItem;
    private int type;

    public HotelListLevelDialogAdapter(Context context, List<String> data,int type) {
        inflater= LayoutInflater.from(context);
        this.context = context;
        this.data = data;
        this.type=type;
    }

    @Override
    public int getCount() {
        return data==null?0:data.size();
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
        convertView = inflater.inflate(R.layout.hotel_list_level_item,null);
        viewHolder=new ViewHolder();
        viewHolder.hotel_list_level_item_tv= (TextView) convertView.findViewById(R.id.hotel_list_level_item_tv);
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) viewHolder.hotel_list_level_item_tv.getLayoutParams();
        if (type==2){
            params.width=160;
            viewHolder.hotel_list_level_item_tv.setLayoutParams(params);
        }
        viewHolder.hotel_list_level_item_tv.setText(data.get(position));
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
