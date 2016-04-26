package com.example.benben.fresco.ui.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.benben.fresco.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.my_image_view)
    SimpleDraweeView mImageView;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Fresco.initialize(this, ImagePipelineConfigFactory.getOkHttpImagePipelineConfig(this));
        Fresco.initialize(this);
        ButterKnife.inject(this);
        initData();
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
}
