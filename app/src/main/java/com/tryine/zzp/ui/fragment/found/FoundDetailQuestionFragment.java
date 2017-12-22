package com.tryine.zzp.ui.fragment.found;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.FoundDetailQuestionAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseFragment;
import com.tryine.zzp.entity.test.remote.AnswerEntity;
import com.tryine.zzp.ui.activity.found.FoundQuestionsDetailActivity;
import com.tryine.zzp.utils.UrlUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoundDetailQuestionFragment extends BaseFragment {
    private ListView found_detail_question_fl_lv;
    private FoundDetailQuestionAdapter foundDetailQuestionAdapter;
    private List<AnswerEntity.InfoBean.ListBean> listBeen;
    private AnswerEntity.InfoBean.FineBean fineBean;
    private AnswerEntity answerEntity ;
    private TextView interesting_question_title_tv;
    private TextView interesting_question_head_tv;
    private TextView interesting_question_location_tv;
    private TextView interesting_question_zan_tv;
    private TextView interesting_question_read_tv;
    private ImageView interesting_question_bg_img;
    private CircleImageView interesting_question_img_headimg;
    private Bundle bundle;

    public FoundDetailQuestionFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_found_detail_question;
    }

    @Override
    protected void afterCreated(Bundle savedInstanceState) {
        loadMessage();
        initView();
    }
    public void initView(){
        fineBean = new AnswerEntity.InfoBean.FineBean();
        listBeen = new ArrayList<>();
        answerEntity = new AnswerEntity();
        found_detail_question_fl_lv= (ListView) mView.findViewById(R.id.found_detail_question_fl_lv);
        bundle = new Bundle();
    }

    public void loadData(){
        foundDetailQuestionAdapter=new FoundDetailQuestionAdapter(mContext,listBeen);
        View view = LayoutInflater.from(mContext).inflate(R.layout.found_interesting_question_head_item, null);
        interesting_question_bg_img = (ImageView) view.findViewById(R.id.interesting_question_bg_img);
        interesting_question_img_headimg = (CircleImageView) view.findViewById(R.id.interesting_question_img_headimg);
        interesting_question_title_tv = (TextView) view.findViewById(R.id.interesting_question_title_tv);
        interesting_question_head_tv = (TextView) view.findViewById(R.id.interesting_question_head_tv);
        interesting_question_location_tv = (TextView) view.findViewById(R.id.interesting_question_location_tv);
        interesting_question_zan_tv = (TextView) view.findViewById(R.id.interesting_question_zan_tv);
        interesting_question_read_tv = (TextView) view.findViewById(R.id.interesting_question_read_tv);

        Glide.with(mContext).load(UrlUtils.getUrl(fineBean.getImg())).asBitmap().into(interesting_question_bg_img);
        Glide.with(mContext).load(UrlUtils.getUrl(fineBean.getFace())).asBitmap().into(interesting_question_img_headimg);
        interesting_question_title_tv.setText(fineBean.getTitle());
        interesting_question_head_tv.setText((CharSequence) fineBean.getAccount());
        interesting_question_location_tv.setText(fineBean.getCity_id());
        interesting_question_zan_tv.setText(fineBean.getReply_num());
        interesting_question_read_tv.setText(fineBean.getViews());
        found_detail_question_fl_lv.addHeaderView(view);
        found_detail_question_fl_lv.setAdapter(foundDetailQuestionAdapter);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("post_id",fineBean.getPost_id());
                startAct(FoundQuestionsDetailActivity.class,bundle);
            }
        });

        found_detail_question_fl_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bundle.putString("post_id",listBeen.get(position-1).getPost_id());
                startAct(FoundQuestionsDetailActivity.class,bundle);
            }
        });
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.ANSWER)
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
                                answerEntity = gson.fromJson(response.toString(),AnswerEntity.class);
                                fineBean = answerEntity.getInfo().getFine();
                                listBeen = answerEntity.getInfo().getList();
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
