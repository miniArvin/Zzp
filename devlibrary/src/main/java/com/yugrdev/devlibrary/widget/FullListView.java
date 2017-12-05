package com.yugrdev.devlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Name: FullListView
 * Details:
 * Created by PC on 2017/2/27.
 * Update:
 */

public class FullListView extends ListView {
    public FullListView(Context context) {
        this(context, null);
    }

    public FullListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FullListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    /**
     * 测量出ListView整体高度
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
