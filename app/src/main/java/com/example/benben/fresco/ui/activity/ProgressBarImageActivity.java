package com.example.benben.fresco.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
