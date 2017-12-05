package com.tryine.zzp.ui.activity.mine.message;

import android.text.Html;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class WebViewActivity extends BaseStatusMActivity {
    private TextView view_head_title;
    private String content_id;
    private TextView web_view_tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void afterOnCreate() {
        content_id=getIntent().getStringExtra("content_id");
        loadMessage();
        loadData();
    }

    public void loadData(){
        view_head_title= (TextView) findViewById(R.id.view_head_title);
        web_view_tv= (TextView) findViewById(R.id.web_view_tv);
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.HELPCENTERDETAIL)
                .addParams("id",content_id)
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
                            JSONObject jsonObject=new JSONObject(response.toString());
                            web_view_tv.setText(Html.fromHtml(jsonObject.getString("contents")));
                            view_head_title.setText(jsonObject.getString("title"));
                        }catch (Exception e){

                        }
                    }
                });
    }

}
