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
import com.tryine.zzp.entity.test.remote.FoundEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class FoundFoodViewAdapter extends RecyclerView.Adapter<FoundFoodViewAdapter.ViewHolder> {
    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<FoundEntity.InfoBean.PostBean> postBeen;
    private OnItemClickListener onItemClickListener;

    public FoundFoodViewAdapter(View mParent, Context mContext ,List<FoundEntity.InfoBean.PostBean> data) {
        mLayoutInflater=LayoutInflater.from(mContext);
        this.mParent = mParent;
        this.mContext = mContext;
        this.postBeen = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnItemClickListener onItemClickListener;

        public ViewHolder(View itemView , OnItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }
        ImageView food_view_img;
        TextView food_view_place_tv;
        TextView food_view_place_detail_tv;
        ImageView found_food_view_img_headimg;
        TextView food_view_zan_tv;
        TextView food_view_comment_tv;

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(v,getPosition());
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.found_food_view_item,
                parent, false);
        FoundFoodViewAdapter.ViewHolder viewHolder = new FoundFoodViewAdapter.ViewHolder(view,onItemClickListener);

        viewHolder.food_view_img = (ImageView) view
                .findViewById(R.id.food_view_img);
        viewHolder.food_view_place_tv = (TextView) view
                .findViewById(R.id.food_view_place_tv);
        viewHolder.food_view_place_detail_tv = (TextView) view
                .findViewById(R.id.food_view_place_detail_tv);
        viewHolder.found_food_view_img_headimg = (ImageView) view
                .findViewById(R.id.found_food_view_img_headimg);
        viewHolder.food_view_zan_tv = (TextView) view
                .findViewById(R.id.food_view_zan_tv);
        viewHolder.food_view_comment_tv = (TextView) view
                .findViewById(R.id.food_view_comment_tv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(UrlUtils.getUrl(postBeen.get(position).getPic())).asBitmap().into(holder.food_view_img);
        Glide.with(mContext).load(UrlUtils.getUrl(postBeen.get(position).getFace())).asBitmap().into(holder.found_food_view_img_headimg);
        holder.food_view_place_tv.setText(postBeen.get(position).getCity());
        holder.food_view_place_detail_tv.setText(postBeen.get(position).getTitle());
        holder.food_view_zan_tv.setText(postBeen.get(position).getZan_num());
        holder.food_view_comment_tv.setText(postBeen.get(position).getViews());
    }


    @Override
    public int getItemCount() {
        return postBeen==null?0:postBeen.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}
