package com.example.benben.fresco.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benben.fresco.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class BeginActivity extends BaseActivity {

    public static void startBeginActivity(Activity activity) {
        Intent intent = new Intent(activity, BeginActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @InjectView(R.id.my_image_view)
    SimpleDraweeView mImageView;
    @InjectView(R.id.topLeft)
    ImageView mLeft;
    @InjectView(R.id.topTitle)
    TextView mTitle;

    int a=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
//        Fresco.initialize(this, ImagePipelineConfigFactory.getOkHttpImagePipelineConfig(this));
        Fresco.initialize(this);
        ButterKnife.inject(this);
        initData();
        initView();
    }

    private void initView() {
        mTitle.setText("简单的网络加载");
        mLeft.setImageResource(R.mipmap.returns);
    }


    private void initData() {
        Uri uri1 = Uri.parse("http://i3.hoopchina.com.cn/blogfile/201212/21/135605895528067.gif");//动态图
        Uri uri = Uri.parse("http://www.chinanews.com/fileftp/2010/04/2010-04-02/U179P4T47D12780F970DT20100402102613.jpg");//静态图
        mImageView = (SimpleDraweeView) findViewById(R.id.my_image_view);

        /*****************************************************************/
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uri1)
                .setControllerListener(controllerListener)
                .build();
        mImageView.setController(draweeController);
        Animatable animatable = mImageView.getController().getAnimatable();
        if (animatable != null) {
            if (a % 2 == 0) {
                Log.i("lyx", "开始: ");
                /**开始播放*/
                animatable.start();
            }else {
                /**停止播放*/
                Log.i("lyx", "暂停: ");
                animatable.stop();
            }
        }
        /*****************************************************************/
    }

    /**
     * 手动控制动画播放
     */
    ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
        @Override
        public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
            if (animatable != null) {
                if (a % 2 == 0) {
                    Log.i("lyx", "开始: ");
                    /**开始播放*/
                    animatable.start();
                }else {
                    /**一段时间后根据业务逻辑，停止播放*/
                    Log.i("lyx", "暂停: ");
                    animatable.stop();
                }
            }
        }
    };


    @OnClick({R.id.topLeft, R.id.my_image_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.topLeft:
                finish();
                break;
            case R.id.my_image_view:
                if (a == 1) {
                    a+=1;
                    Log.i("lyx", "___________: "+a);
                }else {
                    a-=1;
                    Log.i("lyx", "___________: "+a);
                }
                initData();
                break;
        }
    }
}
