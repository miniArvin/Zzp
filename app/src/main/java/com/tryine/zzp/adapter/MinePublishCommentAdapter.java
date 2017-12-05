package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tryine.zzp.R;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7 0007.
 */

public class MinePublishCommentAdapter<T> extends BaseAdapter{
    private final View mParent;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int mType;
    private List<T> mData;

    public MinePublishCommentAdapter(View view,Context context,int type) {
        mLayoutInflater=LayoutInflater.from(context);
        this.mParent=view;
        this.mContext = context;
        this.mType = type;
    }

    @Override
    public int getCount() {
        return mType==0?3:(mType==1?4:(mType==3?5:(mType==5?9:(mType==7?11:(mType==9?3:(mType==11?20:(mType==13?12:0)))))));
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
        if (mType==0) {
            convertView = mLayoutInflater.inflate(R.layout.mine_publish_comment_item, null);
        }else if (mType==1){
            convertView = mLayoutInflater.inflate(R.layout.mine_publish_article_comment_item, null);
        }else if (mType==3){
            convertView = mLayoutInflater.inflate(R.layout.found_interesting_question_item, null);
        }else if (mType==5){
            convertView = mLayoutInflater.inflate(R.layout.hotel_list_item, null);
        }else if (mType==7){
            convertView = mLayoutInflater.inflate(R.layout.distribution_order_item, null);
        }else if (mType==9){
            convertView = mLayoutInflater.inflate(R.layout.mine_member_item, null);
        }else if (mType==11){
            convertView = mLayoutInflater.inflate(R.layout.mine_wallet_item, null);
        }else if (mType==13){
            convertView = mLayoutInflater.inflate(R.layout.mine_wallet_item, null);
        }
        return convertView;
    }
}
