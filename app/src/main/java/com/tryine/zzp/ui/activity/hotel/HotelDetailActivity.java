package com.tryine.zzp.ui.activity.hotel;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.NiceDialog;
import com.othershe.nicedialog.ViewConvertListener;
import com.othershe.nicedialog.ViewHolder;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelDetailCommentImgAdapter;
import com.tryine.zzp.adapter.HotelDetailCommentTagAdapter;
import com.tryine.zzp.adapter.HotelDetailDialogRoomAdapter;
import com.tryine.zzp.adapter.HotelDetailIntroAdapter;
import com.tryine.zzp.adapter.HotelDetailPolicyAdapter;
import com.tryine.zzp.adapter.HotelDetailRecommendAdapter;
import com.tryine.zzp.adapter.HotelDetailRoomAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.entity.test.remote.HotelDetailEntity;
import com.tryine.zzp.entity.test.remote.HotelDetailRoomEntity;
import com.tryine.zzp.ui.activity.mine.order.order_time.HotelOrderTimeActivity;
import com.tryine.zzp.utils.GlideImageLoader;
import com.tryine.zzp.utils.UrlUtils;
import com.tryine.zzp.widget.FlowLayout.FlowLayoutManager;
import com.tryine.zzp.widget.FlowLayout.SpaceItemDecoration;
import com.tryine.zzp.widget.NoScrollGirdView;
import com.tryine.zzp.widget.NoScrollListView;
import com.youth.banner.Banner;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;


import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Response;

