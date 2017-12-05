package com.tryine.zzp.widget.HotelCalendar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.tryine.zzp.R;


public class CustomCalendarTextView extends AppCompatTextView {
    public static final int BACK_WHITE=1001;
    public static final int BACK_YELLOW_CIRCLE=1002;
    public static final int BACK_START=1002;
    public static final int BACK_END=1002;
    private int backType;
    private Paint mCirclePaint;
    public CustomCalendarTextView(Context context){
        super(context);
    }

    public CustomCalendarTextView(Context context, AttributeSet attrs){
        super(context,attrs);
        mCirclePaint=new Paint();
        mCirclePaint.setColor(context.getResources().getColor(R.color.orange));
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setAntiAlias(true);
    }
    @Override
    public void onDraw(Canvas canvas){
        int width=getWidth();
        int height=getHeight();
        if(backType==BACK_YELLOW_CIRCLE)
            canvas.drawCircle(width/2,height/2,height/2,mCirclePaint);
        super.onDraw(canvas);
    }

    public void setBackType(int backType){
        this.backType=backType;
    }
}
