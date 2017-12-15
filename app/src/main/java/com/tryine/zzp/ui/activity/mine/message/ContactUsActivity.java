package com.tryine.zzp.ui.activity.mine.message;


import android.view.View;
import android.widget.ImageView;
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
    private TextView view_head_title;
    private ImageView contact_us_title_iv;
    private ImageView contact_us_map_tv;
    private TextView contact_us_title_tv;
    private TextView contact_us_title_english_tv;
    private TextView contact_us_address_tv;
    private TextView contact_us_phone_tv;
    private TextView contact_us_tell_tv;
    private TextView contact_us_mail_tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contact_us;
    }

    @Override
    protected void afterOnCreate() {
        loadMessage();
        loadData();
    }

    public void loadData() {
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("关于我们");
        findViewById(R.id.view_head_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        contact_us_title_iv = (ImageView) findViewById(R.id.contact_us_title_iv);

    }

    public void loadMessage() {
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
                            JSONObject jsonObject = new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                            if (!(jsonObject.getInt("status") == 203)) {
                                JSONObject list = new JSONObject(jsonObject.getString("list"));

                            }
                        } catch (Exception e) {

                        }
                    }
                });
    }
}
