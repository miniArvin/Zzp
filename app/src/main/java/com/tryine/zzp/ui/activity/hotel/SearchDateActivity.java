package com.tryine.zzp.ui.activity.hotel;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.tryine.zzp.R;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.tryine.zzp.widget.HotelCalendar.CalendarAdapter;
import com.tryine.zzp.widget.HotelCalendar.bean.HotelDateBean;
import com.tryine.zzp.widget.HotelCalendar.bean.HotelDayBean;
import com.tryine.zzp.widget.HotelCalendar.bean.HotelMonthBean;
import com.tryine.zzp.widget.HotelCalendar.helper.DateBeanHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SearchDateActivity extends BaseStatusMActivity {

    private RecyclerView calendarRV;
    private List<HotelDateBean> items = new ArrayList<>();  //所有的条目
    private DateBeanHelper mDateBeanHelper;   //处理日历逻辑的类
    private CalendarAdapter adapter;
    private GridLayoutManager mGridLayoutManager;
    private HotelDayBean start = new HotelDayBean(); //选中的开始时间
    private HotelDayBean end = new HotelDayBean();  //选中的结束时间
    private int maxMonthPeroid=12;           //从现在开始到结束的，月份范围
    private int monthIndex=0;          //当前最大的月份与开始的月的差
    private TextView tv_year;
    private TextView tv_end_date;
    private TextView tv_start_date;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_date;
    }

    @Override
    protected void afterOnCreate() {
        init();
    }

    public void init(){
        calendarRV = (RecyclerView) findViewById(R.id.rv_calendar);
        tv_start_date= (TextView) findViewById(R.id.tv_start_date);
        tv_end_date= (TextView) findViewById(R.id.tv_end_date);
        tv_year= (TextView) findViewById(R.id.tv_year);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        String date=sdf.format(new java.util.Date());
        tv_year.setText(date+"年");
        mGridLayoutManager = new GridLayoutManager(this, 7);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                HotelDateBean bean = items.get(position);
                if (bean instanceof HotelMonthBean)
                    return 7;
                else return 1;
            }
        });
//        calendarRV.addItemDecoration(new DividerItemDecortion(this));
        calendarRV.setLayoutManager(mGridLayoutManager);
        mDateBeanHelper = new DateBeanHelper();
        initItems();
        adapter = new CalendarAdapter(this, items);
        calendarRV.setAdapter(adapter);
        adapter.setOnItemClickListener(new CalendarAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                HotelDayBean bean = (HotelDayBean) items.get(position);
                if (bean == null)
                    return;
                sovleItemClick(bean);
            }
        });
        calendarRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(monthIndex>=maxMonthPeroid)
                    return;
                if(mDateBeanHelper.isLastItemVisible(recyclerView,items.size())){
                    mDateBeanHelper.loadMoreItems(items,monthIndex);
                    monthIndex++;
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void initItems() {
        HotelDayBean start = new HotelDayBean();
        start.setData(2017, 8, 22);
        HotelDayBean end = new HotelDayBean();
        end.setData(2017, 8, 24);
        mDateBeanHelper.isInTimePeriod(start, end);
        for (int i = 0; i < 12; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, i);
            if (i != 0)
                calendar.set(Calendar.DAY_OF_MONTH, 1);
            items.addAll(mDateBeanHelper.getHotelDateBeans(calendar));
            monthIndex++;
        }
        int j=0;
        for(HotelDateBean dateBean:items){
            if(dateBean instanceof HotelDayBean){
                if(((HotelDayBean) dateBean).getYear()==0){
                    mDateBeanHelper.solveBlankItem(items,(HotelDayBean) dateBean,j);
                }else mDateBeanHelper.getPeriod((HotelDayBean) dateBean,start,end);
            }
            j++;
        }

    }

    /**
     * 解决点击时间
     * @param bean
     */
    private void sovleItemClick(HotelDayBean bean) {
        int monthS,monthE;
        if (bean.getYear() == 0 || bean.getState() == HotelDayBean.STATE_PAST)
            return;
        Calendar calendar=mDateBeanHelper.setCalendar(bean);
        Calendar startCalendar=mDateBeanHelper.setCalendar(start);
        if(start.getYear()!=0&&end.getYear()!=0){
            start.setData(0,0,0);
            end.setData(0,0,0);
            tv_start_date.setText(start.getYear()+"年"+start.getMonth()+"月"+start.getDay()+"日");
        }
        if(start.getYear()==0||(calendar.getTimeInMillis()<startCalendar.getTimeInMillis())){
            mDateBeanHelper.setAllNormal(items);
            bean.setState(HotelDayBean.STATE_CHOSED);
            adapter.notifyDataSetChanged();
            start.setData(bean.getYear(),bean.getMonth(),bean.getDay());
            monthS=Integer.valueOf(start.getMonth())+1;
            tv_start_date.setText(start.getYear()+"年"+monthS+"月"+start.getDay()+"日");
            tv_end_date.setText("");
            return;
        }

        if(end.getYear()==0){
            end.setData(bean.getYear(),bean.getMonth(),bean.getDay());
            mDateBeanHelper.onEndClick(items,start,end);
            monthS=Integer.valueOf(start.getMonth())+1;
            monthE=Integer.valueOf(end.getMonth())+1;
            tv_start_date.setText(start.getYear()+"年"+monthS+"月"+start.getDay()+"日");
            tv_end_date.setText(end.getYear()+"年"+monthE+"月"+end.getDay()+"日");
            adapter.notifyDataSetChanged();
        }

    }




}
