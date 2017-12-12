package com.tryine.zzp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.entity.test.remote.HotelDetailEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/11 0011.
 */

public class HotelDetailCommentTagAdapter extends RecyclerView.Adapter<HotelDetailCommentTagAdapter.ViewHolder> {
    private Context context;
    private List<HotelDetailEntity.InfoBean.TagBeanX> tagBeanXes;
    private LayoutInflater inflater;

    public HotelDetailCommentTagAdapter(Context context, List<HotelDetailEntity.InfoBean.TagBeanX> tagBeanXes) {
        inflater=LayoutInflater.from(context);
        this.context = context;
        this.tagBeanXes = tagBeanXes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.search_key_word_item,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.search_key_word_tv = (TextView) view
                .findViewById(R.id.search_key_word_tv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.search_key_word_tv.setText(tagBeanXes.get(position).getTag_name());
        holder.search_key_word_tv.setBackgroundResource(R.drawable.search_key_word_item_bg);

    }

    @Override
    public int getItemCount() {
        return tagBeanXes==null?0:tagBeanXes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
        private TextView search_key_word_tv;
    }
}
