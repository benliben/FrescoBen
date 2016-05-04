package com.example.benben.fresco.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.benben.fresco.R;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by benben on 2016/5/4.
 * 监听下载事件
 */
public class MonitorActivity extends BaseActivity {
    @InjectView(R.id.topRight)
    ImageView mRight;
    @InjectView(R.id.topTitle)
    TextView mTitle;
    @InjectView(R.id.topLeft)
    ImageView mLeft;
    @InjectView(R.id.monitor_content)
    SimpleDraweeView mContent;
    @InjectView(R.id.monitor_text)
    TextView mText;

    public static void startMonitorActivity(Activity activity) {
        Intent intent = new Intent(activity, MonitorActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            /**加载完成*/
            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                if (imageInfo == null) {
                    return;
                }
                QualityInfo qualityInfo = imageInfo.getQualityInfo();

                Toast.makeText(MonitorActivity.this,"加载完成",Toast.LENGTH_LONG).show();
                mText.setText("我的攀爬");
            }
            /**加载中*/

            @Override
            public void onIntermediateImageSet(String id, ImageInfo imageInfo) {
                Log.i("lyx", "Intermediate image received");
                mText.setText("加载中我的攀爬");
            }

            /**加载失败*/
            @Override
            public void onFailure(String id, Throwable throwable) {
                FLog.e(getClass(), throwable, "Error loading %s", id);
                mText.setText("请检查网络");
            }
        };

        Uri uri = Uri.parse("http://fj.heze.cc/attachments/forum/month_0907/20090726_3a990fc8bcb6fa1d3878pAMBPjA75B65.jpg");
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setControllerListener(controllerListener)
                .setUri(uri)
                .build();
        mContent.setController(controller);

    }
}
