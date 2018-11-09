package com.example.frescodemo;

import android.content.Context;
import android.graphics.Bitmap;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.ByteConstants;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.io.File;

/**
 * Fresco配置
 */
public class ImagePipelineConfigFactory {
    private static final String IMAGE_PIPELINE_CACHE_DIR = "imageCache";

    private static ImagePipelineConfig sImagePipelineConfig;
    private static final int MAX_HEAP_SIZE = (int) Runtime.getRuntime().maxMemory(); // 程序最大堆内存

    public static final int MAX_DISK_CACHE_SIZE = 300 * ByteConstants.MB; // 设置缓存文件最大缓存
    public static final int MAX_MEMORY_CACHE_SIZE = MAX_HEAP_SIZE / 3;  //可用最大缓存数

    /**
     * 配置ImagePipelineConfig
     */
    public static ImagePipelineConfig getImagePipelineConfig(Context context) {
        if (sImagePipelineConfig == null) {
            ImagePipelineConfig.Builder configBuilder = ImagePipelineConfig.newBuilder(context);
            configureCaches(configBuilder, context);
            configBuilder.setBitmapsConfig(Bitmap.Config.RGB_565); // 在RGB_565的条件下过滤alpha通道，图片消耗内存量会降低，进一步降低OOM的风险
            configBuilder.setDownsampleEnabled(true); // 必须和ImageRequest的ResizeOptions一起使用，也是起到降低OOM的风险
            sImagePipelineConfig = configBuilder.build();
        }
        return sImagePipelineConfig;
    }

    /**
     * 配置磁盘和内存缓存不超过公共限制
     */
    private static void configureCaches(ImagePipelineConfig.Builder configBuilder, Context context) {
        final MemoryCacheParams bitmapCacheParams = new MemoryCacheParams(
                MAX_MEMORY_CACHE_SIZE, // 可用最大的缓存数
                Integer.MAX_VALUE,     // 内存中允许的最多图片数量
                MAX_MEMORY_CACHE_SIZE, // 内存中准备清理但是尚未清除的总图片可用的最大内存数
                Integer.MAX_VALUE,     // 内存中准备清除的
                Integer.MAX_VALUE);    // 内存中单图片的最大大小

        configBuilder.setBitmapMemoryCacheParamsSupplier(
                new Supplier<MemoryCacheParams>() {
                    public MemoryCacheParams get() {
                        return bitmapCacheParams;
                    }
                })  //配置缓存策略
                .setMainDiskCacheConfig(DiskCacheConfig.newBuilder(context)
                        .setBaseDirectoryPath(getExternalCacheDir(context)) // 设置缓存图片本地根目录路径
                        .setBaseDirectoryName(IMAGE_PIPELINE_CACHE_DIR) // 设置缓存文件夹名称
                        .setMaxCacheSize(MAX_DISK_CACHE_SIZE)  // 设置缓存文件最大缓存
                        .build());
    }

    /**
     * 设置缓存图片本地根目录路径
     */
    public static File getExternalCacheDir(final Context context) {
        return context.getExternalCacheDir();
    }
}
