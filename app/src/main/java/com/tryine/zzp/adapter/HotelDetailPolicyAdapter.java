package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.HotelDetailEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/11 0011.
 */

public class HotelDetailPolicyAdapter extends BaseAdapter {
    private Context context;
    private List<HotelDetailEntity.InfoBean.PolicyBean> policyBeen;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;

    public HotelDetailPolicyAdapter(Context context, List<HotelDetailEntity.InfoBean.PolicyBean> policyBeen) {
        inflater=LayoutInflater.from(context);
        this.context = context;
        this.policyBeen = policyBeen;
    }

    @Override
    public int getCount() {
        return policyBeen==null?0:policyBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return policyBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = new ViewHolder();
        convertView = inflater.inflate(R.layout.hotel_detail_policy_item,null);
        viewHolder.hotel_detail_policy_content_tv = (TextView) convertView.findViewById(R.id.hotel_detail_policy_content_tv);
        viewHolder.hotel_detail_policy_title_tv = (TextView) convertView.findViewById(R.id.hotel_detail_policy_title_tv);

        viewHolder.hotel_detail_policy_content_tv.setText(policyBeen.get(position).getKey_value());
        viewHolder.hotel_detail_policy_title_tv.setText(policyBeen.get(position).getKey_name());
        return convertView;
    }

    public class ViewHolder{
        private TextView hotel_detail_policy_title_tv;
        private TextView hotel_detail_policy_content_tv;
    }
}
