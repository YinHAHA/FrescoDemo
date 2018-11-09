package com.example.frescodemo;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class ImageLoaderUtils {

    private Context mContext;

    private static ImageLoaderUtils instance;

    public ImageLoaderUtils(Context context) {
        this.mContext = context;
        instance = this;
    }

    public static ImageLoaderUtils getInstance() {
        if (instance == null) {
            instance = new ImageLoaderUtils(MyApplication.getInstance());
        }
        return instance;
    }

    /**
     * 普通的图片加载方法
     *
     * @param imageView imageview控件
     * @param uriStr    图片url
     */
    public void setImage(SimpleDraweeView imageView, String uriStr) {

        if (imageView == null || TextUtils.isEmpty(uriStr)) {
            return;
        }
        Uri uri = Uri.parse(uriStr);
        imageView.setImageURI(uri);
    }

    /**
     * 设置图片下载监听的图片加载方法
     *
     * @param imageView imageview控件
     * @param uriStr    图片url
     * @param listener  下载监听
     */
    public void setImage(SimpleDraweeView imageView, String uriStr, BaseControllerListener listener) {

        if (imageView == null || TextUtils.isEmpty(uriStr)) {
            return;
        }
        Uri uri = Uri.parse(uriStr);

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .build();

        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(imageView.getController())
                .setControllerListener(listener)
                .build();
        imageView.setController(controller);
    }

    /**
     * 清除磁盘缓存
     */
    public static long getDiskCache() {
        long cacheSize = Fresco.getImagePipelineFactory().getMainFileCache().getSize();
        return cacheSize;
    }

    /**
     * 清除磁盘缓存
     */
    public static void clearDiskCache() {
        Fresco.getImagePipeline().clearCaches();
    }


}
