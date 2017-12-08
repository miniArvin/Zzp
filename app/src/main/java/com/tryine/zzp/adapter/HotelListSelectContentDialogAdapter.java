package com.tryine.zzp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.HotelListSelectEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/7 0007.
 */

public class HotelListSelectContentDialogAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<HotelListSelectEntity.InfoBean.RoomBean> roomBeen;
    private List<HotelListSelectEntity.InfoBean.ServiceBean> serviceBeen;
    private List<HotelListSelectEntity.InfoBean.BrandBean> brandBeen;

    public HotelListSelectContentDialogAdapter(Context mContext,
                                               List<HotelListSelectEntity.InfoBean.RoomBean> roomBeen,
                                               List<HotelListSelectEntity.InfoBean.ServiceBean> serviceBeen,
                                               List<HotelListSelectEntity.InfoBean.BrandBean> brandBeen) {
        inflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.roomBeen = roomBeen;
        this.serviceBeen = serviceBeen;
        this.brandBeen = brandBeen;
    }


    @Override
    public int getCount() {
        return roomBeen==null?(brandBeen==null?(serviceBeen==null?0:serviceBeen.size()):brandBeen.size()):roomBeen.size();
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
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.hotel_list_select_item, null);
            viewHolder.hotel_list_select_item_tv = (TextView) convertView.findViewById(R.id.hotel_list_select_item_tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (roomBeen!=null){
            viewHolder.hotel_list_select_item_tv.setText(roomBeen.get(position).getTitle());
        }else if(brandBeen!=null){
            viewHolder.hotel_list_select_item_tv.setText(brandBeen.get(position).getTitle());
        }else if(serviceBeen!=null){
            viewHolder.hotel_list_select_item_tv.setText(serviceBeen.get(position).getName());
        }
        return convertView;
    }

    public class ViewHolder {
        TextView hotel_list_select_item_tv;
    }
}
