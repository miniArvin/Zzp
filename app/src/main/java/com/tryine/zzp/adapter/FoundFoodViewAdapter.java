package com.tryine.zzp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.TestEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class FoundFoodViewAdapter extends RecyclerView.Adapter<FoundFoodViewAdapter.ViewHolder> {
    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public FoundFoodViewAdapter(View mParent, Context mContext) {
        mLayoutInflater=LayoutInflater.from(mContext);
        this.mParent = mParent;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
        ImageView food_view_img;
        TextView food_view_place_tv;
        TextView food_view_place_detail_tv;
        ImageView found_food_view_img_headimg;
        TextView food_view_zan_tv;
        TextView food_view_comment_tv;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.found_food_view_item,
                parent, false);
        FoundFoodViewAdapter.ViewHolder viewHolder = new FoundFoodViewAdapter.ViewHolder(view);

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

    }


    @Override
    public int getItemCount() {
        return 4;
    }
}
