package com.tryine.zzp.ui.fragment.hotel;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelListSelectContentDialogAdapter;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.entity.test.remote.HotelListSelectEntity;
import com.tryine.zzp.ui.activity.hotel.HotelListActivity;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectServiceFragment extends BaseFragment {
    private ListView select_service_lv;
    private HotelListSelectContentDialogAdapter hotelListSelectContentDialogAdapter;
    private List<HotelListSelectEntity.InfoBean.ServiceBean> serviceBeanList;

    public SelectServiceFragment() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        serviceBeanList = ((HotelListActivity)getActivity()).getService();
    }

    // 定义用来与外部activity交互，获取到宿主activity
    private ServiceFragmentListener listterner;


    // 定义了所有activity必须实现的接口方法
    public interface ServiceFragmentListener {
        void Service(String str);
    }



    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_select_service;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        initView();
    }

    public void initView(){
        select_service_lv = (ListView) mView.findViewById(R.id.select_service_lv);
        hotelListSelectContentDialogAdapter = new HotelListSelectContentDialogAdapter(mContext,mView,null,serviceBeanList,null);
        select_service_lv.setAdapter(hotelListSelectContentDialogAdapter);
        select_service_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    //把传递进来的activity对象释放掉
    @Override
    public void onDetach() {
        super.onDetach();
        listterner = null;
    }

}
