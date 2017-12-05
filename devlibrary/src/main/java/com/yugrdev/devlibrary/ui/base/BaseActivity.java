package com.yugrdev.devlibrary.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yugrdev.devlibrary.R;
import com.yugrdev.devlibrary.app.ActivityCollector;
import com.yugrdev.devlibrary.widget.dialog.LoadingProgressDialog;

/**
 * 项目名称：DevPKG
 * 类：BaseActivity
 * 描述：
 * 创建人：Yugr
 * 创建日期：2016/11/14
 * 时间：14:07
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Activity mActivity;
    protected Context mContext;
    private LoadingProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != -1) {
            setContentView(getLayoutId());
        }
        ActivityCollector.addActivity(this);
        init();
        onBind();
        afterOnCreate();
    }

    protected void onBind() {

    }

    protected void init() {
        mActivity = this;
        mContext = this;
        progressDialog = new LoadingProgressDialog(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    public void showProgressDialog() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.safeDismiss();
        }
    }

    public void startAct(Class<?> clz) {
        startAct(clz, false);
    }


    public void startAct(Class<?> clz, boolean isCloseCurrentActivity) {
        startAct(clz, null, isCloseCurrentActivity);
    }

    public void startAct(Class<?> clz, Bundle bundle) {
        startAct(clz, bundle, false);
    }

    public void startAct(Class<?> clz, Bundle bundle, boolean isCloseCurrentActivity) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (isCloseCurrentActivity) {
            this.finish();
        }
        overridePendingTransition(R.anim.start_in_left, R.anim.start_out_left);
    }

    public void startActForResult(Class<?> clz, int requestCode) {
        startActForResult(clz, null, requestCode);
    }

    public void startActForResult(Class<?> clz, Bundle bundle, int requestCode) {
        Intent intent = new Intent(mActivity, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.start_in_left, R.anim.start_out_left);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.finish_in_left, R.anim.finish_out_left);
    }

    /**
     * 获取布局资源ID
     *
     * @return 资源ID
     */
    protected abstract int getLayoutId();

    protected abstract void afterOnCreate();

}
