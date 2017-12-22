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
import com.tryine.zzp.entity.test.remote.FoundEntity;
import com.tryine.zzp.entity.test.remote.NewsEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6 0006.
 */

public class FoundDetailNewsAdapter extends BaseAdapter {


    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<NewsEntity.InfoBean> newsBean;

    public FoundDetailNewsAdapter(Context mContext, List<NewsEntity.InfoBean> newsBean) {
        mLayoutInflater=LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.newsBean=newsBean;
    }

    @Override
    public int getCount() {
        return newsBean==null?0:newsBean.size();
    }

    @Override
    public Object getItem(int position) {
        return newsBean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        convertView = mLayoutInflater.inflate(R.layout.found_news_item,null) ;
        viewHolder.new_content_img = (ImageView) convertView.findViewById(R.id.new_content_img);
        viewHolder.new_title_tv = (TextView) convertView.findViewById(R.id.new_title_tv);
        viewHolder.new_content_tv = (TextView) convertView.findViewById(R.id.new_content_tv);
        viewHolder.new_read_tv = (TextView) convertView.findViewById(R.id.new_read_tv);

        Glide.with(mContext).load(UrlUtils.getUrl(newsBean.get(position).getPhoto())).asBitmap().into(viewHolder.new_content_img);
        viewHolder.new_title_tv.setText(newsBean.get(position).getTitle());
        viewHolder.new_content_tv.setText(newsBean.get(position).getProfiles());
        viewHolder.new_read_tv.setText(newsBean.get(position).getViews());
        return convertView;

    }

    public class ViewHolder{
        TextView new_title_tv;
        TextView new_content_tv;
        TextView new_read_tv;
        ImageView new_content_img;
    }
}
