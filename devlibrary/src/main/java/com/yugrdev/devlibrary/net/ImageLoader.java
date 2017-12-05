package com.yugrdev.devlibrary.net;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yugrdev.devlibrary.Dev;

import java.io.File;

/**
 * 项目名称：DevPKG
 * 类：ImageLoader
 * 描述：
 * 创建人：Yugr
 * 创建日期：2016/11/14
 * 时间：14:36
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class ImageLoader {
    /*
    *
    *  Glide.with(this).load("url")
        .placeholder(R.drawable.ic_launcher)//占位图 未加载时显示
        .error(R.drawable.icon)//加载失败时显示
        .crossFade() //设置显示动画
        .override(200, 240)//裁剪 fitCenter()和centerCrop() 显示模式
        .into(image);
    * */

    private static ImageLoader sInstance;
    private static Context mContext;

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        if (sInstance == null) {
            sInstance = new ImageLoader();
        }
        mContext = Dev.getContext();
        return sInstance;
    }

    /**
     * 从网络加载图片
     *
     * @param view
     * @param url
     */
    public void display(ImageView view, String url) {
        Glide.with(mContext)
                .load(url)
                .into(view);
    }

    /**
     * 获取网络图片，设置默认图片与请求失败图片为同一张图片
     *
     * @param view
     * @param url
     * @param defualtImg
     */
    public void display(ImageView view, String url, @DrawableRes int defualtImg) {
        Glide.with(mContext)
                .load(url)
                .error(defualtImg)
//                .placeholder(defualtImg)
                .into(view);
    }

    public void display(ImageView view, String url, Drawable defualtImg) {
        Glide.with(mContext)
                .load(url)
                .placeholder(defualtImg)
                .into(view);
    }

    public void display(ImageView view, String url, @DrawableRes int defualtImg, @DrawableRes int errorImg) {
        Glide.with(mContext)
                .load(url)
                .placeholder(defualtImg)
                .error(errorImg)
                .into(view);
    }

    public void display(ImageView view, File file) {
        Glide.with(mContext)
                .load(Uri.fromFile(file))
                .into(view);
    }

    public void display(ImageView view, File file, @DrawableRes int defualtImg) {
        Glide.with(mContext)
                .load(Uri.fromFile(file))
                .error(defualtImg)
//                .placeholder(defualtImg)
                .into(view);
    }

    public void display(ImageView view, @DrawableRes int resId) {
        Glide.with(mContext)
                .load(resId)
                .into(view);
    }

}
