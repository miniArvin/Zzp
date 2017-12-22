package com.tryine.zzp.ui.activity.found;


import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.entity.test.remote.AnswerDetailEntity;
import com.tryine.zzp.utils.UrlUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Response;

public class FoundQuestionsDetailActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;
    private ImageView view_head_share;
    private String post_id;
    private AnswerDetailEntity answerDetailEntity;
    private ImageView food_view_detail_bg_img;
    private ImageView food_view_detail_collect_iv;
    private CircleImageView food_view_detail_head_cv;
    private ImageView food_view_detail_member_iv;
    private RelativeLayout food_view_detail_zan_rl;
    private TextView food_view_detail_title_tv;
    private TextView food_view_detail_create_tv;
    private TextView food_view_detail_comment_tv;
    private TextView food_view_detail_view_tv;
    private TextView food_view_detail_collect_tv;
    private TextView food_view_detail_location_tv;
    private TextView food_view_detail_name_tv;
    private TextView food_view_detail_member_tv;
    private TextView food_view_detail_comment_all_tv;
    private TextView food_view_detail_reply_tv;
    private TextView food_view_detail_comment_all_title_tv;
    private WebView food_view_web;
    private WebSettings webSettings;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_food_view_detail;
    }

    @Override
    protected void afterOnCreate() {
        post_id = getIntent().getStringExtra("post_id");
        loadMessage();
        initView();
    }

    public void initView(){
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("在线问答");
        view_head_share = (ImageView) findViewById(R.id.view_head_share);
        view_head_share.setVisibility(View.VISIBLE);
        view_head_share.setOnClickListener(this);

        food_view_detail_bg_img = (ImageView) findViewById(R.id.food_view_detail_bg_img);
        food_view_detail_bg_img.setVisibility(View.GONE);
        food_view_detail_zan_rl = (RelativeLayout) findViewById(R.id.food_view_detail_zan_rl);
        food_view_detail_zan_rl.setVisibility(View.GONE);
        food_view_detail_collect_iv = (ImageView) findViewById(R.id.food_view_detail_collect_iv);
        food_view_detail_collect_iv.setVisibility(View.GONE);
        food_view_detail_member_iv = (ImageView) findViewById(R.id.food_view_detail_member_iv);
        food_view_detail_head_cv = (CircleImageView) findViewById(R.id.food_view_detail_head_cv);
        food_view_detail_collect_tv = (TextView) findViewById(R.id.food_view_detail_collect_tv);
        food_view_detail_collect_tv.setVisibility(View.GONE);
        food_view_detail_title_tv = (TextView) findViewById(R.id.food_view_detail_title_tv);
        food_view_detail_create_tv = (TextView) findViewById(R.id.food_view_detail_create_tv);
        food_view_detail_comment_tv = (TextView) findViewById(R.id.food_view_detail_comment_tv);
        food_view_detail_view_tv = (TextView) findViewById(R.id.food_view_detail_view_tv);
        food_view_detail_name_tv = (TextView) findViewById(R.id.food_view_detail_name_tv);
        food_view_detail_location_tv = (TextView) findViewById(R.id.food_view_detail_location_tv);
        food_view_detail_member_tv = (TextView) findViewById(R.id.food_view_detail_member_tv);
        food_view_detail_comment_all_tv = (TextView) findViewById(R.id.food_view_detail_comment_all_tv);
        food_view_detail_reply_tv = (TextView) findViewById(R.id.food_view_detail_reply_tv);
        food_view_detail_reply_tv.setOnClickListener(this);
        food_view_detail_comment_all_title_tv = (TextView) findViewById(R.id.food_view_detail_comment_all_title_tv);
        food_view_detail_comment_all_title_tv.setText("全部回答");
        food_view_web = (WebView) findViewById(R.id.food_view_web);
        webSettings = food_view_web.getSettings();
    }

    public void loadData(){
        Glide.with(mContext).load(UrlUtils.getUrl(answerDetailEntity.getInfo().getInfo().getFace())).into(food_view_detail_head_cv);
        Glide.with(mContext).load(UrlUtils.getUrl(answerDetailEntity.getInfo().getInfo().getIcon())).into(food_view_detail_member_iv);
        food_view_detail_title_tv.setText(answerDetailEntity.getInfo().getInfo().getTitle());
        food_view_detail_create_tv.setText(answerDetailEntity.getInfo().getInfo().getCreate_time());
        food_view_detail_comment_tv.setText(answerDetailEntity.getInfo().getInfo().getReply_num());
        food_view_detail_view_tv.setText(answerDetailEntity.getInfo().getInfo().getViews());
        food_view_detail_member_tv.setText(answerDetailEntity.getInfo().getInfo().getRank_name());
        food_view_detail_name_tv.setText(answerDetailEntity.getInfo().getInfo().getAccount());
        food_view_detail_location_tv.setText(answerDetailEntity.getInfo().getInfo().getCity_id());
        food_view_detail_comment_all_tv.setText("("+answerDetailEntity.getInfo().getInfo().getReply_num()+")");
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title></title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append(answerDetailEntity.getInfo().getInfo().getDetails());
        sb.append("</body>");
        sb.append("</html>");
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        food_view_web.loadDataWithBaseURL(null,sb.toString(),"text/html","utf-8",null);
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.ANSWERDETAIL)
                .addParams("post_id",post_id)
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
                                answerDetailEntity = new AnswerDetailEntity();
                                answerDetailEntity = gson.fromJson(response.toString(),AnswerDetailEntity.class);
                                loadData();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_head_back:
                finish();
                break;
            case R.id.view_head_share:
                break;
            case R.id.food_view_detail_reply_tv:
                break;
        }
    }
}
