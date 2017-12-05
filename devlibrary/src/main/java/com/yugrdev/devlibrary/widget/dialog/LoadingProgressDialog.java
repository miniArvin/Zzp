package com.yugrdev.devlibrary.widget.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yugrdev.devlibrary.R;
import com.yugrdev.devlibrary.utils.DensityUtils;

/**
 * 项目名称：DevPKG
 * 类：LoadingProgressDialog
 * 描述：
 * 创建人：Yugr
 * 创建日期：2017/1/5
 * 时间：14:12
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class LoadingProgressDialog extends ProgressDialog {


    public LoadingProgressDialog(Context context) {
        this(context, R.style.AppTheme_LoadingDialog);
    }

    public LoadingProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        Context context = getContext();
        setCancelable(false);
        setCanceledOnTouchOutside(false);

        setContentView(createDialogView(context));
    }

    private View createDialogView(Context context) {
        LinearLayout view = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtils.dip2px(context, 100), DensityUtils.dip2px(context, 100));
        params.gravity = Gravity.CENTER_HORIZONTAL;
        view.setOrientation(LinearLayout.VERTICAL);
        view.setLayoutParams(params);
        view.setBackgroundResource(R.drawable.shape_dialog_loading_bg);

        RelativeLayout bg = new RelativeLayout(context);
        RelativeLayout.LayoutParams bgParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        bg.setLayoutParams(bgParams);

        ProgressBar pb = new ProgressBar(context);
        RelativeLayout.LayoutParams pbParams = new RelativeLayout.LayoutParams(DensityUtils.dip2px(context, 65), DensityUtils.dip2px(context, 65));
        pbParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        pb.setLayoutParams(pbParams);

        TextView text = new TextView(context);
        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        text.setLayoutParams(textParams);
        text.setText("Loading...");
        text.setPadding(DensityUtils.dip2px(context, 10), DensityUtils.dip2px(context, 5), DensityUtils.dip2px(context, 10), DensityUtils.dip2px(context, 5));
        text.setTextSize(DensityUtils.sp2px(context, 4));
        text.setTextColor(Color.parseColor("#EEEEEE"));

        bg.addView(pb);
        view.addView(bg);
        view.addView(text);

        return view;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public void safeDismiss() {
        if (isShowing()) {
            dismiss();
        }
    }
}
