package com.example.benben.fresco.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.example.benben.fresco.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by benben on 2016/5/4.
 * 多图请求及图片复用
 */
public class SwitchActivity extends BaseActivity {
    @InjectView(R.id.switch_content)
    SimpleDraweeView mContent;
    @InjectView(R.id.switch_content)
    SimpleDraweeView mContentdown;

    public static void startSwitchActivity(Activity activity) {
        Intent intent = new Intent(activity, SwitchActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        /**先加载像素低的再加载像素高度*/
        Uri lowResUri = Uri.parse("http://fj.heze.cc/attachments/forum/month_0907/20090726_3a990fc8bcb6fa1d3878pAMBPjA75B65.jpg");
        Uri highResUri = Uri.parse("http://hiphotos.baidu.com/xjpgh/pic/item/b1f850314236c62debc4afb7.jpg");
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setLowResImageRequest(ImageRequest.fromUri(lowResUri))
                .setImageRequest(ImageRequest.fromUri(highResUri))
                .setOldController(mContent.getController())
                .build();
        mContent.setController(controller);



        /**先在内存中搜寻图片，然后是磁盘缓存，最后是网络获取*/
        ImageRequest request = ImageRequest.fromUri(lowResUri);
        ImageRequest request2 = ImageRequest.fromUri(highResUri);
        ImageRequest[] requests = {request, request2};
        DraweeController controller1=Fresco.newDraweeControllerBuilder()
                .setFirstAvailableImageRequests(requests)
                .setOldController(mContentdown.getController())
                .build();
        mContentdown.setController(controller1);
    }
}
