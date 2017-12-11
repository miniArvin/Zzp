package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.HotelDetailEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class HotelDetailIntroAdapter extends BaseAdapter {
    private Context context;
    private List<HotelDetailEntity.InfoBean.HotelIntroBean> hotelIntroBeen;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;

    public HotelDetailIntroAdapter(Context context, List<HotelDetailEntity.InfoBean.HotelIntroBean> hotelIntroBeen) {
        inflater= LayoutInflater.from(context);
        this.context = context;
        this.hotelIntroBeen = hotelIntroBeen;
    }

    @Override
    public int getCount() {
        return hotelIntroBeen==null?0:(hotelIntroBeen.size()>4?4:hotelIntroBeen.size());
    }

    @Override
    public Object getItem(int position) {
        return hotelIntroBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder=new ViewHolder();
        convertView = inflater.inflate(R.layout.hotel_detail_intro_item,null);
        viewHolder.hotel_detail_intro_item_iv= (ImageView) convertView.findViewById(R.id.hotel_detail_intro_item_iv);
        Glide.with(context).load(UrlUtils.getUrl(hotelIntroBeen.get(position).getIco())).asBitmap().into(viewHolder.hotel_detail_intro_item_iv);
        return convertView;
    }

    public class ViewHolder{
        ImageView hotel_detail_intro_item_iv;
    }
}
