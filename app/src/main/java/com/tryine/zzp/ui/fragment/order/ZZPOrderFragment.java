package com.tryine.zzp.ui.fragment.order;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.AllOrderAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.entity.test.remote.AllOrderEntity;
import com.tryine.zzp.ui.activity.mine.order.AllOrderActivity;
import com.tryine.zzp.ui.activity.mine.order.OrderActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Code.REQUEST_CODE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZZPOrderFragment extends BaseFragment implements View.OnClickListener {
    private ListView zzp_order_lv;
    private AllOrderAdapter allOrderAdapter;
    private String pay = "待付款(0)";
    private String stay = "待入住(0)";
    private String comment = "待评论(0)";
    private List<AllOrderEntity.InfoBean.ListBean> listBeen;
    private List<AllOrderEntity.InfoBean.ListBean> listTemp;
    private TextView zzp_order_pay_tv;
    private TextView zzp_order_stay_tv;
    private TextView zzp_order_comment_tv;

    public ZZPOrderFragment() {
        // Required empty public constructor
    }

    // 定义用来与外部activity交互，获取到宿主activity
    private OrderNumFragmentListener listterner;


    // 定义了所有activity必须实现的接口方法
    public interface OrderNumFragmentListener {
        void orderNum(String num);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AllOrderActivity) {
            listterner = (OrderNumFragmentListener) context; // 获取到宿主activity并赋值
        } else {
            throw new IllegalArgumentException("activity must implements orderNumFragmentListener");
        }
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_zzporder;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        loadMessage("pay");
        initView();
    }

    public void initView() {
        listBeen = new ArrayList<>();
        listTemp = new ArrayList<>();
        zzp_order_lv = (ListView) mView.findViewById(R.id.zzp_order_lv);
        zzp_order_pay_tv = (TextView) mView.findViewById(R.id.zzp_order_pay_tv);
        zzp_order_stay_tv = (TextView) mView.findViewById(R.id.zzp_order_stay_tv);
        zzp_order_comment_tv = (TextView) mView.findViewById(R.id.zzp_order_comment_tv);
        zzp_order_pay_tv.setOnClickListener(this);
        zzp_order_stay_tv.setOnClickListener(this);
        zzp_order_comment_tv.setOnClickListener(this);
    }

    public void loadData() {
        if (allOrderAdapter==null) {
            allOrderAdapter = new AllOrderAdapter(mContext, listBeen);
            zzp_order_lv.setAdapter(allOrderAdapter);
            zzp_order_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    startActForResult(OrderActivity.class,REQUEST_CODE);
                }
            });
        }else {
            allOrderAdapter.notifyDataSetChanged();
        }
    }

    public void loadMessage(String url) {
        OkHttpUtils
                .post()
                .url(Api.ZPPORDER)
                .addParams("act", url)
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
                            if (jsonObject.getInt("status") == 330) {
                                Gson gson = new Gson();
                                AllOrderEntity allOrderEntity = gson.fromJson(response.toString(), AllOrderEntity.class);
                                listTemp = allOrderEntity.getInfo().getList();
                                if (listTemp!=null) {
                                    listBeen.clear();
                                    listBeen.addAll(listTemp);
                                    listTemp.clear();
                                    pay = "待付款(" + allOrderEntity.getInfo().getPayNum() + ")";
                                    stay = "待入住(" + allOrderEntity.getInfo().getStayNum() + ")";
                                    comment = "待评价(" + allOrderEntity.getInfo().getCommentNum() + ")";
                                    zzp_order_pay_tv.setText(pay);
                                    zzp_order_stay_tv.setText(stay);
                                    zzp_order_comment_tv.setText(comment);
                                    listterner.orderNum(allOrderEntity.getInfo().getAllnum());
                                    loadData();
                                }else {
                                    if (allOrderAdapter!=null){
                                        listBeen.clear();
                                        allOrderAdapter.notifyDataSetChanged();
                                    }
                                }
                            } else if (jsonObject.getInt("status")==339){
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                if (allOrderAdapter!=null){
                                    listBeen.clear();
                                    allOrderAdapter.notifyDataSetChanged();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zzp_order_pay_tv:
                defaultTitle();
                zzp_order_pay_tv.setTextColor(mContext.getResources().getColor(R.color.orange));
                zzp_order_pay_tv.setBackgroundColor(mContext.getResources().getColor(R.color.all_order));
                loadMessage("pay");
                break;
            case R.id.zzp_order_stay_tv:
                defaultTitle();
                zzp_order_stay_tv.setTextColor(mContext.getResources().getColor(R.color.orange));
                zzp_order_stay_tv.setBackgroundColor(mContext.getResources().getColor(R.color.all_order));
                loadMessage("stay");
                break;
            case R.id.zzp_order_comment_tv:
                defaultTitle();
                zzp_order_comment_tv.setTextColor(mContext.getResources().getColor(R.color.orange));
                zzp_order_comment_tv.setBackgroundColor(mContext.getResources().getColor(R.color.all_order));
                loadMessage("comment");
                break;
            default:
                break;
        }
    }

    public void defaultTitle() {
        zzp_order_pay_tv.setTextColor(mContext.getResources().getColor(R.color.home_city_name_word));
        zzp_order_stay_tv.setTextColor(mContext.getResources().getColor(R.color.home_city_name_word));
        zzp_order_comment_tv.setTextColor(mContext.getResources().getColor(R.color.home_city_name_word));
        zzp_order_pay_tv.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        zzp_order_stay_tv.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        zzp_order_comment_tv.setBackgroundColor(mContext.getResources().getColor(R.color.white));
    }

}
