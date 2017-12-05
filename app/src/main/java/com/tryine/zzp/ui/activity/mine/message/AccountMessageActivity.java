package com.tryine.zzp.ui.activity.mine.message;

import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Response;

public class AccountMessageActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;
    private CircleImageView account_message_head_iv;
    private TextView account_message_user_name_tv;
    private TextView account_message_real_name_tv;
    private TextView account_message_relate_tv;
    private TextView account_message_email_tv;
    private TextView account_message_phone_tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_message;
    }

    @Override
    protected void afterOnCreate() {
        loadMessage();
        loadData();
    }

    public void loadData(){
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title= (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("账户信息");
        account_message_head_iv= (CircleImageView) findViewById(R.id.account_message_head_iv);
        account_message_user_name_tv = (TextView) findViewById(R.id.account_message_user_name_tv);
        account_message_real_name_tv = (TextView) findViewById(R.id.account_message_real_name_tv);
        account_message_relate_tv = (TextView) findViewById(R.id.account_message_relate_tv);
        account_message_email_tv = (TextView) findViewById(R.id.account_message_email_tv);
        account_message_phone_tv = (TextView) findViewById(R.id.account_message_phone_tv);
        findViewById(R.id.account_message_head_rl).setOnClickListener(this);
        findViewById(R.id.account_message_user_name_rl).setOnClickListener(this);
        findViewById(R.id.account_message_real_name_rl).setOnClickListener(this);
        findViewById(R.id.account_message_relate_rl).setOnClickListener(this);
        findViewById(R.id.account_message_email_rl).setOnClickListener(this);
        findViewById(R.id.account_message_phone_rl).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_head_back:
                finish();
                break;
            case R.id.account_message_head_rl:
                break;
            case R.id.account_message_user_name_rl:
                break;
            case R.id.account_message_real_name_rl:
                break;
            case R.id.account_message_relate_rl:
                break;
            case R.id.account_message_email_rl:
                break;
            case R.id.account_message_phone_rl:
                break;
            default:
                break;
        }
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.ACCOUNTMESSAGE)
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
                            if (jsonObject.getInt("status")==330){
                                JSONObject list = jsonObject.getJSONObject("list");
                                LogUtils.e(list);
                                String face = list.getString("face");
                                String real_name=list.getString("realname");
                                String email=list.getString("email");
                                String nick_name=list.getString("nickname");
                                String mobile=list.getString("mobile");
                                if (!real_name.equals("null")){
                                    account_message_real_name_tv.setText(real_name);
                                }
                                if (!email.equals("null")){
                                    account_message_email_tv.setText(email);
                                }
                                if (!nick_name.equals("null")){
                                    account_message_user_name_tv.setText(nick_name);
                                }
                                if (!mobile.equals("null")){
                                    account_message_phone_tv.setText(mobile);
                                }
                            }
                        }catch (Exception e){

                        }
                    }
                });
    }
}
