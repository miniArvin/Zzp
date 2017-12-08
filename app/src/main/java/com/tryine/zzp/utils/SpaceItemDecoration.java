package com.tryine.zzp.utils;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/11/3 0003.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private int mOrientation;

    public SpaceItemDecoration(int space,int orientation) {
        this.space = space;
        setOrientation(orientation);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, space);
        } else {
            outRect.set(0, 0, space, 0);
        }
    }
    private void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientaion");
        }
        mOrientation = orientation;
    }
}
