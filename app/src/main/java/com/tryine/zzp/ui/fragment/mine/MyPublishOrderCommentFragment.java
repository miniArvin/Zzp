package com.tryine.zzp.ui.fragment.mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.blankj.utilcode.util.LogUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MinePublishCommentAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPublishOrderCommentFragment extends BaseFragment {

    private ListView mine_publish_order_comment_lv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type=0;

    public MyPublishOrderCommentFragment() {
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_my_publish_order_comment;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        loadMessage();
        initView();
    }

    public void initView(){
        mine_publish_order_comment_lv= (ListView) mView.findViewById(R.id.mine_publish_order_comment_lv);
        minePublishCommentAdapter=new MinePublishCommentAdapter(mView,mContext,type);
        mine_publish_order_comment_lv.setAdapter(minePublishCommentAdapter);
    }

    public void loadData(){

    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.ORDERCOMMET)
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
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

}
