package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tryine.zzp.R;

/**
 * Created by Administrator on 2017/11/10 0010.
 */

public class FoundDetailQuestionAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public FoundDetailQuestionAdapter(Context mContext) {
        mLayoutInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 20;
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
        if (position == 0) {
            convertView = mLayoutInflater.inflate(R.layout.found_interesting_question_head_item, null);
        } else {
            convertView = mLayoutInflater.inflate(R.layout.found_interesting_question_item, null);
        }
        return convertView;
    }
}
