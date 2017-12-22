package com.tryine.zzp.ui.activity.found;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Response;

public class FoundNewsDetailActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;
    private ImageView view_head_share;
    private String article_id;
    private ImageView food_view_detail_bg_img;
    private TextView food_view_detail_title_tv;
    private TextView food_view_detail_create_tv;
    private TextView food_view_detail_view_tv;
    private WebView food_view_web;
    private WebSettings webSettings;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_food_view_detail;
    }

    @Override
    protected void afterOnCreate() {
        article_id = getIntent().getStringExtra("article_id");
        loadMessage();
        initView();
    }

    public void initView(){
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("新闻资讯");
        view_head_share = (ImageView) findViewById(R.id.view_head_share);
        view_head_share.setVisibility(View.VISIBLE);
        view_head_share.setOnClickListener(this);

        food_view_detail_bg_img = (ImageView) findViewById(R.id.food_view_detail_bg_img);
        food_view_detail_title_tv = (TextView) findViewById(R.id.food_view_detail_title_tv);
        food_view_detail_create_tv = (TextView) findViewById(R.id.food_view_detail_create_tv);
        food_view_detail_view_tv = (TextView) findViewById(R.id.food_view_detail_view_tv);
        food_view_web = (WebView) findViewById(R.id.food_view_web);
        webSettings = food_view_web.getSettings();
        findViewById(R.id.ood_view_detail_title_rl).setVisibility(View.GONE);
        findViewById(R.id.food_view_detail_comment_all_ll).setVisibility(View.GONE);
        findViewById(R.id.food_view_v).setVisibility(View.GONE);
        findViewById(R.id.food_view_detail_comment_tv).setVisibility(View.GONE);
        findViewById(R.id.food_view_detail_reply_tv).setVisibility(View.GONE);
        findViewById(R.id.food_view_detail_collect_tv).setVisibility(View.GONE);
        findViewById(R.id.food_view_detail_collect_iv).setVisibility(View.GONE);
        findViewById(R.id.food_view_detail_zan_rl).setVisibility(View.GONE);
        findViewById(R.id.food_view_detail_comment_iv).setVisibility(View.GONE);
    }


    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.NEWSDETAIL)
                .addParams("article_id",article_id)
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
                                JSONObject info = new JSONObject(jsonObject.getString("info"));
                                Glide.with(mContext).load(UrlUtils.getUrl(info.getString("photo"))).into(food_view_detail_bg_img);
                                food_view_detail_title_tv.setText(info.getString("title"));
                                food_view_detail_create_tv.setText(info.getString("create_time"));
                                food_view_detail_view_tv.setText(info.getString("views"));
                                StringBuilder sb = new StringBuilder();
                                sb.append("<html>");
                                sb.append("<head>");
                                sb.append("<title></title>");
                                sb.append("</head>");
                                sb.append("<body>");
                                sb.append(info.getString("details"));
                                sb.append("</body>");
                                sb.append("</html>");
                                webSettings.setUseWideViewPort(true);
                                webSettings.setLoadWithOverviewMode(true);
                                food_view_web.loadDataWithBaseURL(null,sb.toString(),"text/html","utf-8",null);
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
        }
    }
}
