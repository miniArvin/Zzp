package com.tryine.zzp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.TestEntity;
import com.tryine.zzp.entity.test.remote.OrderEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class OrderHotelAdapter extends RecyclerView.Adapter<OrderHotelAdapter.ViewHolder> {

    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<OrderEntity.InfoBean> mData;

    public OrderHotelAdapter(Context context, View parent,List<OrderEntity.InfoBean> mData) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext=context;
        this.mParent=parent;
        this.mData = mData;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.order_hotel_fl_item,
                parent, false);
        OrderHotelAdapter.ViewHolder viewHolder = new OrderHotelAdapter.ViewHolder(view);
        viewHolder.hotel_img_iv = (ImageView) view.findViewById(R.id.hotel_img_iv);
        viewHolder.hotel_address_tv = (TextView) view.findViewById(R.id.hotel_address_tv);
        viewHolder.hotel_name_tv = (TextView) view.findViewById(R.id.hotel_name_tv);
        viewHolder.hotel_check_in_time_tv = (TextView) view.findViewById(R.id.hotel_check_in_time_tv);
        viewHolder.hotel_check_out_time_tv = (TextView) view.findViewById(R.id.hotel_check_out_time_tv);
        viewHolder.hotel_order_num_tv = (TextView) view.findViewById(R.id.hotel_order_num_tv);
        viewHolder.hotel_order_price_tv = (TextView) view.findViewById(R.id.hotel_order_price_tv);
        viewHolder.hotel_ensure_tv = (TextView) view.findViewById(R.id.hotel_ensure_tv);
        viewHolder.hotel_order_type_tv = (TextView) view.findViewById(R.id.hotel_order_type_tv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String breakfast="";
        Glide.with(mContext).load(UrlUtils.getUrl(mData.get(position).getPhoto())).asBitmap().into(holder.hotel_img_iv);
        holder.hotel_address_tv.setText(mData.get(position).getAddr());
        holder.hotel_name_tv.setText(mData.get(position).getHotel_name());
        holder.hotel_check_in_time_tv.setText(mData.get(position).getStime());
        holder.hotel_check_out_time_tv.setText(mData.get(position).getLtime());
        holder.hotel_order_num_tv.setText("订单号："+mData.get(position).getOrder_sn());
        holder.hotel_order_price_tv.setText(mData.get(position).getAmount());
        if (mData.get(position).getOrder_sn().equals("0")) {
            holder.hotel_ensure_tv.setText("待付款");
        }
        if (mData.get(position).getBreakfast().equals("1")){
            breakfast="单早";
        }
        holder.hotel_order_type_tv.setText(mData.get(position).getTitle()+"  "+mData.get(position).getNight_num()+"  "+mData.get(position).getBed_type()+"  "+breakfast);
    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
        ImageView hotel_img_iv;
        TextView hotel_name_tv;
        TextView hotel_check_in_time_tv;
        TextView hotel_check_out_time_tv;
        TextView hotel_order_num_tv;
        TextView hotel_order_price_tv;
        TextView hotel_ensure_tv;
        TextView hotel_order_type_tv;
        TextView hotel_address_tv;
    }
}
