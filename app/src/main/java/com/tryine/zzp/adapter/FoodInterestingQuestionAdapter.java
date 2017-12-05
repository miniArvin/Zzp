package com.tryine.zzp.adapter;

import com.tryine.zzp.base.AbsBaseAdapter;
import com.tryine.zzp.entity.test.TestEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class FoodInterestingQuestionAdapter extends AbsBaseAdapter<TestEntity> {

    public FoodInterestingQuestionAdapter(List<TestEntity> data) {
        super(data);
    }

    @Override
    protected void initData(int position, TestEntity data) {

    }

    @Override
    protected BaseHolder onCreateViewHolder() {
        return null;
    }
}
