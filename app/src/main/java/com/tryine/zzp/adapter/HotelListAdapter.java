package com.tryine.zzp.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.base.AbsBaseAdapter;
import com.tryine.zzp.base.BaseApplication;
import com.tryine.zzp.entity.test.remote.HotelListEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/5 0005.
 */

public class HotelListAdapter extends AbsBaseAdapter<HotelListEntity.InfoBean> {
    private OnAddListener onAddListener;
    private ViewHolder holder;
    public HotelListAdapter(List<HotelListEntity.InfoBean> data) {
        super(data);
    }

    @Override
    protected void initData(int position, HotelListEntity.InfoBean data) {

    }

    @Override
    protected BaseHolder onCreateViewHolder() {
        return null;
    }
    class ViewHolder extends BaseHolder {


        private TextView textMarketPrice;
        private TextView textPrice;
        private ImageButton btAdd;

        @Override
        protected View initView() {
            View view = View.inflate(BaseApplication.getInstance(), R.layout.hotel_list_item, null);

            return view;
        }
    }

    public void setAddListener(OnAddListener listener) {
        this.onAddListener = listener;
    }

    public interface OnAddListener {
        void onAdd(View v, int position);
    }
}
