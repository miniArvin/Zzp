package com.tryine.zzp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.TestEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class OrderHotelAdapter extends RecyclerView.Adapter<OrderHotelAdapter.ViewHolder> {

    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<TestEntity> mData;

    public OrderHotelAdapter(Context context, View parent) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext=context;
        mParent=parent;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.order_hotel_fl_item,
                parent, false);
        OrderHotelAdapter.ViewHolder viewHolder = new OrderHotelAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
        ImageView hotel_recommend_img;
        TextView hotel_recommend_name;
        TextView hotel_recommend_price;
        TextView hotel_recommend_location;
        RatingBar hotel_recommend_level;
    }
}
