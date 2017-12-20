package com.tryine.zzp.ui.fragment.hotel;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelListSelectContentDialogAdapter;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.entity.test.remote.HotelListSelectEntity;
import com.tryine.zzp.ui.activity.hotel.HotelListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectBrandFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private ListView select_brand_lv;
    private HotelListSelectContentDialogAdapter hotelListSelectContentDialogAdapter;
    private List<HotelListSelectEntity.InfoBean.BrandBean> brandBeanList;
    private List<String> mTempList;   //选中的数据

    public SelectBrandFragment() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mTempList = new ArrayList<>();
        brandBeanList = ((HotelListActivity)getActivity()).getBrand();
        for (int i=0;i<brandBeanList.size();i++){
            mTempList.add(brandBeanList.get(i).getTitle());
        }
    }

    // 定义用来与外部activity交互，获取到宿主activity
    private BrandFragmentListener listterner;



    // 定义了所有activity必须实现的接口方法
    public interface BrandFragmentListener {
        void Brand(String str);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_select_brand;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        initView();
    }

    public void initView(){
        select_brand_lv = (ListView) mView.findViewById(R.id.select_brand_lv);
        hotelListSelectContentDialogAdapter = new HotelListSelectContentDialogAdapter(mContext,mView,null,null,brandBeanList,mTempList);
        select_brand_lv.setAdapter(hotelListSelectContentDialogAdapter);
        select_brand_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (view.getTag() instanceof HotelListSelectContentDialogAdapter.ViewHolder) {

            HotelListSelectContentDialogAdapter.ViewHolder holder = (HotelListSelectContentDialogAdapter.ViewHolder) view.getTag();

            // 会自动出发CheckBox的checked事件
            holder.hotel_list_select_item_cb.toggle();
            hotelListSelectContentDialogAdapter.label = false;
        }
    }

}
