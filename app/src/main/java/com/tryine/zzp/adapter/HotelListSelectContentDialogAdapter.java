package com.tryine.zzp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.HotelListSelectEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/7 0007.
 */

public class HotelListSelectContentDialogAdapter extends RecyclerView.Adapter<HotelListSelectContentDialogAdapter.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    private List<HotelListSelectEntity.InfoBean> mData;

    public HotelListSelectContentDialogAdapter(Context mContext, List<HotelListSelectEntity.InfoBean> mData) {
        inflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.hotel_list_select_item,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.hotel_list_select_item_tv = (TextView) view.findViewById(R.id.hotel_list_select_item_tv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.hotel_list_select_item_tv.setGravity(View.FOCUS_LEFT);
        holder.hotel_list_select_item_tv.setText("");
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
        TextView hotel_list_select_item_tv;
    }
}
