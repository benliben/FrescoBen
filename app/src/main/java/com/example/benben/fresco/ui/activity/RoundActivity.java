package com.example.benben.fresco.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.example.benben.fresco.R;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by benben on 2016/5/4.
 * 圆角/圆圈
 * <p>
 * 1.圆圈—设置 roundAsCircle 为true
 * 1.圆角—设置 roundedCornerRadius 为true
 * 设置圆角时，支持四个角不同的半径。XML中无法配置，但可以在Java中配置
 */
public class RoundActivity extends BaseActivity {
    @InjectView(R.id.round_content)
    SimpleDraweeView mContent;

    public static void startRoundActivity(Activity activity) {
        Intent intent = new Intent(activity, RoundActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        Uri uri=Uri.parse("http://img04.tooopen.com/images/20131211/sy_51301885361.jpg");
        mContent.setImageURI(uri);
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(7f);
        roundingParams.setOverlayColor(R.color.colorPrimaryDark);
        /**或用fromCornersRadii以及asCircle方法*/
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(null);
        genericDraweeHierarchyBuilder.setRoundingParams(roundingParams);
        /**可以在运行时改变圆角效果*/
        RoundingParams roundingParamss = mContent.getHierarchy().getRoundingParams();
        roundingParamss.setBorder(R.color.colorPrimaryDark, 1);//设置边界颜色和宽度
//        roundingParamss.setRoundAsCircle(true);
        mContent.getHierarchy().setRoundingParams(roundingParamss);
    }
}
