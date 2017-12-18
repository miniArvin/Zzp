package com.tryine.zzp.ui.fragment.hotel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelListSelectContentDialogAdapter;
import com.tryine.zzp.adapter.HotelListSelectDialogAdapter;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.entity.test.remote.HotelListSelectEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelListSelectFragment extends BaseFragment {
    private HotelListSelectDialogAdapter hotelListSelectDialogAdapter;
    private ListView hotel_list_select_lv;
    private ListView hotel_list_select_content_lv;
    private int content = 0;
    private TextView hotel_list_select_tv;
    private List<String> selectList;
    private HotelListSelectContentDialogAdapter hotelListSelectContentDialogAdapter;
    public HotelListSelectFragment() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.hotel_list_select_dialog;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
            initView();
    }

    public void initView(){
        selectList = new ArrayList<>();
        selectList.add("住宿类型");
        selectList.add("品牌");
        selectList.add("酒店设备");
        hotel_list_select_lv = (ListView) mView.findViewById(R.id.hotel_list_select_lv);
        hotel_list_select_content_lv = (ListView) mView.findViewById(R.id.hotel_list_select_content_lv);
        hotel_list_select_tv = (TextView) mView.findViewById(R.id.hotel_list_select_tv);
        hotelListSelectDialogAdapter = new HotelListSelectDialogAdapter(mContext, selectList);
        hotel_list_select_lv.setAdapter(hotelListSelectDialogAdapter);
        hotelListSelectDialogAdapter.setDefSelect(0);
        hotel_list_select_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    content = 0;
                    hotelListSelectDialogAdapter.setDefSelect(position);
                    hotelListSelectContentData(null, null, null);
                } else if (position == 1) {
                    content = 1;
                    hotelListSelectDialogAdapter.setDefSelect(position);
                    hotelListSelectContentData(null, null, null);
                } else if (position == 2) {
                    content = 2;
                    hotelListSelectDialogAdapter.setDefSelect(position);
                    hotelListSelectContentData(null, null, null);
                }
            }
        });
    }

    public void hotelListSelectContentData(List<HotelListSelectEntity.InfoBean.RoomBean> roomBeen,
                                           List<HotelListSelectEntity.InfoBean.BrandBean> brandBeen,
                                           List<HotelListSelectEntity.InfoBean.ServiceBean> serviceBeen) {
        hotelListSelectContentDialogAdapter=null;
        hotelListSelectContentDialogAdapter = new HotelListSelectContentDialogAdapter(mContext, roomBeen, serviceBeen, brandBeen);
        hotel_list_select_content_lv.setAdapter(hotelListSelectContentDialogAdapter);
        hotel_list_select_content_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (content == 0) {

                } else if (content == 1) {

                } else if (content == 2) {

                }
            }
        });
    }

}
