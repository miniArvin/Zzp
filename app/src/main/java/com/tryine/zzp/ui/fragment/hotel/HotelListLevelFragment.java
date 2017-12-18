package com.tryine.zzp.ui.fragment.hotel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelListLevelDialogAdapter;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.widget.NoScrollGirdView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelListLevelFragment extends BaseFragment {
    private List<String> levelPriceList;
    private List<String> levelStarList;
    private NoScrollGirdView hotel_list_level_price_gv;
    private NoScrollGirdView hotel_list_level_star_gv;
    private HotelListLevelDialogAdapter hotelListLevelPrice;
    private HotelListLevelDialogAdapter hotelListLevelStar;
    private String starPos;
    private String pricePos;
    private String starKey;
    private String priceKey;
    public HotelListLevelFragment() {

    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.hotel_level_dialog;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        initView();
    }

    public void initView(){
        hotelListLevelPrice = new HotelListLevelDialogAdapter(mContext, levelPriceList, 1);
        hotel_list_level_price_gv.setAdapter(hotelListLevelPrice);
        hotelListLevelPrice.setDefSelect(0);
        hotelListLevelStar = new HotelListLevelDialogAdapter(mContext, levelStarList, 2);
        hotel_list_level_star_gv.setAdapter(hotelListLevelStar);
        hotelListLevelStar.setDefSelect(0);
        hotel_list_level_price_gv = (NoScrollGirdView) mView.findViewById(R.id.hotel_list_level_price_gv);
        hotel_list_level_star_gv = (NoScrollGirdView) mView.findViewById(R.id.hotel_list_level_star_gv);
        hotel_list_level_star_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    starPos="";
                }else if (position==1){
                    starPos="5";
                }else if (position==2){
                    starPos="4";
                }else if (position==3){
                    starPos="3";
                }else if (position==4){
                    starPos="2";
                }else if (position==5){
                    starPos="1";
                }
                starKey = "star";
                hotelListLevelStar.setDefSelect(position);
            }
        });
        hotel_list_level_price_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                hotelListLevelPrice.setDefSelect(position);
                priceKey = "price";
                pricePos = (position + 1) + "";
            }
        });
    }

    public void locationData() {

        levelPriceList = new ArrayList<>();
        levelPriceList.add("不限");
        levelPriceList.add("￥100以下");
        levelPriceList.add("￥101-￥200");
        levelPriceList.add("￥201-￥300");
        levelPriceList.add("￥301-￥450");
        levelPriceList.add("￥451-￥600");
        levelPriceList.add("￥601-￥1000");
        levelPriceList.add("￥1001-￥2000");
        levelPriceList.add("￥2001-￥3000");
        levelPriceList.add("￥3000以上");
        levelStarList = new ArrayList<>();
        levelStarList.add("不限");
        levelStarList.add("一星级");
        levelStarList.add("二星级");
        levelStarList.add("三星级");
        levelStarList.add("四星级");
        levelStarList.add("五星级");
        hotelListLevelStar.setDefSelect(0);
        hotelListLevelPrice.setDefSelect(0);
    }

}
