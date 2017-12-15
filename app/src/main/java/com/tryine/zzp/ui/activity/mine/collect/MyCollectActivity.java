package com.tryine.zzp.ui.activity.mine.collect;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MineCollectArticleAdapter;
import com.tryine.zzp.adapter.MineCollectHotelAdapter;
import com.tryine.zzp.base.BaseStatusMActivity;

public class MyCollectActivity extends BaseStatusMActivity implements View.OnClickListener {
    private ListView mine_collect_lv;
    private MineCollectHotelAdapter mineCollectHotelAdapter;
    private MineCollectArticleAdapter mineCollectArticleAdapter;
    private LinearLayout mine_collect_hotel_ll;
    private LinearLayout mine_collect_article_ll;
    private LinearLayout mine_collect_good_ll;
    private TextView mine_collect_hotel_tv;
    private TextView mine_collect_article_tv;
    private TextView mine_collect_good_tv;
    private View mine_collect_hotel_v;
    private View mine_collect_article_v;
    private View mine_collect_good_v;
    int type=0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_collect;
    }

    @Override
    protected void afterOnCreate() {
        initView();
    }

    public void initView(){
        mine_collect_lv= (ListView) findViewById(R.id.mine_collect_lv);
        mineCollectHotelAdapter=new MineCollectHotelAdapter(this);
        mineCollectArticleAdapter=new MineCollectArticleAdapter(this);
        mine_collect_lv.setAdapter(mineCollectHotelAdapter);
        mine_collect_good_ll= (LinearLayout) findViewById(R.id.mine_collect_good_ll);
        mine_collect_article_ll= (LinearLayout) findViewById(R.id.mine_collect_article_ll);
        mine_collect_hotel_ll= (LinearLayout) findViewById(R.id.mine_collect_hotel_ll);
        mine_collect_hotel_tv= (TextView) findViewById(R.id.mine_collect_hotel_tv);
        mine_collect_article_tv= (TextView) findViewById(R.id.mine_collect_article_tv);
        mine_collect_good_tv= (TextView) findViewById(R.id.mine_collect_good_tv);
        mine_collect_hotel_v=findViewById(R.id.mine_collect_hotel_v);
        mine_collect_article_v=findViewById(R.id.mine_collect_article_v);
        mine_collect_good_v=findViewById(R.id.mine_collect_good_v);
        mine_collect_good_ll.setOnClickListener(this);
        mine_collect_article_ll.setOnClickListener(this);
        mine_collect_hotel_ll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_collect_hotel_ll:
                if (mine_collect_hotel_v.getVisibility()==View.VISIBLE){
                    return;
                }else {
                    mine_collect_hotel_v.setVisibility(View.VISIBLE);
                    mine_collect_article_v.setVisibility(View.GONE);
                    mine_collect_hotel_tv.setTextColor(getResources().getColor(R.color.orange));
                    mine_collect_article_tv.setTextColor(getResources().getColor(R.color.home_location_word));
                    mine_collect_lv.setAdapter(mineCollectHotelAdapter);
                    mineCollectHotelAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.mine_collect_article_ll:
                if (mine_collect_article_v.getVisibility()==View.VISIBLE){
                    return;
                }else {
                    mine_collect_article_v.setVisibility(View.VISIBLE);
                    mine_collect_hotel_v.setVisibility(View.GONE);
                    mine_collect_article_tv.setTextColor(getResources().getColor(R.color.orange));
                    mine_collect_hotel_tv.setTextColor(getResources().getColor(R.color.home_location_word));
                    mine_collect_lv.setAdapter(mineCollectArticleAdapter);
                    mineCollectArticleAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.mine_collect_good_ll:
                break;
            default:
                break;
        }
    }
}
