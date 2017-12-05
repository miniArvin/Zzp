package com.tryine.zzp.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: AbsBaseAdapter
 * Details:
 * Created by PC on 2017/2/27.
 * Update:
 */

public abstract class AbsBaseAdapter<T> extends BaseAdapter {
    protected List<T> mData = new ArrayList<>();
    protected BaseHolder baseHolder;

    public AbsBaseAdapter(List<T> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null) {
            baseHolder = (BaseHolder) convertView.getTag();
        } else {
            baseHolder = onCreateViewHolder();
        }
        initData(position, mData.get(position));
        return baseHolder.rootView;
    }

    protected abstract void initData(int position, T data);

    protected abstract BaseHolder onCreateViewHolder();


    public abstract class BaseHolder {
        public final View rootView;

        public BaseHolder() {
            rootView = initView();
            rootView.setTag(this);
        }
        protected abstract View initView();
    }

}
