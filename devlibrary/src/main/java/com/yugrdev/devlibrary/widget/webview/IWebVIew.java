package com.yugrdev.devlibrary.widget.webview;

import android.content.Context;
import android.util.AttributeSet;

import com.tencent.smtt.sdk.WebView;

import java.util.Map;

/**
 * 项目名称：DevPKG
 * 类：IWebVIew
 * 描述：
 * 创建人：Yugr
 * 创建日期：2017/1/16
 * 时间：11:25
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class IWebVIew extends WebView {
    public IWebVIew(Context context) {
        super(context);
    }

    public IWebVIew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IWebVIew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public IWebVIew(Context context, AttributeSet attributeSet, int i, boolean b) {
        super(context, attributeSet, i, b);
    }

    public IWebVIew(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean b) {
        super(context, attributeSet, i, map, b);
    }
}
