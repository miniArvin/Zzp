package com.tryine.zzp.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tryine.zzp.R;
import com.tryine.zzp.widget.LoadingProgressDialog;

/**
 * 项目名称：DevPKG
 * 类：BaseFragment
 * 描述：
 * 创建人：Yugr
 * 创建日期：2016/11/14
 * 时间：14:07
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;
    protected Context mContext;
    protected View mView;
    protected LoadingProgressDialog progressDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mActivity = getActivity();
        mContext = mActivity;
        progressDialog = new LoadingProgressDialog(mContext);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getContentViewLayoutID() != 0) {
            mView = inflater.inflate(getContentViewLayoutID(), null);
        } else {
            mView = super.onCreateView(inflater, container, savedInstanceState);
        }
        onBind(mView);
        return mView;
    }

    protected void onBind(View view) {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        afterCreated(savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
        Intent intent = new Intent(mActivity, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (isCloseCurrentActivity) {
            mActivity.finish();
        }
        mActivity.overridePendingTransition(R.anim.start_in_left, R.anim.start_out_left);
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
        mActivity.overridePendingTransition(R.anim.start_in_left, R.anim.start_out_left);
    }
    protected abstract int getContentViewLayoutID();

    protected abstract void afterCreated(Bundle savedInstanceState);


}
