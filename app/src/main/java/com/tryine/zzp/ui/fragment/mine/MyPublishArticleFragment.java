package com.tryine.zzp.ui.fragment.mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.GridView;

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
public class MyPublishArticleFragment extends BaseFragment {
    private GridView mine_publish_comment_gv;
    private MinePublishCommentAdapter minePublishCommentAdapter;
    private int type=1;

    public MyPublishArticleFragment() {
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_my_publish_article;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        loadMessage("post");
        loadMessage("comment");
        initView();
    }

    public void initView(){
        mine_publish_comment_gv= (GridView) mView.findViewById(R.id.mine_publish_comment_gv);
        minePublishCommentAdapter=new MinePublishCommentAdapter(mView,mContext,type);
        mine_publish_comment_gv.setNumColumns(1);
        mine_publish_comment_gv.setAdapter(minePublishCommentAdapter);
    }

    public void loadData(){

    }

    public void loadMessage(String params){
        OkHttpUtils
                .post()
                .url(Api.ARTICLELIST)
                .addParams("act",params)
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
