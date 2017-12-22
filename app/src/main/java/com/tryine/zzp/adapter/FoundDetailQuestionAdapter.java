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
import com.tryine.zzp.entity.test.remote.AnswerEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/11/10 0010.
 */

public class FoundDetailQuestionAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<AnswerEntity.InfoBean.ListBean> listBeen;

    public FoundDetailQuestionAdapter(Context mContext, List<AnswerEntity.InfoBean.ListBean> listBeen) {
        mLayoutInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.listBeen = listBeen;
    }

    @Override
    public int getCount() {
        return listBeen == null ? 0 : listBeen.size();
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
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.found_interesting_question_item, null);
            viewHolder.interesting_question_one_content_img = (ImageView) convertView.findViewById(R.id.interesting_question_one_content_img);
            viewHolder.interesting_question_one_img_headimg = (CircleImageView) convertView.findViewById(R.id.interesting_question_one_img_headimg);
            viewHolder.interesting_question_one_title_tv = (TextView) convertView.findViewById(R.id.interesting_question_one_title_tv);
            viewHolder.interesting_question_one_head_tv = (TextView) convertView.findViewById(R.id.interesting_question_one_head_tv);
            viewHolder.interesting_question_one_location_tv = (TextView) convertView.findViewById(R.id.interesting_question_one_location_tv);
            viewHolder.interesting_question_one_zan_tv = (TextView) convertView.findViewById(R.id.interesting_question_one_zan_tv);
            viewHolder.interesting_question_one_read_tv = (TextView) convertView.findViewById(R.id.interesting_question_one_read_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(UrlUtils.getUrl(listBeen.get(position).getImg())).asBitmap().into(viewHolder.interesting_question_one_content_img);
        Glide.with(mContext).load(UrlUtils.getUrl(listBeen.get(position).getFace())).asBitmap().into(viewHolder.interesting_question_one_img_headimg);
        viewHolder.interesting_question_one_title_tv.setText(listBeen.get(position).getTitle());
        viewHolder.interesting_question_one_head_tv.setText((CharSequence) listBeen.get(position).getAccount());
        viewHolder.interesting_question_one_location_tv.setText(listBeen.get(position).getCity_id());
        viewHolder.interesting_question_one_zan_tv.setText(listBeen.get(position).getReply_num());
        viewHolder.interesting_question_one_read_tv.setText(listBeen.get(position).getViews());

        return convertView;
    }

    public class ViewHolder {
        TextView interesting_question_one_title_tv;
        TextView interesting_question_one_head_tv;
        TextView interesting_question_one_location_tv;
        TextView interesting_question_one_zan_tv;
        TextView interesting_question_one_read_tv;
        ImageView interesting_question_one_content_img;
        CircleImageView interesting_question_one_img_headimg;


    }
}
