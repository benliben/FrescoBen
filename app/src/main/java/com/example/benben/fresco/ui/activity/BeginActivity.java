package com.example.benben.fresco.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benben.fresco.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

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
        /*如果是动态图需要添加如下代码*/
        /***********************************************/
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri1)
                .setAutoPlayAnimations(true)
                .build();
        mImageView.setController(controller);
        /************************************************/

//        mImageView.setImageURI(uri);
    }

    @OnClick(R.id.topLeft)
    public void onClick() {
        finish();
    }
}
