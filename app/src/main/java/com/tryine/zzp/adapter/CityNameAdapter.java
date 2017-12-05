package com.tryine.zzp.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tryine.zzp.R;

import com.tryine.zzp.entity.test.remote.HomeEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20 0020.
 */

public class CityNameAdapter extends RecyclerView.Adapter<CityNameAdapter.ViewHolder> {
    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<HomeEntity.InfoBean.WaterBean> mData;
    private OnUseClickListener onUseClickListener;


    public CityNameAdapter(Context context, List<HomeEntity.InfoBean.WaterBean> infoBeen, View parent) {
        mLayoutInflater = LayoutInflater.from(context);
        mData=infoBeen;
        mContext=context;
        mParent=parent;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
        ImageView city_name_img;
        TextView city_name_tv;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.city_name_item,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.city_name_img = (ImageView) view
                .findViewById(R.id.city_name_img);
        viewHolder.city_name_tv = (TextView) view
                .findViewById(R.id.city_name_tv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext)
                .load(UrlUtils.getUrl(mData.get(position).getPhoto())).asBitmap().into(holder.city_name_img);
        holder.city_name_tv.setText(mData.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnUseClickListener {
        void onClick(int position);
    }

    public void setOnUseClickListener(OnUseClickListener listener) {
        this.onUseClickListener = listener;
    }

}
