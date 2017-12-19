package com.tryine.zzp.ui.fragment.hotel;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelListSelectDialogAdapter;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelListSelectFragment extends BaseFragment implements View.OnClickListener{
    private HotelListSelectDialogAdapter hotelListSelectDialogAdapter;
    private ListView hotel_list_select_lv;
    private TextView hotel_list_select_tv;
    private List<String> selectList;
    private NoScrollViewPager hotel_list_select_content_vp;
    private List<Fragment> fragments;

    public HotelListSelectFragment() {

    }

    // 定义用来与外部activity交互，获取到宿主activity
    private SelectFragmentListener listterner;


    // 定义了所有activity必须实现的接口方法
    public interface SelectFragmentListener {
        void select(String str);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof SelectFragmentListener) {
            listterner = (SelectFragmentListener)context; // 获取到宿主activity并赋值
        } else{
            throw new IllegalArgumentException("activity must implements SelectFragmentListener");
        }
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.hotel_list_select_dialog;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {

        initView();
    }

    public void initView() {
        selectList = new ArrayList<>();
        selectList.add("住宿类型");
        selectList.add("品牌");
        selectList.add("酒店设备");
        fragments = new ArrayList<>();
        fragments.add(new SelectRoomFragment());
        fragments.add(new SelectBrandFragment());
        fragments.add(new SelectServiceFragment());
        mView.findViewById(R.id.hotel_list_select_empty_tv).setOnClickListener(this);
        mView.findViewById(R.id.hotel_list_select_result_tv).setOnClickListener(this);
        hotel_list_select_content_vp = (NoScrollViewPager) mView.findViewById(R.id.hotel_list_select_content_vp);
        hotel_list_select_lv = (ListView) mView.findViewById(R.id.hotel_list_select_lv);
        hotel_list_select_tv = (TextView) mView.findViewById(R.id.hotel_list_select_tv);
        hotelListSelectDialogAdapter = new HotelListSelectDialogAdapter(mContext, selectList);
        hotel_list_select_lv.setAdapter(hotelListSelectDialogAdapter);
        hotelListSelectDialogAdapter.setDefSelect(0);
        hotel_list_select_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                hotelListSelectDialogAdapter.setDefSelect(position);
                hotel_list_select_content_vp.setCurrentItem(position);
            }
        });
        initContent();
    }


    //把传递进来的activity对象释放掉
    @Override
    public void onDetach() {
        super.onDetach();
        listterner = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hotel_list_select_empty_tv:
                break;
            case R.id.hotel_list_select_result_tv:
                listterner.select("");
                break;
        }
    }

    public void initContent(){
        hotel_list_select_content_vp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }

}
