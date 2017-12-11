package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.HotelListEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;
/**
 * Created by Administrator on 2017/12/5 0005.
 */

public class HotelListAdapter extends BaseAdapter {
    private OnAddListener onAddListener;
    private Context mContext;
    private int fav;
    private LayoutInflater inflater;
    private List<HotelListEntity.InfoBean> mData;

    public HotelListAdapter(Context context, List<HotelListEntity.InfoBean> data) {
        inflater= LayoutInflater.from(context);
        this.mContext = context;
        this.mData = data;
    }


    @Override
    public int getCount() {
        return mData==null?0:mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            viewHolder=new ViewHolder();
            convertView = inflater.inflate(R.layout.hotel_list_item, null);
            viewHolder.hotel_list_bg_iv = (ImageView) convertView.findViewById(R.id.hotel_list_bg_iv);
            viewHolder.is_read_iv = (ImageView) convertView.findViewById(R.id.is_read_iv);
            viewHolder.is_collect_iv = (ImageView) convertView.findViewById(R.id.is_collect_iv);
            viewHolder.hotel_list_price_tv = (TextView) convertView.findViewById(R.id.hotel_list_price_tv);
            viewHolder.hotel_list_name_tv = (TextView) convertView.findViewById(R.id.hotel_list_name_tv);
            viewHolder.hotel_list_address_tv = (TextView) convertView.findViewById(R.id.hotel_list_address_tv);
            viewHolder.hotel_list_chinese_comment_tv = (TextView) convertView.findViewById(R.id.hotel_list_chinese_comment_tv);
            viewHolder.hotel_list_score_comment_tv = (TextView) convertView.findViewById(R.id.hotel_list_score_comment_tv);
            viewHolder.hotel_list_comment_tv = (TextView) convertView.findViewById(R.id.hotel_list_comment_tv);
            viewHolder.hotel_list_pai_tv = (TextView) convertView.findViewById(R.id.hotel_list_pai_tv);
            viewHolder.hotel_list_level_rb = (RatingBar) convertView.findViewById(R.id.hotel_list_level_rb);
            viewHolder.is_collect_iv.setOnClickListener(mOnClickListener);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.is_collect_iv.setTag(position);

        viewHolder.hotel_list_name_tv.setText(mData.get(position).getHotel_name());
        viewHolder.hotel_list_address_tv.setText(mData.get(position).getAddr());
        viewHolder.hotel_list_level_rb.setRating((float) mData.get(position).getComment_score());
        Glide.with(mContext).load(UrlUtils.getUrl(mData.get(position).getPhoto())).asBitmap().into(viewHolder.hotel_list_bg_iv);
        viewHolder.hotel_list_comment_tv.setText(mData.get(position).getComment_count() + "条评论");
        fav = mData.get(position).getFav();
        if (fav==0) {
            viewHolder.is_collect_iv.setImageResource(R.drawable.hotel_list_not_collect_icon);
        } else {
            viewHolder.is_collect_iv.setImageResource(R.drawable.hotel_list_collect_icon);
        }

        convertView(convertView, mData);
        return convertView;
    }


    class ViewHolder {

        ImageView hotel_list_bg_iv;
        ImageView is_read_iv;
        ImageView is_collect_iv;
        TextView hotel_list_price_tv;
        TextView hotel_list_name_tv;
        TextView hotel_list_address_tv;
        TextView hotel_list_chinese_comment_tv;
        TextView hotel_list_score_comment_tv;
        TextView hotel_list_comment_tv;
        TextView hotel_list_pai_tv;
        RatingBar hotel_list_level_rb;
    }

    public void setAddListener(OnAddListener listener) {
        this.onAddListener = listener;
    }

    public interface OnAddListener {
        void onCollect(View v, int position);
    }

    private  View.OnClickListener mOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (onAddListener != null) {
                int position = (Integer) v.getTag();
                switch (v.getId()) {
                    case R.id.is_collect_iv:
                        onAddListener.onCollect(v,position);
                        break;
                }
            }
        }
    };

    /**
     * 需要去实现的对item中的view的设置操作
     *
     */
    public void convertView(View item, List<HotelListEntity.InfoBean> mData){

    }

    /**
     * 第三种方法 调用一次getView()方法,比较省事，谷歌推荐
     *
     * @param position 要更新的位置
     */
    public void updateItem(ListView listView,int position) {
        /**第一个可见的位置**/
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        /**最后一个可见的位置**/
        int lastVisiblePosition = listView.getLastVisiblePosition();

        /**在看见范围内才更新，不可见的滑动后自动会调用getView方法更新**/
        if (position >= firstVisiblePosition && position <= lastVisiblePosition) {
            /**获取指定位置view对象**/
            View view = listView.getChildAt(position - firstVisiblePosition);
            getView(position, view, listView);
        }

    }

}
