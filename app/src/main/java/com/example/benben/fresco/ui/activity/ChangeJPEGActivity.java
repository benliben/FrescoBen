package com.example.benben.fresco.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.example.benben.fresco.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by tangjunjie on 2016/5/4.
 */
public class ChangeJPEGActivity extends BaseActivity {
    @InjectView(R.id.change_up)
    SimpleDraweeView mUp;
    @InjectView(R.id.change_down)
    SimpleDraweeView mDown;

    public static void startChangeJPEGAdapter(Activity activity) {
        Intent intent = new Intent(activity, ChangeJPEGActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_jpeg);
        ButterKnife.inject(this);
        initData();
        initView();
    }

    private void initView() {
        Uri uri = Uri.parse("http://www.chinanews.com/fileftp/2010/04/2010-04-02/U179P4T47D12780F970DT20100402102613.jpg");
        ImageRequest request = ImageRequestBuilder
                .newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();
        PipelineDraweeController controller= (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(mUp.getController())
                .build();
        mUp.setController(controller);
    }

    private void initData() {

        ProgressiveJpegConfig pjpegConfig = new ProgressiveJpegConfig() {
            @Override
            public int getNextScanNumberToDecode(int scanNumber) {
                return scanNumber + 2;
            }

            @Override
            public QualityInfo getQualityInfo(int scanNumber) {
                boolean isGoodEnough = (scanNumber >= 5);
                return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
            }
        };
//        ImagePipelineConfig config = ImagePipelineConfig.newBuilder()
//                .setBitmapsConfig(pjpeg)
//                .build();
    }
}
