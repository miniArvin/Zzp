package com.tryine.zzp.ui.activity.mine.message;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Cons.SP_USER_ACCOUNT;
import static com.tryine.zzp.app.constant.Cons.SP_USER_EMAIL;
import static com.tryine.zzp.app.constant.Cons.SP_USER_FACE;
import static com.tryine.zzp.app.constant.Cons.SP_USER_ID;
import static com.tryine.zzp.app.constant.Cons.SP_USER_NAME;
import static com.tryine.zzp.app.constant.Cons.SP_USER_TOKEN;

public class SettingActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;
    private CircleImageView setting_img_headimg;
    private TextView setting_name_tv;
    private ImageView setting_level_iv;
    private TextView setting_level_tv;
    private Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void afterOnCreate() {
        loadMessage();
        loadData();
    }

    public void loadData(){
        bundle = new Bundle();
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title= (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("设置");
        findViewById(R.id.setting_help_rl).setOnClickListener(this);
        findViewById(R.id.setting_member_rl).setOnClickListener(this);
        findViewById(R.id.contact_us_rl).setOnClickListener(this);
        findViewById(R.id.about_zzp_rl).setOnClickListener(this);
        findViewById(R.id.setting_logout_tv).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_head_back:
                finish();
                break;
            case R.id.contact_us_rl:
                startAct(ContactUsActivity.class);
                break;
            case R.id.setting_help_rl:
                startAct(HelpCenterActivity.class);
                break;
            case R.id.setting_member_rl:
                bundle.putString("type","2");
                startAct(WebViewActivity.class,bundle);
                break;
            case R.id.about_zzp_rl:
                bundle.putString("type","1");
                startAct(WebViewActivity.class,bundle);
                break;
            case R.id.setting_logout_tv:
                settingLogout();
                break;
            default:
                break;
        }
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.SETTING)
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
                            JSONObject jsonObject =new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                            if (jsonObject.getInt("status")==330){
                                JSONObject list = new JSONObject(jsonObject.getString("list"));
                                String rank_name=list.getString("rank_name");
                                String face= list.getString("face");
                                String nick_name=list.getString("nickname");
                                String prestige =list.getString("prestige");
                                if (!rank_name.equals("null")){
                                    setting_level_tv.setText(rank_name);
                                }
                                if (!nick_name.equals("null")){
                                    setting_name_tv.setText(nick_name);
                                }
                            }
                        }catch (Exception e){

                        }
                    }
                });
    }

    public void settingLogout(){
        OkHttpUtils
                .post()
                .url(Api.LOGOUT)
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
                            if (jsonObject.getInt("status")==200){
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                SPUtils.getInstance().put(SP_USER_ID,"");
                                SPUtils.getInstance().put(SP_USER_TOKEN,"");
                                LogUtils.e(SPUtils.getInstance("spConfig").getString(SP_USER_TOKEN));
                                SPUtils.getInstance().put(SP_USER_EMAIL,"");
                                SPUtils.getInstance().put(SP_USER_ACCOUNT,"");
                                SPUtils.getInstance().put(SP_USER_NAME,"");
                                SPUtils.getInstance().put(SP_USER_FACE,"");
                            }else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        }catch (Exception e){

                        }
                    }
                });
    }

}
