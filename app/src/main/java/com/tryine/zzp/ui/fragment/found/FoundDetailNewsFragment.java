package com.tryine.zzp.ui.fragment.found;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.FoundDetailNewsAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.entity.test.remote.NewsEntity;
import com.tryine.zzp.ui.activity.found.FoundNewsDetailActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundDetailNewsFragment extends BaseFragment {
    private ListView found_detail_news_fl_lv;
    private FoundDetailNewsAdapter foundDetailNewsAdapter;
    private List<NewsEntity.InfoBean> newsBean;
    private NewsEntity newsEntity;

    public FoundDetailNewsFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_found_detail_news;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        loadMessage();
        initView();
    }

    public void initView() {
        found_detail_news_fl_lv = (ListView) mView.findViewById(R.id.found_detail_news_fl_lv);
    }

    public void loadData(){
        foundDetailNewsAdapter=new FoundDetailNewsAdapter(mContext,newsBean);
        found_detail_news_fl_lv.setAdapter(foundDetailNewsAdapter);
        found_detail_news_fl_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("article_id",newsBean.get(position).getArticle_id());
                startAct(FoundNewsDetailActivity.class,bundle);
            }
        });
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.NEWS)
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
                                newsEntity = new NewsEntity();
                                newsEntity = gson.fromJson(response.toString(),NewsEntity.class);
                                newsBean = newsEntity.getInfo();
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