public class HotelDetailActivity extends BaseStatusMActivity implements View.OnClickListener {
    private List<String> lists;
    private NoScrollGirdView hotel_detail_room_gv;
    private HotelDetailRoomAdapter hotelDetailRoomAdapter;
    private RecyclerView hotel_detail_comment_rv;
    private HotelDetailCommentTagAdapter hotelDetailCommentTagAdapter;
    private String hotel_id;
    private String hotel_name;
    private HotelDetailEntity hotelDetailEntities;
    private TextView view_head_title;
    private ImageView view_head_collect;
    private ImageView view_head_share;
    private List<HotelDetailEntity.InfoBean.AtlasBean> atlasBeen;
    private List<HotelDetailEntity.InfoBean.BannerBean> bannerBeen;
    private List<HotelDetailEntity.InfoBean.HotelBean> hotelBeen;
    private List<HotelDetailEntity.InfoBean.RoomBean> roomBeen;
    private List<HotelDetailEntity.InfoBean.HotelDetailBean.TagBean> tagBeen;
    private List<HotelDetailEntity.InfoBean.HotelIntroBean> hotelIntroBeen;
    private List<HotelDetailEntity.InfoBean.PolicyBean> policyBeen;
    private List<HotelDetailEntity.InfoBean.TagBeanX> tagBeanXes;
    private List<HotelDetailEntity.InfoBean.ApplyBean.PhotoBean> photoBeen;
    private HotelDetailIntroAdapter hotelDetailIntroAdapter;
    private CircleImageView hotel_detail_head_cv;
    private TextView hotel_detail_member_name_tv;
    private TextView hotel_detail_member_tv;
    private TextView hotel_detail_comment_publish_time_tv;
    private TextView hotel_detail_comment_tv;
    private ImageView hotel_detail_member_iv;
    private RatingBar hotel_detail_comment_rb;
    private String closed;
    private String audit;
    private String star;
    private int fav = 0;
    private int deposit = 0;
    private Banner hotel_detail_banner;
    private TextView hotel_detail_ad_count_tv;
    private TextView hotel_detail_name_tv;
    private RatingBar hotel_detail_rb;
    private TextView hotel_detail_year_tv;
    private TextView hotel_detail_comment_score_tv;
    private TextView hotel_detail_comment_chinese_tv;
    private TextView hotel_detail_comment_count_tv;
    private TextView hotel_detail_comment_tag1_tv;
    private TextView hotel_detail_comment_tag2_tv;
    private TextView hotel_detail_check_day_tv;
    private TextView hotel_detail_check_week_tv;
    private TextView hotel_detail_out_day_tv;
    private TextView hotel_detail_out_week_tv;
    private NoScrollGirdView hotel_detail_hotel_intro_gv;
    private TextView hotel_detail_comment_all_count_tv;
    private NoScrollGirdView hotel_detail_comment_gv;
    private HotelDetailCommentImgAdapter hotelDetailCommentImgAdapter;
    private String checkDate;
    private String outDate;
    private Date dateCheck;
    private Date dateOut;
    private Calendar calendar;
    private String checkWeek;
    private String outWeek;
    private int week;
    private HotelDetailPolicyAdapter hotelDetailPolicyAdapter;
    private NoScrollListView hotel_detail_policy_lv;
    private RecyclerView hotel_detail_recommend_rv;
    private HotelDetailRecommendAdapter hotelDetailRecommendAdapter;
    private String room_id;
    private List<HotelDetailRoomEntity.InfoBean.PolicyBean> roomPolicyBeen;
    private List<HotelDetailRoomEntity.InfoBean.FacilitiesBean> roomFacilitiesBeen;
    private Banner hotel_detail_room_dialog_cb;
    private NoScrollListView hotel_detail_room_dialog_policy_lv;
    private NoScrollListView hotel_detail_room_dialog_facilities_lv;
    private HotelDetailDialogRoomAdapter hotelDetailDialogRoomAdapterPolicy;
    private HotelDetailDialogRoomAdapter hotelDetailDialogRoomAdapterFacilities;
    private Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hotel_detail;
    }

    @Override
    protected void afterOnCreate() {
        hotel_id = getIntent().getStringExtra("hotel_id");
        hotel_name = getIntent().getStringExtra("hotel_name");
        initView();
        loadMessage();
    }

    public void initView() {
        lists = new ArrayList<>();
        atlasBeen = new ArrayList<>();
        bannerBeen = new ArrayList<>();
        roomBeen = new ArrayList<>();
        hotelBeen = new ArrayList<>();
        tagBeen = new ArrayList<>();
        hotelIntroBeen = new ArrayList<>();
        policyBeen = new ArrayList<>();
        tagBeanXes = new ArrayList<>();
        photoBeen = new ArrayList<>();
        roomPolicyBeen = new ArrayList<>();
        roomFacilitiesBeen = new ArrayList<>();
        bundle = new Bundle();
        hotel_detail_room_gv = (NoScrollGirdView) findViewById(R.id.hotel_detail_room_gv);
        hotel_detail_comment_rv = (RecyclerView) findViewById(R.id.hotel_detail_comment_rv);
        view_head_title = (TextView) findViewById(R.id.view_head_title);
        view_head_collect = (ImageView) findViewById(R.id.view_head_collect);
        view_head_collect.setVisibility(View.VISIBLE);
        view_head_collect.setOnClickListener(this);
        view_head_share = (ImageView) findViewById(R.id.view_head_share);
        view_head_share.setVisibility(View.VISIBLE);
        view_head_share.setOnClickListener(this);
        view_head_title.setText(hotel_name);
        hotel_detail_banner = (Banner) findViewById(R.id.hotel_detail_banner);
        hotel_detail_ad_count_tv = (TextView) findViewById(R.id.hotel_detail_ad_count_tv);
        hotel_detail_name_tv = (TextView) findViewById(R.id.hotel_detail_name_tv);
        hotel_detail_year_tv = (TextView) findViewById(R.id.hotel_detail_year_tv);
        hotel_detail_comment_score_tv = (TextView) findViewById(R.id.hotel_detail_comment_score_tv);
        hotel_detail_comment_chinese_tv = (TextView) findViewById(R.id.hotel_detail_comment_chinese_tv);
        hotel_detail_comment_count_tv = (TextView) findViewById(R.id.hotel_detail_comment_count_tv);
        hotel_detail_comment_tag1_tv = (TextView) findViewById(R.id.hotel_detail_comment_tag1_tv);
        hotel_detail_comment_tag2_tv = (TextView) findViewById(R.id.hotel_detail_comment_tag2_tv);
        hotel_detail_check_day_tv = (TextView) findViewById(R.id.hotel_detail_check_day_tv);
        hotel_detail_check_week_tv = (TextView) findViewById(R.id.hotel_detail_check_week_tv);
        hotel_detail_out_day_tv = (TextView) findViewById(R.id.hotel_detail_out_day_tv);
        hotel_detail_out_week_tv = (TextView) findViewById(R.id.hotel_detail_out_week_tv);
        hotel_detail_hotel_intro_gv = (NoScrollGirdView) findViewById(R.id.hotel_detail_hotel_intro_gv);
        hotel_detail_rb = (RatingBar) findViewById(R.id.hotel_detail_rb);
        findViewById(R.id.view_head_back).setOnClickListener(this);
        findViewById(R.id.hotel_detail_all_policy_iv).setOnClickListener(this);
        findViewById(R.id.hotel_detail_all_policy_tv).setOnClickListener(this);
        findViewById(R.id.hotel_detail_intro_more_iv).setOnClickListener(this);
        findViewById(R.id.hotel_detail_all_comment_iv).setOnClickListener(this);
        findViewById(R.id.hotel_detail_comment_all_tv).setOnClickListener(this);
        findViewById(R.id.hotel_detail_comment_all_iv).setOnClickListener(this);
        hotel_detail_head_cv = (CircleImageView) findViewById(R.id.hotel_detail_head_cv);
        hotel_detail_member_name_tv = (TextView) findViewById(R.id.hotel_detail_member_name_tv);
        hotel_detail_member_tv = (TextView) findViewById(R.id.hotel_detail_member_tv);
        hotel_detail_comment_publish_time_tv = (TextView) findViewById(R.id.hotel_detail_comment_publish_time_tv);
        hotel_detail_comment_tv = (TextView) findViewById(R.id.hotel_detail_comment_tv);
        hotel_detail_comment_gv = (NoScrollGirdView) findViewById(R.id.hotel_detail_comment_gv);
        hotel_detail_member_iv = (ImageView) findViewById(R.id.hotel_detail_member_iv);
        hotel_detail_comment_rb = (RatingBar) findViewById(R.id.hotel_detail_comment_rb);
        hotel_detail_policy_lv = (NoScrollListView) findViewById(R.id.hotel_detail_policy_lv);
        hotel_detail_recommend_rv = (RecyclerView) findViewById(R.id.hotel_detail_recommend_rv);
        hotel_detail_comment_all_count_tv = (TextView) findViewById(R.id.hotel_detail_comment_all_count_tv);
        loadData();
    }

    public int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }

    public void loadData() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        dateCheck = new Date();//取时间
        dateOut = new Date();
        calendar = new GregorianCalendar();
        calendar.setTime(dateCheck);
        checkDate = formatter.format(dateCheck);
        calendar.add(calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        dateOut = calendar.getTime(); //这个时间就是日期往后推一天的结果
        outDate = formatter.format(dateOut);
        hotel_detail_check_day_tv.setText(checkDate);
        hotel_detail_out_day_tv.setText(outDate);
        bundle.putString("check",checkDate);
        bundle.putString("out",outDate);

    }

    public void loadMessage() {
        OkHttpUtils
                .post()
                .url(Api.HOTELDETAIL)
                .addParams("hotel_id", hotel_id)
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
                            Gson gson = new Gson();
                            hotelDetailEntities = gson.fromJson(response.toString(), HotelDetailEntity.class);
                            if (hotelDetailEntities.getStatus() == 330) {
                                bannerBeen = hotelDetailEntities.getInfo().getBanner();
                                atlasBeen = hotelDetailEntities.getInfo().getAtlas();
                                hotelBeen = hotelDetailEntities.getInfo().getHotel();
                                roomBeen = hotelDetailEntities.getInfo().getRoom();
                                tagBeen = hotelDetailEntities.getInfo().getHotel_detail().getTag();
                                deposit = hotelDetailEntities.getInfo().getDeposit();
                                policyBeen = hotelDetailEntities.getInfo().getPolicy();
                                hotelIntroBeen = hotelDetailEntities.getInfo().getHotel_intro();
                                tagBeanXes = hotelDetailEntities.getInfo().getTag();
                                photoBeen = hotelDetailEntities.getInfo().getApply().getPhoto();
                                hotel_detail_name_tv.setText(hotelDetailEntities.getInfo().getHotel_detail().getHotel_name());
                                hotel_detail_ad_count_tv.setText(hotelDetailEntities.getInfo().getHotel_detail().getPhoto_total());
                                hotel_detail_year_tv.setText(hotelDetailEntities.getInfo().getHotel_detail().getOpen_date());
                                hotel_detail_comment_score_tv.setText(hotelDetailEntities.getInfo().getHotel_detail().getComment_score() + "");
                                hotel_detail_comment_chinese_tv.setText(hotelDetailEntities.getInfo().getHotel_detail().getComment_score_desc());
                                hotel_detail_comment_count_tv.setText(hotelDetailEntities.getInfo().getHotel_detail().getComment_count() + "条评论");
                                hotel_detail_rb.setRating((float) hotelDetailEntities.getInfo().getHotel_detail().getComment_score());
                                if (tagBeen != null && tagBeen.size() > 0) {
                                    hotel_detail_comment_tag1_tv.setText(tagBeen.get(0).getTag_name());
                                    hotel_detail_comment_tag1_tv.setVisibility(View.VISIBLE);
                                    if (tagBeen.size() > 1)
                                        hotel_detail_comment_tag2_tv.setText(tagBeen.get(1).getTag_name());
                                    hotel_detail_comment_tag2_tv.setVisibility(View.VISIBLE);
                                }
                                hotelDetailIntroAdapter = new HotelDetailIntroAdapter(mContext, hotelIntroBeen);
                                hotel_detail_hotel_intro_gv.setAdapter(hotelDetailIntroAdapter);
                                //banner
                                List<String> bannerUrls = new ArrayList<>();
                                if (bannerBeen!= null) {
                                    for (int i = 0; i < bannerBeen.size(); i++) {
                                        bannerUrls.add(UrlUtils.getUrl(bannerBeen.get(i).getPhoto()));
                                    }
                                }
                                hotel_detail_banner.setImages(bannerUrls)
                                        .setImageLoader(new GlideImageLoader())
                                        .start();
                                //room
                                checkRoom(roomBeen);

                                //comment
                                Glide.with(mContext).load(UrlUtils.getUrl(hotelDetailEntities.getInfo().getApply().getFace())).asBitmap().into(hotel_detail_head_cv);
                                hotel_detail_member_name_tv.setText(hotelDetailEntities.getInfo().getApply().getNickname());
                                hotel_detail_member_tv.setText(hotelDetailEntities.getInfo().getApply().getRank_name());
                                hotel_detail_comment_publish_time_tv.setText(hotelDetailEntities.getInfo().getApply().getCreate_time());
                                hotel_detail_comment_tv.setText(hotelDetailEntities.getInfo().getApply().getContent());
                                hotel_detail_comment_rb.setRating(Float.parseFloat(hotelDetailEntities.getInfo().getApply().getScore()));
                                hotel_detail_comment_all_count_tv.setText("(" + hotelDetailEntities.getInfo().getHotel_detail().getComment_count() + ")");
                                hotelDetailCommentImgAdapter = new HotelDetailCommentImgAdapter(mContext, photoBeen);
                                hotel_detail_comment_gv.setAdapter(hotelDetailCommentImgAdapter);

                                //政策
                                hotelDetailPolicyAdapter = new HotelDetailPolicyAdapter(mContext, policyBeen);
                                hotel_detail_policy_lv.setAdapter(hotelDetailPolicyAdapter);

                                //评论流式
                                FlowLayoutManager flowLayoutManagerComment = new FlowLayoutManager();
                                hotel_detail_comment_rv.addItemDecoration(new SpaceItemDecoration(dp2px(5)));
                                hotel_detail_comment_rv.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_CANCEL, 0, 0, 0));
                                hotel_detail_comment_rv.setLayoutManager(flowLayoutManagerComment);
                                hotel_detail_comment_rv.setNestedScrollingEnabled(false);
                                hotelDetailCommentTagAdapter = new HotelDetailCommentTagAdapter(mContext, tagBeanXes);
                                hotel_detail_comment_rv.setAdapter(hotelDetailCommentTagAdapter);

                                //酒店推荐
                                LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(mContext);
                                linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
                                hotel_detail_recommend_rv.setLayoutManager(linearLayoutManager2);
                                hotel_detail_recommend_rv.setNestedScrollingEnabled(false);
                                hotelDetailRecommendAdapter = new HotelDetailRecommendAdapter(mContext, hotelBeen);
                                int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.home_city_item_div);
                                hotel_detail_recommend_rv.addItemDecoration(new com.tryine.zzp.utils.SpaceItemDecoration(spacingInPixels, com.tryine.zzp.utils.SpaceItemDecoration.HORIZONTAL_LIST));
                                hotelDetailRecommendAdapter.setOnItemClickListener(new HotelDetailRecommendAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View v, int position) {
                                        bundle.putString("hotel_id", hotelBeen.get(position).getHotel_id());
                                        bundle.putString("hotel_name", hotelBeen.get(position).getHotel_name());
                                        startAct(HotelDetailActivity.class,bundle);
                                    }
                                });

                                hotel_detail_recommend_rv.setAdapter(hotelDetailRecommendAdapter);
                            } else if (hotelDetailEntities.getStatus() == 362) {
                                ToastUtils.showShort(hotelDetailEntities.getMsg());
                                finish();
                            } else if (hotelDetailEntities.getStatus() == 385) {
                                ToastUtils.showShort(hotelDetailEntities.getMsg());
                                finish();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        bundle.putString("hotel_id", hotel_id);
        switch (v.getId()) {
            case R.id.view_head_back:
                finish();
                break;
            case R.id.view_head_share:
                break;
            case R.id.view_head_collect:
                hotelCollect();
                break;
            case R.id.hotel_detail_intro_more_iv:
            case R.id.hotel_detail_all_policy_tv:
            case R.id.hotel_detail_all_policy_iv:
                startAct(HotelEquipmentDetailActivity.class, bundle);
                break;
            case R.id.hotel_detail_comment_all_iv:
            case R.id.hotel_detail_all_comment_iv:
                startAct(HotelDetailAllCommentActivity.class, bundle);
                break;
        }
    }

    public void hotelCollect() {
        OkHttpUtils
                .post()
                .url(Api.HOTELCOLLECT)
                .addParams("hotel_id", hotel_id)
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
                            ToastUtils.showShort(jsonObject.getString("msg"));
                            if (jsonObject.getInt("status") == 330) {
                                view_head_share.setImageResource(R.drawable.hotel_list_collect_icon);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void checkRoom(final List<HotelDetailEntity.InfoBean.RoomBean> roomBeen) {
        hotelDetailRoomAdapter = new HotelDetailRoomAdapter(mContext, roomBeen);
        hotel_detail_room_gv.setAdapter(hotelDetailRoomAdapter);

        hotelDetailRoomAdapter.setOnCheckClickListener(new HotelDetailRoomAdapter.OnCheckClickListener() {
            @Override
            public void onCheck(View v, int position) {
                if (roomBeen.get(position).getSku() != 0) {
                    room_id = roomBeen.get(position).getRoom_id();
                    bundle.putString("room_id",room_id);
                    startAct(HotelOrderTimeActivity.class,bundle);
                }
            }

            @Override
            public void onPai(View v, final int position) {
                NiceDialog.init()
                        .setLayoutId(R.layout.hotel_interest_pai_dialog)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            protected void convertView(ViewHolder viewHolder, final BaseNiceDialog baseNiceDialog) {
                                room_id = roomBeen.get(position).getRoom_id();
                                viewHolder.setOnClickListener(R.id.hotel_detail_pai_close_iv, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        baseNiceDialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setOutCancel(false)
                        .setAnimStyle(R.style.EnterExitAnimation)
                        .show(getSupportFragmentManager());
            }
        });

        hotel_detail_room_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                room_id = roomBeen.get(position).getRoom_id();
                loadRoomMessage(room_id, position);
            }
        });

    }

    public void loadRoomMessage(String room_id, final int position) {
        OkHttpUtils
                .post()
                .url(Api.HOTELDETAILROOM)
                .addParams("room_id", room_id)
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
                            if (jsonObject.getInt("status") == 330) {
                                Gson gson = new Gson();
                                HotelDetailRoomEntity hotelDetailRoomEntities = gson.fromJson(response.toString(), HotelDetailRoomEntity.class);
                                roomPolicyBeen = hotelDetailRoomEntities.getInfo().getPolicy();
                                roomFacilitiesBeen = hotelDetailRoomEntities.getInfo().getFacilities();
                                roomCheckDialog(position, roomPolicyBeen, roomFacilitiesBeen);
                            } else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void roomCheckDialog(final int position, final List<HotelDetailRoomEntity.InfoBean.PolicyBean> roomPolicyBeen, final List<HotelDetailRoomEntity.InfoBean.FacilitiesBean> roomFacilitiesBeen) {
        if (hotelDetailEntities.getInfo().getRoom().get(position).getSku() != 0) {
            NiceDialog.init()
                    .setLayoutId(R.layout.hotel_detail_room_dialog_item)
                    .setConvertListener(new ViewConvertListener() {
                        @Override
                        protected void convertView(ViewHolder viewHolder, final BaseNiceDialog baseNiceDialog) {
                            viewHolder.setOnClickListener(R.id.hotel_detail_room_close_iv, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    baseNiceDialog.dismiss();
                                }
                            });
                            viewHolder.setOnClickListener(R.id.hotel_detail_room_dialog_check_tv, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    room_id=roomBeen.get(position).getRoom_id();
                                    bundle.putString("room_id",room_id);
                                    bundle.putString("hotel_name",hotel_name);
                                    startAct(HotelOrderTimeActivity.class,bundle);
                                }
                            });
                            viewHolder.setOnClickListener(R.id.hotel_detail_room_dialog_pai_ll, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ToastUtils.showShort("pai");
                                }
                            });
                            viewHolder.setText(R.id.hotel_detail_room_dialog_type_tv, roomBeen.get(position).getTitle());
                            viewHolder.setText(R.id.hotel_detail_room_dialog_price_tv, "一晚总价：" + roomBeen.get(position).getPrice());

                            View dialogView = viewHolder.getConvertView();
                            List<String> bannerUrls = new ArrayList<>();
                            if (bannerBeen!= null) {
                                for (int i = 0; i < bannerBeen.size(); i++) {
                                    bannerUrls.add(UrlUtils.getUrl(bannerBeen.get(i).getPhoto()));
                                }
                            }
                            hotel_detail_room_dialog_cb = (Banner) dialogView.findViewById(R.id.hotel_detail_room_dialog_cb);

                            hotel_detail_room_dialog_policy_lv = (NoScrollListView) dialogView.findViewById(R.id.hotel_detail_room_dialog_policy_lv);
                            hotel_detail_room_dialog_facilities_lv = (NoScrollListView) dialogView.findViewById(R.id.hotel_detail_room_dialog_facilities_lv);

                            hotelDetailDialogRoomAdapterFacilities = new HotelDetailDialogRoomAdapter(baseNiceDialog.getContext(), null, roomFacilitiesBeen);
                            hotelDetailDialogRoomAdapterPolicy = new HotelDetailDialogRoomAdapter(baseNiceDialog.getContext(), roomPolicyBeen, null);
                            hotel_detail_room_dialog_policy_lv.setAdapter(hotelDetailDialogRoomAdapterPolicy);
                            hotel_detail_room_dialog_facilities_lv.setAdapter(hotelDetailDialogRoomAdapterFacilities);
                        }
                    })
                    .setOutCancel(false)
                    .setAnimStyle(R.style.EnterExitAnimation)
                    .show(getSupportFragmentManager());
        }

    }

}
