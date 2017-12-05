package com.tryine.zzp.utils;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.tryine.zzp.R;
import com.tryine.zzp.widget.SquareImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: BannerHelper
 * Details:
 * Created by PC on 2017/5/24.
 * Update:
 */

public class BannerHelper {

    private static BannerHelper mInstance;
    private ConvenientBanner banner;
    //本地图片
    private int res;
    private boolean isRect = false;


    private BannerHelper() {
    }

    public static BannerHelper getInstance() {
        if (mInstance != null) {
            return mInstance;
        } else {
            return mInstance = new BannerHelper();
        }

    }

    public void config(@NonNull ConvenientBanner banner, List<String> urls) {
        this.config(banner, urls, R.drawable.defualt);
    }

    public void config(@NonNull ConvenientBanner banner, List<String> urls, @DrawableRes int defualtRes) {
        this.config(banner, urls, defualtRes, false);
    }

    public void config(@NonNull ConvenientBanner banner, List<String> urls, @DrawableRes int defualtRes, boolean isRect) {
        this.banner = banner;
        this.res = defualtRes;
        this.isRect = isRect;
        if (urls != null && urls.size() > 0) {
            useNetImg(urls);
        } else {
            useLocalImg();
        }
    }

    /**
     * 加载网络图片
     */
    private void useNetImg(List<String> urls) {
        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        banner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, urls)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
//                .setPageIndicator(new int[]{R.drawable.res_viewpager_indicater_full, R.drawable.res_viewpager_indicater_ring})
                .setPageIndicator(new int[]{R.drawable.res_bg_point_green_small, R.drawable.res_bg_point_white})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
        //设置翻页的效果，不需要翻页效果可用不设
        //.setPageTransformer(Transformer.DefaultTransformer);    集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
//        convenientBanner.setManualPageable(false);//设置不能手动影响
        banner.startTurning(5000);
    }

    /**
     * 加载本地图片
     */
    private void useLocalImg() {
        List localImages = new ArrayList<Integer>();
        localImages.add(res);
        banner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, localImages)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.res_bg_point_green_small, R.drawable.res_bg_point_white})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                //设置翻页的效果，不需要翻页效果可用不设
                //.setPageTransformer(Transformer.DefaultTransformer);    集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
                //convenientBanner.setManualPageable(false);//设置不能手动影响
                .startTurning(5000);
    }


    private class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (isRect) {
                imageView = new SquareImageView(context);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            imageView.setAdjustViewBounds(true);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            imageView.setImageResource(data);
        }
    }

    private class NetworkImageHolderView implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
            imageView = new ImageView(context);
            if (isRect) {
                imageView = new SquareImageView(context);
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setAdjustViewBounds(true);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            imageView.setImageResource(res);
            Glide.with(context).load(data).asBitmap().into(imageView);
        }
    }


}
