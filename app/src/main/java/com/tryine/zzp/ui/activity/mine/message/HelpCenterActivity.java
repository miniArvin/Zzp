package com.tryine.zzp.ui.activity.mine.message;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MineMessagesAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.entity.test.remote.HelpCenter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class HelpCenterActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;
    private ListView help_center_lv;
    private MineMessagesAdapter mineMessagesAdapter;
    private List<HelpCenter.ListBean> helpCenters;
    private int type=2;
    private String content_id;
    private Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_help_center;
    }

    @Override
    protected void afterOnCreate() {
        loadMessage();
        loadData();
    }

    public void loadData() {
        bundle= new Bundle();
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("帮助中心");
        findViewById(R.id.view_head_back).setOnClickListener(this);
        findViewById(R.id.member_rule_tv).setOnClickListener(this);
        findViewById(R.id.hidden_policy_tv).setOnClickListener(this);
        findViewById(R.id.disclaimer_tv).setOnClickListener(this);
        help_center_lv= (ListView) findViewById(R.id.help_center_lv);
        helpCenters=new ArrayList<>();
        help_center_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                content_id=helpCenters.get(position).getContent_id();
                bundle.putString("type","0");
                bundle.putString("content_id",content_id);
                startAct(WebViewActivity.class,bundle);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view_head_back:
                finish();
                break;
            case R.id.member_rule_tv:
                bundle.putString("type","2");
                startAct(WebViewActivity.class,bundle);
                break;
            case R.id.hidden_policy_tv:
                bundle.putString("type","3");
                startAct(WebViewActivity.class,bundle);
                break;
            case R.id.disclaimer_tv:
                bundle.putString("type","4");
                startAct(WebViewActivity.class,bundle);
                break;
        }
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.HELPCENTER)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string =response.body().string();
                        LogUtils.e(string);
                        return string;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e(e);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        Gson gson=new Gson();
                        try {
                            HelpCenter helpCenter = gson.fromJson(response.toString(),HelpCenter.class);
                            if (helpCenter.getStatus()==330){
                                helpCenters=helpCenter.getList();
                                mineMessagesAdapter = new MineMessagesAdapter(mContext,type,helpCenters);
                                help_center_lv.setAdapter(mineMessagesAdapter);
                            }
                        }catch (Exception e){

                        }
                    }
                });
    }

}
