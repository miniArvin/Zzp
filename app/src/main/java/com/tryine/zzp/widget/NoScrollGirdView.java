package com.tryine.zzp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListView;

/**
 * Created by admin on 2016/7/18.
 */
public class NoScrollGirdView extends GridView {
    public NoScrollGirdView(Context context) {
        super(context);
    }

    public NoScrollGirdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollGirdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    /**
     * 重写该方法，达到使GridView适应ScrollView的效果
     */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
