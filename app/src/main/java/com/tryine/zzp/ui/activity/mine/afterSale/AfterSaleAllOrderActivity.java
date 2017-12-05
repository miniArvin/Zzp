package com.tryine.zzp.ui.activity.mine.afterSale;


import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MineAfterSaleAllOrderAdapter;
import com.tryine.zzp.base.BaseStatusMActivity;

public class AfterSaleAllOrderActivity extends BaseStatusMActivity  {
    private ListView mine_after_sale_all_lv;
    private MineAfterSaleAllOrderAdapter mineAfterSaleAllOrderAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_after_sale_all_order;
    }

    @Override
    protected void afterOnCreate() {

    }

    public void init(){
        mine_after_sale_all_lv= (ListView) findViewById(R.id.mine_after_sale_all_lv);
        mineAfterSaleAllOrderAdapter=new MineAfterSaleAllOrderAdapter(this);
        mine_after_sale_all_lv.setAdapter(mineAfterSaleAllOrderAdapter);
    }

}
