package com.yugrdev.devlibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Name: FullGridView
 * Details:
 * Created by PC on 2017/5/25.
 * Update:
 */

public class FullGridView extends GridView {
    public FullGridView(Context context) {
        this(context, null);
    }

    public FullGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FullGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    /**
     * 测量出GridView整体高度
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
