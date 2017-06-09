package wantao.wt.myapplication;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import wantao.wt.myapplication.utils.FrescoHelper;

/**
 * Created by wantao on 2017/5/18.
 */

public class MyApplication extends Application {
    public static  Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;

        // 初始化图片加载fresco
        Fresco.initialize(getApplicationContext(), FrescoHelper.getImagePipelineConfig(getApplicationContext()));
    }
}
