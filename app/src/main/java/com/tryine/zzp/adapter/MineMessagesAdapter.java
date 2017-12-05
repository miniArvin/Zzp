package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.HelpCenter;

import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2017/11/7 0007.
 */

public class MineMessagesAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int mType;
    private List<HelpCenter.ListBean> helpCenters;

    public MineMessagesAdapter(Context context, int type, List<HelpCenter.ListBean> objects) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mType = type;
        this.helpCenters = objects;
    }

    @Override
    public int getCount() {
        return helpCenters.size();
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
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            if (mType == 1) {
                convertView = mLayoutInflater.inflate(R.layout.mine_message_item, null);
            } else if (mType == 2) {
                convertView = mLayoutInflater.inflate(R.layout.help_cneter_item, null);
                viewHolder.help_center_item_tv= (TextView) convertView.findViewById(R.id.help_center_item_tv);
            }
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.help_center_item_tv.setText(helpCenters.get(position).getTitle());
        return convertView;
    }

    public class ViewHolder {
        TextView help_center_item_tv;
    }
}
