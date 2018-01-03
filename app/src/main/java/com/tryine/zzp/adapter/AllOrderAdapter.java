package com.tryine.zzp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.AllOrderEntity;
import com.tryine.zzp.utils.UrlUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27 0027.
 */

public class AllOrderAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<AllOrderEntity.InfoBean.ListBean> listBeen;
    private String state;

    public AllOrderAdapter( Context mContext,List<AllOrderEntity.InfoBean.ListBean> listBeen) {
        mLayoutInflater=LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.listBeen=listBeen;
    }

    @Override
    public int getCount() {
        return listBeen==null?0:listBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return listBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        convertView=mLayoutInflater.inflate(R.layout.all_order_item,null);
        viewHolder.all_order_comment_order_cancel_tv = (TextView) convertView.findViewById(R.id.all_order_comment_order_do_tv);
        viewHolder.all_order_comment_order_num_tv = (TextView) convertView.findViewById(R.id.all_order_comment_order_num_tv);
        viewHolder.all_order_comment_order_title_tv = (TextView) convertView.findViewById(R.id.all_order_comment_order_title_tv);
        viewHolder.all_order_comment_order_location_tv = (TextView) convertView.findViewById(R.id.all_order_comment_order_location_tv);
        viewHolder.all_order_comment_order_detail_tv = (TextView) convertView.findViewById(R.id.all_order_comment_order_detail_tv);
        viewHolder.all_order_comment_order_price_tv = (TextView) convertView.findViewById(R.id.all_order_comment_order_price_tv);
        viewHolder.all_order_comment_order_state_tv = (TextView) convertView.findViewById(R.id.all_order_comment_order_state_tv);
        viewHolder.all_order_comment_order_do_tv = (TextView) convertView.findViewById(R.id.all_order_comment_order_do_tv);
        viewHolder.all_order_comment_order_create_tv = (TextView) convertView.findViewById(R.id.all_order_comment_order_create_tv);
        viewHolder.all_order_comment_order_img_iv = (ImageView) convertView.findViewById(R.id.all_order_comment_order_img_iv);
        viewHolder.all_order_comment_order_level_rb = (RatingBar) convertView.findViewById(R.id.all_order_comment_order_level_rb);
        state = listBeen.get(position).getOrder_status();
        viewHolder.all_order_comment_order_state_tv.setText(state);
        if (state.equals("待付款")){
            viewHolder.all_order_comment_order_state_tv.setTextColor(mContext.getResources().getColor(R.color.all_order_obligation));
            viewHolder.all_order_comment_order_cancel_tv.setText("取消订单");
            viewHolder.all_order_comment_order_do_tv.setText("立即支付");
            viewHolder.all_order_comment_order_do_tv.setBackground(mContext.getResources().getDrawable(R.drawable.all_order_payment_bg_btn));
            viewHolder.all_order_comment_order_do_tv.setTextColor(mContext.getResources().getColor(R.color.white));
        }else if (state.equals("待点评")){
            viewHolder.all_order_comment_order_state_tv.setTextColor(mContext.getResources().getColor(R.color.orange));
            viewHolder.all_order_comment_order_cancel_tv.setVisibility(View.GONE);
            viewHolder.all_order_comment_order_do_tv.setText("立即点评");
            viewHolder.all_order_comment_order_do_tv.setBackground(mContext.getResources().getDrawable(R.drawable.all_order_comment_bg_btn));
            viewHolder.all_order_comment_order_do_tv.setTextColor(mContext.getResources().getColor(R.color.white));
        }else if (state.equals("待入住")){
            viewHolder.all_order_comment_order_state_tv.setTextColor(mContext.getResources().getColor(R.color.all_order_not_check_word_bg));
            viewHolder.all_order_comment_order_cancel_tv.setVisibility(View.GONE);
            viewHolder.all_order_comment_order_do_tv.setText("申请退款");
            viewHolder.all_order_comment_order_do_tv.setBackground(mContext.getResources().getDrawable(R.drawable.order_bg_gray));
            viewHolder.all_order_comment_order_do_tv.setTextColor(mContext.getResources().getColor(R.color.white));
        }else if (state.equals("已完成")) {
            viewHolder.all_order_comment_order_state_tv.setTextColor(mContext.getResources().getColor(R.color.all_order_default_word));
            viewHolder.all_order_comment_order_cancel_tv.setVisibility(View.GONE);
            viewHolder.all_order_comment_order_do_tv.setText("再次预定");
            viewHolder.all_order_comment_order_do_tv.setBackground(mContext.getResources().getDrawable(R.drawable.login_bg_look));
            viewHolder.all_order_comment_order_do_tv.setTextColor(mContext.getResources().getColor(R.color.orange));
        }else if (state.equals("待确认")){
            viewHolder.all_order_comment_order_do_tv.setText("申请退款");
            viewHolder.all_order_comment_order_cancel_tv.setVisibility(View.GONE);
            viewHolder.all_order_comment_order_do_tv.setBackground(mContext.getResources().getDrawable(R.drawable.order_bg_gray));
            viewHolder.all_order_comment_order_do_tv.setTextColor(mContext.getResources().getColor(R.color.white));
        }else if (state.equals("已取消")){
            viewHolder.all_order_comment_order_do_tv.setText("删除订单");
            viewHolder.all_order_comment_order_cancel_tv.setVisibility(View.GONE);
            viewHolder.all_order_comment_order_do_tv.setBackground(mContext.getResources().getDrawable(R.drawable.order_bg_red));
            viewHolder.all_order_comment_order_do_tv.setTextColor(mContext.getResources().getColor(R.color.white));
        }else if (state.equals("审核通过")){
            viewHolder.all_order_comment_order_do_tv.setText("退款详情");
            viewHolder.all_order_comment_order_cancel_tv.setVisibility(View.GONE);
            viewHolder.all_order_comment_order_do_tv.setBackground(mContext.getResources().getDrawable(R.drawable.order_bg_red));
            viewHolder.all_order_comment_order_do_tv.setTextColor(mContext.getResources().getColor(R.color.white));
        }
        viewHolder.all_order_comment_order_num_tv.setText(listBeen.get(position).getOrder_sn());
        viewHolder.all_order_comment_order_create_tv.setText(listBeen.get(position).getCreate_time());
        viewHolder.all_order_comment_order_title_tv.setText(listBeen.get(position).getHotel_name());
        viewHolder.all_order_comment_order_price_tv.setText("￥"+listBeen.get(position).getAmount());
        viewHolder.all_order_comment_order_location_tv.setText(listBeen.get(position).getAddr());
        viewHolder.all_order_comment_order_detail_tv.setText(listBeen.get(position).getStime()+"至"+listBeen.get(position).getLtime()+"  "+listBeen.get(position).getTime_num()+"晚/"+listBeen.get(position).getNum()+"间("+listBeen.get(position).getBreakfast()+")");
        Glide.with(mContext).load(UrlUtils.getUrl(listBeen.get(position).getPhoto())).asBitmap().into(viewHolder.all_order_comment_order_img_iv);
        return convertView;
    }

    public class ViewHolder {
        TextView all_order_comment_order_num_tv;
        TextView all_order_comment_order_create_tv;
        TextView all_order_comment_order_title_tv;
        TextView all_order_comment_order_location_tv;
        TextView all_order_comment_order_detail_tv;
        TextView all_order_comment_order_price_tv;
        TextView all_order_comment_order_state_tv;
        TextView all_order_comment_order_cancel_tv;
        TextView all_order_comment_order_do_tv;
        ImageView all_order_comment_order_img_iv;
        RatingBar all_order_comment_order_level_rb;
    }
}
