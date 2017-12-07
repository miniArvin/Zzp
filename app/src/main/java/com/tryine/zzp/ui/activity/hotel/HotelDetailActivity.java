package com.tryine.zzp.ui.activity.hotel;


import android.os.SystemClock;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;

import com.blankj.utilcode.util.LogUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.adapter.HotelDetailCommentAdapter;
import com.tryine.zzp.adapter.HotelDetailRoomAdapter;
import com.tryine.zzp.adapter.SearchKeyWordAdapter;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.widget.FlowLayout.FlowLayoutManager;
import com.tryine.zzp.widget.FlowLayout.SpaceItemDecoration;
import com.tryine.zzp.widget.NoScrollGirdView;
import com.tryine.zzp.widget.NoScrollListView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class HotelDetailActivity extends BaseStatusMActivity {
    private List<String> lists;
    private NoScrollGirdView hotel_detail_room_gv;
    private HotelDetailRoomAdapter hotelDetailRoomAdapter;
    private NoScrollListView hotel_detail_comment_lv;
    private HotelDetailCommentAdapter hotelDetailCommentAdapter;
    private RecyclerView hotel_detail_comment_rv;
    private SearchKeyWordAdapter searchKeyWordAdapter;
    private String hotel_id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hotel_detail;
    }

    @Override
    protected void afterOnCreate() {
        hotel_id=getIntent().getStringExtra("hotel_id");
        loadMessage();
        initView();
    }

    public void initView(){
        lists=new ArrayList<>();
        lists.add("全部 88");
        lists.add("位置优越 1");
        lists.add("设施好 2");
        lists.add("全部 3");
        lists.add("全部 4");
        lists.add("全部 5");
        lists.add("全部 88");
        lists.add("位置优越 1");
        lists.add("设施好 2");
        lists.add("全部 3");
        hotel_detail_room_gv= (NoScrollGirdView) findViewById(R.id.hotel_detail_room_gv);
        hotelDetailRoomAdapter=new HotelDetailRoomAdapter(this);
        hotel_detail_room_gv.setAdapter(hotelDetailRoomAdapter);
        hotel_detail_comment_lv= (NoScrollListView) findViewById(R.id.hotel_detail_comment_lv);
        hotelDetailCommentAdapter=new HotelDetailCommentAdapter(this);
        hotel_detail_comment_lv.setAdapter(hotelDetailCommentAdapter);
        hotel_detail_comment_rv= (RecyclerView) findViewById(R.id.hotel_detail_comment_rv);
        FlowLayoutManager flowLayoutManagerComment = new FlowLayoutManager();
        hotel_detail_comment_rv.addItemDecoration(new SpaceItemDecoration(dp2px(5)));
        hotel_detail_comment_rv.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_CANCEL, 0, 0, 0));
        hotel_detail_comment_rv.setLayoutManager(flowLayoutManagerComment);
        hotel_detail_comment_rv.setNestedScrollingEnabled(false);
//        searchKeyWordAdapter=new SearchKeyWordAdapter(lists,this);
//        hotel_detail_comment_rv.setAdapter(searchKeyWordAdapter);

    }
    public int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
     public void loadData(){

     }

     public void loadMessage(){
         OkHttpUtils
                 .post()
                 .url(Api.HOTELDETAIL)
                 .addParams("hotel_id",hotel_id)
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
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                     }
                 });
     }
}
