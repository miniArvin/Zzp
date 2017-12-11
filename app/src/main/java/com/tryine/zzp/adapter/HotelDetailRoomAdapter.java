package com.tryine.zzp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.HotelDetailEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/11/8 0008.
 */

public class HotelDetailRoomAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<HotelDetailEntity.InfoBean.RoomBean> roomBeen;
    private ViewHolder viewHolder;

    public HotelDetailRoomAdapter(Context context,List<HotelDetailEntity.InfoBean.RoomBean> roomBeen) {
        mLayoutInflater=LayoutInflater.from(context);
        this.mContext = context;
        this.roomBeen = roomBeen;
    }

    @Override
    public int getCount() {
        return roomBeen==null?0:roomBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return roomBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mLayoutInflater.inflate(R.layout.hotel_detail_room_item,null) ;
        viewHolder = new ViewHolder();
        viewHolder.hotel_detail_no_room= (RelativeLayout) convertView.findViewById(R.id.hotel_detail_no_room);
        viewHolder.hotel_detail_room_img_iv= (ImageView) convertView.findViewById(R.id.hotel_detail_room_img_iv);
        viewHolder.hotel_detail_room_type_tv= (TextView) convertView.findViewById(R.id.hotel_detail_room_type_tv);
        viewHolder.hotel_detail_room_price_tv= (TextView) convertView.findViewById(R.id.hotel_detail_room_price_tv);
        viewHolder.hotel_detail_room_message_tv= (TextView) convertView.findViewById(R.id.hotel_detail_room_message_tv);
        viewHolder.hotel_detail_room_pai_tv= (TextView) convertView.findViewById(R.id.hotel_detail_room_pai_tv);
        viewHolder.hotel_detail_room_check_tv= (TextView) convertView.findViewById(R.id.hotel_detail_room_check_tv);

        if (roomBeen.get(position).getIs_auction().equals("1")){
            viewHolder.hotel_detail_room_pai_tv.setText("趣味竞拍");
            viewHolder.hotel_detail_room_pai_tv.setBackgroundResource(R.drawable.login_bg_btn);
        }else {
            viewHolder.hotel_detail_room_pai_tv.setText("已拍完");
            viewHolder.hotel_detail_room_pai_tv.setBackgroundResource(R.drawable.account_binding_bg_gray);
        }
        if (roomBeen.get(position).getSku()==0){
            viewHolder.hotel_detail_no_room.setVisibility(View.VISIBLE);
            viewHolder.hotel_detail_room_check_tv.setText("满房");
            viewHolder.hotel_detail_room_check_tv.setTextColor(mContext.getResources().getColor(R.color.hotel_detail_room_list_bg));
            viewHolder.hotel_detail_room_check_tv.setBackgroundResource(R.drawable.hotel_detail_item_man_fang_bg_btn);
        }else {
            viewHolder.hotel_detail_room_check_tv.setText("预定");
            viewHolder.hotel_detail_room_check_tv.setTextColor(Color.WHITE);
            viewHolder.hotel_detail_room_check_tv.setBackgroundResource(R.drawable.login_bg_btn);
        }

        viewHolder.hotel_detail_room_price_tv.setText(roomBeen.get(position).getPrice());
        Glide.with(mContext).load(UrlUtils.getUrl(roomBeen.get(position).getPhoto())).asBitmap().into(viewHolder.hotel_detail_room_img_iv);
        viewHolder.hotel_detail_room_message_tv.setText(roomBeen.get(position).getBed_type());
        viewHolder.hotel_detail_room_type_tv.setText(roomBeen.get(position).getTitle());
        return convertView;
    }

    public class ViewHolder{
        ImageView hotel_detail_room_img_iv;
        RelativeLayout hotel_detail_no_room;
        TextView hotel_detail_room_type_tv;
        TextView hotel_detail_room_price_tv;
        TextView hotel_detail_room_message_tv;
        TextView hotel_detail_room_pai_tv;
        TextView hotel_detail_room_check_tv;
    }
}
