package com.example.benben.fresco.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.example.benben.fresco.R;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

import java.net.URI;
import java.net.URL;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by benben on 2016/5/4.
 * <p>
 * 控制构造器
 */
public class ControllerBuilDerActivity extends BaseActivity {
    @InjectView(R.id.controller_content_up)
    SimpleDraweeView mContentUp;
    @InjectView(R.id.controller_content_down)
    SimpleDraweeView mContentDown;

    public static void startControllerBuilDerActivity(Activity activity) {
        Intent intent = new Intent(activity, ControllerBuilDerActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);
        ButterKnife.inject(this);
        initView1();
        initView2();
    }

    private void initView2() {
        /**DraweeController*/
        Uri uri=Uri.parse("http://i3.hoopchina.com.cn/blogfile/201212/21/135605895528067.gif");

        ControllerListener listener=new BaseControllerListener();

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .setAutoPlayAnimations(true)
                .setOldController(mContentUp.getController())
                .setControllerListener(listener)
                .build();
        mContentUp.setController(controller);
    }

    private void initView1() {
        /**自定义图片加载请求(失败)*/
        Uri uri = Uri.parse("http://www.chinanews.com/fileftp/2010/04/2010-04-02/U179P4T47D12780F970DT20100402102613.jpg");
mContentDown.setImageURI(uri);
//        Postprocessor postprocessor=new Postprocessor() {
//            @Override
//            public CloseableReference<Bitmap> process(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
//                return null;
//            }
//
//            @Override
//            public String getName() {
//                return null;
//            }
//
//            @Override
//            public CacheKey getPostprocessorCacheKey() {
//                return null;
//            }
//        };
//        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
//                .setPostprocessor(postprocessor)
//                .build();
//        DraweeController controller=Fresco.newDraweeControllerBuilder()
//                .setImageRequest(request)
//                .setOldController(mContentDown.getController())
//                .build();
//        mContentDown.setController(controller);
    }
}
