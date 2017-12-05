package com.yugrdev.devlibrary.widget.webview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.KeyEvent;
import android.widget.Toast;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.yugrdev.devlibrary.R;
import com.yugrdev.devlibrary.widget.dialog.LoadingProgressDialog;

/**
 * 项目名称：DevPKG
 * 类：WebViewUtils
 * 描述：使用TBS x5WebView
 * 创建人：Yugr
 * 创建日期：2016/11/14
 * 时间：14:56
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class WebViewUtils {
    protected WebView mWebView;
    protected Activity mActivity;
    protected Context mContext;
    private long mExitTime;
    private LoadingProgressDialog progressDialog;
    //    private final long KEYDOWN_TIME = 2000;

    public WebViewUtils(Activity activity, WebView webView) {
        mActivity = activity;
        mWebView = webView;
        mContext = activity;

    }


    /**
     * 初始化WebView设置，加载url
     */
    public void init(String url) {
        WebSettings setting = mWebView.getSettings();
        setting.setAllowFileAccess(true);
        setting.setDatabaseEnabled(true);
        setting.setCacheMode(WebSettings.LOAD_DEFAULT);
        setting.setAppCacheEnabled(true);
        setting.setJavaScriptEnabled(true);//支持js
        setting.setDomStorageEnabled(true);
        mWebView.loadUrl(url);
        progressDialog = new LoadingProgressDialog(mContext, R.style.AppTheme_LoadingDialog);
        mWebView.setWebViewClient(new IWebViewClient(progressDialog));
        mWebView.setWebChromeClient(new IWebChromeClient());
//        mWebView.setPictureListener(new WebView.PictureListener() {
//            @Override
//            public void onNewPicture(WebView webView, Picture picture) {
//
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        SystemClock.sleep(2000);
//                        progressDialog.safeDismiss();
//                    }
//                }).start();
//            }
//        });
    }


    /**
     * 给webview设置背景图片
     *
     * @param drawable
     */
    public void setBackground(int drawable) {
        mWebView.setBackgroundColor(Color.TRANSPARENT);
        mWebView.setBackgroundResource(drawable);
    }

    /**
     * 监听WebView的返回事件，位于webview首页时，在指定时间内两次点击返回键退出当前activity
     *
     * @param activity
     * @param webView
     * @param keyCode
     * @param keyEvent
     * @param timeout  超时时间，指定时间内双击返回键退出。
     */
    public boolean onBack(Activity activity, WebView webView, int keyCode, KeyEvent keyEvent, long timeout) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            // goBack()表示返回WebView的上一页面
            mWebView.goBack();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > timeout) {
                Toast.makeText(mActivity, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //记录当前系统时间
                mExitTime = System.currentTimeMillis();
                return true;
            } else {
                mActivity.finish();
                return true;
            }
        }
        return false;

    }

    /**
     * 监听WebView的返回事件，位于webview首页时，在2秒内两次点击返回键退出当前activity
     *
     * @param activity
     * @param webView
     * @param keyCode
     * @param keyEvent
     */
    public boolean onBack(Activity activity, WebView webView, int keyCode, KeyEvent keyEvent) {
        return onBack(activity, webView, keyCode, keyEvent, 2000);
    }
}
