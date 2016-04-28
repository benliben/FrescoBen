package com.example.benben.fresco.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benben.fresco.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by benben on 2016/4/28.
 */
public class ProgressBarImageActivity extends BaseActivity {

    public static void startProgressBarImageActivity(Activity activity) {
        Intent intent = new Intent(activity, ProgressBarImageActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
    @InjectView(R.id.topTitle)
    TextView mTitle;
    @InjectView(R.id.topLeft)
    ImageView mLeft;
    @InjectView(R.id.progressbar)
    SimpleDraweeView mProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbarimage);
        ButterKnife.inject(this);
        initData();
        initView();
    }

    private void initView() {
        mTitle.setText("ProgressBar");
        mLeft.setImageResource(R.mipmap.returns);
    }

    private void initData() {
    }

    @OnClick(R.id.topLeft)
    public void onClick() {
        finish();
    }
}
