package com.yugrdev.devlibrary.widget.webview;

import android.graphics.Bitmap;

import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.yugrdev.devlibrary.widget.dialog.LoadingProgressDialog;

/**
 * 项目名称：DevPKG
 * 类：IWebViewClient
 * 描述：
 * 创建人：Yugr
 * 创建日期：2016/11/14
 * 时间：15:06
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class IWebViewClient extends WebViewClient {
    LoadingProgressDialog progressDialog;

    public IWebViewClient() {
    }

    public IWebViewClient(LoadingProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    /**
     * 重写shouldOverrideUrlLoading方法，使点击链接后不使用其他的浏览器打开。
     */
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }


    /**
     * 页面加载结束
     *
     * @param view
     * @param url
     */
    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        //页面加载结束的处理
        if (progressDialog != null) {
            progressDialog.safeDismiss();

        }
    }

    /**
     * 页面加载开始
     *
     * @param view
     * @param url
     * @param favicon
     */
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        //页面开始加载的处理
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    @Override
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebViewClient.a a) {
        super.onReceivedError(webView, webResourceRequest, a);
    }
}
