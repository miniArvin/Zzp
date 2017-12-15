package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.HotelDetailRoomEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/12 0012.
 */

public class HotelDetailDialogRoomAdapter extends BaseAdapter {
    private Context context;
    private List<HotelDetailRoomEntity.InfoBean.PolicyBean> policyBeen;
    private List<HotelDetailRoomEntity.InfoBean.FacilitiesBean> facilitiesBeen;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;

    public HotelDetailDialogRoomAdapter(Context context, List<HotelDetailRoomEntity.InfoBean.PolicyBean> policyBeen, List<HotelDetailRoomEntity.InfoBean.FacilitiesBean> facilitiesBeen) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.policyBeen = policyBeen;
        this.facilitiesBeen = facilitiesBeen;
    }

    @Override
    public int getCount() {
        return policyBeen!=null?policyBeen.size():(facilitiesBeen!=null?facilitiesBeen.size():0);
    }

    @Override
    public Object getItem(int position) {
        return policyBeen==null?facilitiesBeen.get(position):policyBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = new ViewHolder();
        convertView = inflater.inflate(R.layout.hotel_detail_dialog_policy_item,null);
        viewHolder.hotel_detail_dialog_policy_title_tv = (TextView) convertView.findViewById(R.id.hotel_detail_dialog_policy_title_tv);
        viewHolder.hotel_detail_dialog_policy_content_tv = (TextView) convertView.findViewById(R.id.hotel_detail_dialog_policy_content_tv);

        if (policyBeen!=null){
            viewHolder.hotel_detail_dialog_policy_title_tv.setText(policyBeen.get(position).getKey_name());
            viewHolder.hotel_detail_dialog_policy_content_tv.setText(policyBeen.get(position).getKey_value());
        }else {
            viewHolder.hotel_detail_dialog_policy_title_tv.setText(facilitiesBeen.get(position).getKey_name());
            viewHolder.hotel_detail_dialog_policy_content_tv.setText(facilitiesBeen.get(position).getKey_value());
        }
        return convertView;
    }

    public class ViewHolder{
        TextView hotel_detail_dialog_policy_title_tv;
        TextView hotel_detail_dialog_policy_content_tv;
    }
}
