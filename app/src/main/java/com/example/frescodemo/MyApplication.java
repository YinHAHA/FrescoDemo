package com.example.frescodemo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * User: yinhaha
 * Date: 2018/11/6
 * Description:
 */

public class MyApplication extends Application {

    private static MyApplication instance;

    public static MyApplication getInstance() {
        if (instance == null) {
            instance = new MyApplication();
        }
        return instance;
    }
    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();

        initFresco();
    }

    /**
     * 初始化图片拉取库
     */
    public void initFresco() {
        //初始化Fresco
        Fresco.initialize(this, ImagePipelineConfigFactory.getImagePipelineConfig(this));
    }
}
