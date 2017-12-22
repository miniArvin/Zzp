package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.FoodEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/11/10 0010.
 */

public class FoundDetailFoodAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<FoodEntity.InfoBean> foodBean;

    public FoundDetailFoodAdapter(Context mContext , List<FoodEntity.InfoBean> foodBean) {
        mLayoutInflater=LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.foodBean = foodBean;
    }

    @Override
    public int getCount() {
        return foodBean==null?0:foodBean.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView==null) {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.found_food_view_item, null);
            viewHolder.food_view_comment_tv = (TextView) convertView.findViewById(R.id.food_view_comment_tv);
            viewHolder.food_view_zan_tv = (TextView) convertView.findViewById(R.id.food_view_zan_tv);
            viewHolder.food_view_place_detail_tv = (TextView) convertView.findViewById(R.id.food_view_place_detail_tv);
            viewHolder.food_view_place_tv = (TextView) convertView.findViewById(R.id.food_view_place_tv);
            viewHolder.found_food_view_img_headimg = (CircleImageView) convertView.findViewById(R.id.found_food_view_img_headimg);
            viewHolder.food_view_img = (ImageView) convertView.findViewById(R.id.food_view_img);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.food_view_comment_tv.setText(foodBean.get(position).getViews());
        viewHolder.food_view_zan_tv.setText(foodBean.get(position).getZan_num());
        viewHolder.food_view_place_detail_tv.setText(foodBean.get(position).getTitle());
        viewHolder.food_view_place_tv.setText(foodBean.get(position).getCity_id());
        Glide.with(mContext).load(UrlUtils.getUrl(foodBean.get(position).getPic())).asBitmap().into(viewHolder.food_view_img);
        Glide.with(mContext).load(UrlUtils.getUrl(foodBean.get(position).getFace())).asBitmap().into(viewHolder.found_food_view_img_headimg);

        return convertView;
    }

    public class ViewHolder{
        ImageView food_view_img;
        CircleImageView found_food_view_img_headimg;
        TextView food_view_place_tv;
        TextView food_view_place_detail_tv;
        TextView food_view_zan_tv;
        TextView food_view_comment_tv;
    }
}
