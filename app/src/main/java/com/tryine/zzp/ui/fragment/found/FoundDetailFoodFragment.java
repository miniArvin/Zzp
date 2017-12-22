package com.tryine.zzp.ui.fragment.found;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.FoundDetailFoodAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.entity.test.remote.FoodEntity;
import com.tryine.zzp.ui.activity.found.FoodViewDetailActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundDetailFoodFragment extends BaseFragment {
    private GridView found_detail_food_fl_gv;
    private FoundDetailFoodAdapter foundDetailFoodAdapter;
    private List<FoodEntity.InfoBean> foodBean;

    public FoundDetailFoodFragment() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_found_detail_food;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        loadMessage();
        initView();
    }

    public void initView(){
        foodBean = new ArrayList<>();
        found_detail_food_fl_gv= (GridView) mView.findViewById(R.id.found_detail_food_fl_gv);
    }

    public void loadData(){
        foundDetailFoodAdapter=new FoundDetailFoodAdapter(mContext,foodBean);
        found_detail_food_fl_gv.setAdapter(foundDetailFoodAdapter);
        found_detail_food_fl_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("post_id",foodBean.get(position).getPost_id());
                startAct(FoodViewDetailActivity.class,bundle);
            }
        });
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.FOODANDVIEW)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        LogUtils.e(string);
                        return string;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e(e);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                            if (jsonObject.getInt("status")==330){
                                Gson gson = new Gson();
                                FoodEntity foodEntity = new FoodEntity();
                                foodEntity = gson.fromJson(response.toString(),FoodEntity.class);
                                foodBean = foodEntity.getInfo();
                                loadData();
                            }else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

}
