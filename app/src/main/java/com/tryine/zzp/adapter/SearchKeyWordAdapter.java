package com.tryine.zzp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tryine.zzp.R;

import java.util.List;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class SearchKeyWordAdapter extends RecyclerView.Adapter<SearchKeyWordAdapter.ViewHolder> {
    private List<String> list;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public SearchKeyWordAdapter(List<String> list, Context mContext) {
        mLayoutInflater=LayoutInflater.from(mContext);
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.search_key_word_item,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.search_key_word_tv = (TextView) view
                .findViewById(R.id.search_key_word_tv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView textView=holder.search_key_word_tv;
        if (position%2==0){
            textView.setBackgroundResource(R.drawable.search_key_word_item_bg);

        }
        textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView search_key_word_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            search_key_word_tv = (TextView) itemView.findViewById(R.id.search_key_word_tv);
        }
    }

}
