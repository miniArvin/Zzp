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
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6 0006.
 */

public class FoundNewsAdapter extends BaseAdapter {

    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<FoundEntity.InfoBean.ArticleBean> articleBeen;

    public FoundNewsAdapter(View mParent, Context mContext,List<FoundEntity.InfoBean.ArticleBean> articleBeen) {
        mLayoutInflater=LayoutInflater.from(mContext);
        this.mParent = mParent;
        this.mContext = mContext;
        this.articleBeen=articleBeen;
    }

    @Override
    public int getCount() {
        return articleBeen==null?0:articleBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return articleBeen.get(position);
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

        Glide.with(mContext).load(UrlUtils.getUrl(articleBeen.get(position).getPhoto())).asBitmap().into(viewHolder.new_content_img);
        viewHolder.new_title_tv.setText(articleBeen.get(position).getTitle());
        viewHolder.new_content_tv.setText(articleBeen.get(position).getProfiles());
        viewHolder.new_read_tv.setText(articleBeen.get(position).getViews());
        return convertView;

    }

    public class ViewHolder{
        TextView new_title_tv;
        TextView new_content_tv;

        TextView new_read_tv;
        ImageView new_content_img;
    }
}
