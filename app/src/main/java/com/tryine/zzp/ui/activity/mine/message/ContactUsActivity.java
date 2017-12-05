package com.tryine.zzp.ui.activity.mine.message;


import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

public class ContactUsActivity extends BaseStatusMActivity {
    private TextView contact_us_tv;
    private TextView view_head_title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contact_us;
    }

    @Override
    protected void afterOnCreate() {
        loadMessage();
        loadData();
    }

    public void loadData(){
        contact_us_tv = (TextView) findViewById(R.id.contact_us_tv);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        findViewById(R.id.view_head_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.CONTACTUS)
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
                            LogUtils.e(jsonObject);
                            if (!(jsonObject.getInt("status")==203)){
                                CharSequence charSequence= Html.fromHtml(jsonObject.getString("v"));
                                contact_us_tv.setText(charSequence);
                            }
                        }catch (Exception e){

                        }
                    }
                });
    }
}
