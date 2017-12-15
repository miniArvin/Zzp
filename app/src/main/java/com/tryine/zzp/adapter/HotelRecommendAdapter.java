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
import com.tryine.zzp.entity.test.remote.HomeEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20 0020.
 */

public class HotelRecommendAdapter extends RecyclerView.Adapter<HotelRecommendAdapter.ViewHolder> {
    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<HomeEntity.InfoBean.HotelBean> mData;
    private OnUseClickListener onUseClickListener;

    public HotelRecommendAdapter(Context context, List<HomeEntity.InfoBean.HotelBean> hotelBeen, View parent) {
        mLayoutInflater = LayoutInflater.from(context);
        mData=hotelBeen;
        mContext=context;
        mParent=parent;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
        ImageView hotel_recommend_img;
        TextView hotel_recommend_name;
        TextView hotel_recommend_price;
        TextView hotel_recommend_location;
        RatingBar hotel_recommend_level;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.hotel_recommend_item,
                parent, false);
        ViewHolder viewHolder=new ViewHolder(view);

        viewHolder.hotel_recommend_img = (ImageView) view
                .findViewById(R.id.hotel_recommend_img);
        viewHolder.hotel_recommend_name = (TextView) view
                .findViewById(R.id.hotel_recommend_name);
        viewHolder.hotel_recommend_price = (TextView) view
                .findViewById(R.id.hotel_recommend_price);
        viewHolder.hotel_recommend_location = (TextView) view
                .findViewById(R.id.hotel_recommend_location);
        viewHolder.hotel_recommend_level = (RatingBar) view
                .findViewById(R.id.hotel_recommend_level);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(UrlUtils.getUrl(mData.get(position).getPhoto())).asBitmap().centerCrop().into(holder.hotel_recommend_img);
        holder.hotel_recommend_name.setText(mData.get(position).getHotel_name());
        holder.hotel_recommend_price.setText(mData.get(position).getPrice());
        holder.hotel_recommend_location.setText(mData.get(position).getAddr());
        holder.hotel_recommend_level.setRating(Float.parseFloat(mData.get(position).getStar()));
    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    public interface OnUseClickListener {
        void onClick(int position);
    }

    public void setOnUseClickListener(OnUseClickListener listener) {
        this.onUseClickListener = listener;
    }

}
