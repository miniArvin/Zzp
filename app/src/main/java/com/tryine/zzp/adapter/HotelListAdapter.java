package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tryine.zzp.R;
import com.tryine.zzp.base.AbsBaseAdapter;
import com.tryine.zzp.base.BaseApplication;
import com.tryine.zzp.entity.test.remote.HotelListEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/12/5 0005.
 */

public class HotelListAdapter extends AbsBaseAdapter<HotelListEntity.InfoBean> {
    private OnAddListener onAddListener;
    private ViewHolder holder;
    private Context mContext;

    public HotelListAdapter(List<HotelListEntity.InfoBean> data,Context context) {
        super(data);
        this.mContext=context;
    }

    @Override
    protected void initData(int position, HotelListEntity.InfoBean data) {
        holder.hotel_list_name_tv.setText(data.getHotel_name());
        holder.hotel_list_address_tv.setText(data.getAddr());
        holder.hotel_list_level_rb.setRating(Float.parseFloat(data.getStar()));
        Glide.with(mContext).load(UrlUtils.getUrl(data.getPhoto())).asBitmap().into(holder.hotel_list_bg_iv);
        holder.hotel_list_comment_tv.setText(data.getComment_count()+"条评论");
    }

    @Override
    protected BaseHolder onCreateViewHolder() {
        holder = new ViewHolder();
        return holder;
    }

    class ViewHolder extends BaseHolder {


        private ImageView hotel_list_bg_iv;
        private ImageView is_read_iv;
        private ImageView is_collect_iv;
        private TextView hotel_list_price_tv;
        private TextView hotel_list_name_tv;
        private TextView hotel_list_address_tv;
        private TextView hotel_list_chinese_comment_tv;
        private TextView hotel_list_score_comment_tv;
        private TextView hotel_list_comment_tv;
        private TextView hotel_list_pai_tv;
        private RatingBar hotel_list_level_rb;

        @Override
        protected View initView() {
            View view = View.inflate(mContext, R.layout.hotel_list_item, null);
            hotel_list_bg_iv = (ImageView) view.findViewById(R.id.hotel_list_bg_iv);
            is_read_iv = (ImageView) view.findViewById(R.id.is_read_iv);
            is_collect_iv = (ImageView) view.findViewById(R.id.is_collect_iv);
            hotel_list_price_tv = (TextView) view.findViewById(R.id.hotel_list_price_tv);
            hotel_list_name_tv = (TextView) view.findViewById(R.id.hotel_list_name_tv);
            hotel_list_address_tv = (TextView) view.findViewById(R.id.hotel_list_address_tv);
            hotel_list_chinese_comment_tv = (TextView) view.findViewById(R.id.hotel_list_chinese_comment_tv);
            hotel_list_score_comment_tv = (TextView) view.findViewById(R.id.hotel_list_score_comment_tv);
            hotel_list_comment_tv = (TextView) view.findViewById(R.id.hotel_list_comment_tv);
            hotel_list_pai_tv = (TextView) view.findViewById(R.id.hotel_list_pai_tv);
            hotel_list_level_rb = (RatingBar) view.findViewById(R.id.hotel_list_level_rb);
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
