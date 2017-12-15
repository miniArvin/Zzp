package com.tryine.zzp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.HotelAllCommentEntity;
import com.tryine.zzp.utils.UrlUtils;
import com.tryine.zzp.widget.NoScrollGirdView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/12/11 0011.
 */

public class HotelCommentAdapter extends RecyclerView.Adapter<HotelCommentAdapter.ViewHolder> {
    private Context context;
    private List<HotelAllCommentEntity.InfoBean.ApplyBean> applyBeen;
    private LayoutInflater inflater;
    private List<HotelAllCommentEntity.InfoBean.ApplyBean.PhotoBean> photoBeen;
    private HotelCommentImgAdapter hotelCommentImgAdapter;

    public HotelCommentAdapter(Context context, List<HotelAllCommentEntity.InfoBean.ApplyBean> applyBeen) {
        inflater=LayoutInflater.from(context);
        this.context = context;
        this.applyBeen = applyBeen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.hotel_detail_all_comment_item,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        photoBeen = new ArrayList<>();
        viewHolder.hotel_detail_comment_gv = (NoScrollGirdView) view.findViewById(R.id.hotel_detail_comment_gv);
        viewHolder.hotel_detail_member_name_tv = (TextView) view.findViewById(R.id.hotel_detail_member_name_tv);
        viewHolder.hotel_detail_member_tv = (TextView) view.findViewById(R.id.hotel_detail_member_tv);
        viewHolder.hotel_detail_comment_publish_time_tv = (TextView) view.findViewById(R.id.hotel_detail_comment_publish_time_tv);
        viewHolder.hotel_detail_comment_tv = (TextView) view.findViewById(R.id.hotel_detail_comment_tv);
        viewHolder.hotel_detail_member_iv = (ImageView) view.findViewById(R.id.hotel_detail_member_iv);
        viewHolder.hotel_detail_comment_rb = (RatingBar) view.findViewById(R.id.hotel_detail_comment_rb);
        viewHolder.hotel_detail_head_cv = (CircleImageView) view.findViewById(R.id.hotel_detail_head_cv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        photoBeen = applyBeen.get(position).getPhoto();
        Glide.with(context).load(UrlUtils.getUrl(applyBeen.get(position).getFace())).asBitmap().centerCrop().into(holder.hotel_detail_head_cv);
        holder.hotel_detail_member_name_tv.setText(applyBeen.get(position).getNickname());
        holder.hotel_detail_member_tv.setText(applyBeen.get(position).getRank_name());
        holder.hotel_detail_comment_publish_time_tv.setText(applyBeen.get(position).getCreate_time());
        holder.hotel_detail_comment_tv.setText(applyBeen.get(position).getContent());
        holder.hotel_detail_comment_rb.setRating(Float.parseFloat(applyBeen.get(position).getScore()));
        hotelCommentImgAdapter =new HotelCommentImgAdapter(context,photoBeen);
        holder.hotel_detail_comment_gv.setAdapter(hotelCommentImgAdapter);
    }

    @Override
    public int getItemCount() {
        return applyBeen==null?0:applyBeen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
        CircleImageView hotel_detail_head_cv;
        TextView hotel_detail_member_name_tv;
        TextView hotel_detail_member_tv;
        TextView hotel_detail_comment_publish_time_tv;
        TextView hotel_detail_comment_tv;
        ImageView hotel_detail_member_iv;
        RatingBar hotel_detail_comment_rb;
        NoScrollGirdView hotel_detail_comment_gv;
    }
}
