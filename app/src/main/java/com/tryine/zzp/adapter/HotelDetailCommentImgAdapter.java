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
 * Created by Administrator on 2017/12/11 0011.
 */

public class HotelDetailCommentImgAdapter extends BaseAdapter {
    private Context context;
    private List<HotelDetailEntity.InfoBean.ApplyBean.PhotoBean> data;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;

    public HotelDetailCommentImgAdapter(Context context, List<HotelDetailEntity.InfoBean.ApplyBean.PhotoBean> data) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
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
        viewHolder= new ViewHolder();
        convertView = inflater.inflate(R.layout.hotel_detail_comment_img_item,null);
        viewHolder.hotel_detail_comment1_img_iv= (ImageView) convertView.findViewById(R.id.hotel_detail_comment1_img_iv);

        Glide.with(context).load(UrlUtils.getUrl(data.get(position).getPhoto())).asBitmap().into(viewHolder.hotel_detail_comment1_img_iv);
        return convertView;
    }

    public class ViewHolder{
        ImageView hotel_detail_comment1_img_iv;
    }
}
