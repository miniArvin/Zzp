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

public class FoundQuestionsAdapter extends BaseAdapter {

    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<FoundEntity.InfoBean.AnswerBean> answerBeen;

    public FoundQuestionsAdapter(View mParent, Context mContext,List<FoundEntity.InfoBean.AnswerBean> answerBeen) {
        mLayoutInflater=LayoutInflater.from(mContext);
        this.mParent = mParent;
        this.mContext = mContext;
        this.answerBeen=answerBeen;
    }

    @Override
    public int getCount() {
        return answerBeen==null?0:answerBeen.size();
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
        ViewHolder viewHolder = new ViewHolder();
        convertView = mLayoutInflater.inflate(R.layout.found_interesting_question_item,null) ;
        viewHolder.interesting_question_one_content_img = (ImageView) convertView.findViewById(R.id.interesting_question_one_content_img);
        viewHolder.interesting_question_one_img_headimg = (ImageView) convertView.findViewById(R.id.interesting_question_one_img_headimg);
        viewHolder.interesting_question_one_title_tv = (TextView) convertView.findViewById(R.id.interesting_question_one_title_tv);
        viewHolder.interesting_question_one_head_tv = (TextView) convertView.findViewById(R.id.interesting_question_one_head_tv);
        viewHolder.interesting_question_one_location_tv = (TextView) convertView.findViewById(R.id.interesting_question_one_location_tv);
        viewHolder.interesting_question_one_zan_tv = (TextView) convertView.findViewById(R.id.interesting_question_one_zan_tv);
        viewHolder.interesting_question_one_read_tv = (TextView) convertView.findViewById(R.id.interesting_question_one_read_tv);

        Glide.with(mContext).load(UrlUtils.getUrl(answerBeen.get(position).getFace())).asBitmap().into(viewHolder.interesting_question_one_img_headimg);
        Glide.with(mContext).load(UrlUtils.getUrl(answerBeen.get(position).getImg())).asBitmap().into(viewHolder.interesting_question_one_content_img);
        viewHolder.interesting_question_one_title_tv.setText(answerBeen.get(position).getTitle());
        viewHolder.interesting_question_one_location_tv.setText(answerBeen.get(position).getCity());
        viewHolder.interesting_question_one_read_tv.setText(answerBeen.get(position).getViews());
        viewHolder.interesting_question_one_zan_tv.setText(answerBeen.get(position).getReply_num());
        viewHolder.interesting_question_one_head_tv.setText(answerBeen.get(position).getAccount());
        return convertView;

    }

    public class ViewHolder{
        TextView interesting_question_one_title_tv;
        TextView interesting_question_one_head_tv;
        TextView interesting_question_one_location_tv;
        TextView interesting_question_one_zan_tv;
        TextView interesting_question_one_read_tv;
        ImageView interesting_question_one_content_img;
        ImageView interesting_question_one_img_headimg;
    }
}
