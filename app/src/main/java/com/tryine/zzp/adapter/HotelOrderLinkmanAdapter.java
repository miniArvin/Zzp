package com.tryine.zzp.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.tryine.zzp.R;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class HotelOrderLinkmanAdapter extends BaseAdapter{
    private List<String> linkmanName;
    private Context context;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;

    public HotelOrderLinkmanAdapter(List<String> linkmanName, Context context) {
        inflater = LayoutInflater.from(context);
        this.linkmanName = linkmanName;
        this.context = context;
    }

    @Override
    public int getCount() {
        return linkmanName==null?1:(linkmanName.size()+1);
    }

    @Override
    public Object getItem(int position) {
        return linkmanName.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = new ViewHolder();
        convertView = inflater.inflate(R.layout.hotel_order_linkman_item,null);
        viewHolder.hotel_order_linkman_et = (EditText) convertView.findViewById(R.id.hotel_order_linkman_et);
        if (linkmanName==null||linkmanName.size()==0){
            viewHolder.hotel_order_linkman_et.setHint("入住人"+(position+1)+"名字");
        }else {
            if (position<linkmanName.size()){
                viewHolder.hotel_order_linkman_et.setText(linkmanName.get(position));
                viewHolder.hotel_order_linkman_et.setHint("入住人"+(position+1)+"名字");
            }else {
                viewHolder.hotel_order_linkman_et.setHint("入住人"+(position+1)+"名字");
            }
        }
        return convertView;
    }

    public class ViewHolder{
        EditText hotel_order_linkman_et;
    }

    /** 添加item数据 */
    public void addData(String text) {
        if (linkmanName != null)
            linkmanName.add("");// 添加数据
        viewHolder.hotel_order_linkman_et.setHint(text);
    }

    /** 移除item数据 */
    public void delData() {
        if (linkmanName != null && linkmanName.size() > 0)
            linkmanName.remove(linkmanName.size() - 1);// 移除最后一条数据
    }
}
