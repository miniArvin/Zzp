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
import com.tryine.zzp.entity.test.TestEntity;
import com.tryine.zzp.entity.test.remote.FoundEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class FoundLocationNameAdapter extends RecyclerView.Adapter<FoundLocationNameAdapter.ViewHolder> {
    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<FoundEntity.InfoBean.CityBean> cityBeen;

    public FoundLocationNameAdapter(View mParent, Context mContext, List<FoundEntity.InfoBean.CityBean> mData) {
        mLayoutInflater=LayoutInflater.from(mContext);
        this.mParent = mParent;
        this.mContext = mContext;
        this.cityBeen = mData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
        ImageView location_name_img;
        TextView location_name_tv;
        TextView location_detail_tv;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.found_location_name_item,
                parent, false);
        FoundLocationNameAdapter.ViewHolder viewHolder = new FoundLocationNameAdapter.ViewHolder(view);

        viewHolder.location_name_img = (ImageView) view
                .findViewById(R.id.location_name_img);
        viewHolder.location_name_tv = (TextView) view
                .findViewById(R.id.location_name_tv);
        viewHolder.location_detail_tv = (TextView) view
                .findViewById(R.id.location_detail_tv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(UrlUtils.getUrl(cityBeen.get(position).getPhoto())).asBitmap().into(holder.location_name_img);
        holder.location_name_tv.setText(cityBeen.get(position).getName());
//        holder.location_detail_tv.setText(cityBeen.get(position).getCity_id());
    }


    @Override
    public int getItemCount() {
        return cityBeen==null?0:cityBeen.size();
    }
}
