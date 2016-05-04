package com.example.benben.fresco.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.example.benben.fresco.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by benben on 2016/5/4.
 *
 * 缩放
 * <p>
 * 属性
 * 1.center  居中无缩放
 * 2.centerCrop 保持宽高比缩小或放大，使得两边都大于或等于显示边界，且宽或高契合显示边界。居中显示。
 * 3.focusCrop 	同centerCrop, 但居中点不是中点，而是指定的某个点。
 * 4.centerInside 	缩放图片使两边都在显示边界内，居中显示。和 fitCenter 不同，不会对图片进行放大。
 * 如果图尺寸大于显示边界，则保持长宽比缩小图片
 * 5.fitCenter 	保持宽高比，缩小或者放大，使得图片完全显示在显示边界内，且宽或高契合显示边界。居中显示。
 * 6.fitStart 	同上。但不居中，和显示边界左上对齐。
 * 7.fitEnd 	同fitCenter， 但不居中，和显示边界右下对齐。
 * 8.fitXY 	不保存宽高比，填充满显示边界。
 * 9.none 	如要使用tile mode显示, 需要设置为none
 */
public class TheZoomActivity extends BaseActivity {
    @InjectView(R.id.the_zoom)
    SimpleDraweeView mZoom;

    public static void startTheZoomActivity(Activity activity) {
        Intent intent = new Intent(activity, TheZoomActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thezoom);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        Uri uri=Uri.parse("http://img04.tooopen.com/images/20131211/sy_51301885361.jpg");
mZoom.setImageURI(uri);
    }

}
