package com.yugrdev.devlibrary.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 项目名称：DevPKG
 * 类：RefreshRecyclerView
 * 描述：
 * 创建人：Yugr
 * 创建日期：2017/1/17
 * 时间：14:27
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class RefreshRecyclerView extends SwipeRefreshLayout {
    private Context mContext;
    private RecyclerView recyclerView;

    public RefreshRecyclerView(Context context) {
        this(context, null);
    }

    public RefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initRecyclerView();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private void initRecyclerView() {
        recyclerView = new RecyclerView(mContext);
        recyclerView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT));
        this.addView(recyclerView);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }

    public void setOnRefreshListener(OnRefreshListener listener) {
        super.setOnRefreshListener(listener);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    public void setRefreshing(boolean refreshing) {
        super.setRefreshing(refreshing);
    }
}
