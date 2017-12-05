package com.tryine.zzp.ui.activity.mine.message;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.MineMessagesAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class MessageActivity extends BaseStatusMActivity implements View.OnClickListener {
    private ListView mine_messages_lv;
    private MineMessagesAdapter mineMessagesAdapter;
    private TextView view_head_title;
    private int type=1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void afterOnCreate() {
        loadMessage();
        loadData();
    }
    public void loadData(){
        mine_messages_lv= (ListView) findViewById(R.id.mine_messages_lv);
        mineMessagesAdapter=new MineMessagesAdapter(this,type,null);
        mine_messages_lv.setAdapter(mineMessagesAdapter);
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title= (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("消息中心");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_head_back:
                finish();
                break;
            default:
                break;
        }
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.MESSAGECENTER)
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
                            if (jsonObject.getInt("status")==339){
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        }catch (Exception e){

                        }
                    }
                });
    }
}
