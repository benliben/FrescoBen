package com.example.benben.fresco.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.benben.fresco.R;
import com.example.benben.fresco.model.MainModel;
import com.example.benben.fresco.ui.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by benben on 2016/4/28.
 */
public class MainActivity extends BaseActivity {
    @InjectView(R.id.main_comment)
    RecyclerView mComment;
    @InjectView(R.id.topTitle)
    TextView mTitle;

    private MainAdapter mAdapter;
    private List<MainModel> mModels;
    private String[] mData = {"begin","ProgressBarImage"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initData();
        initVeiw();
    }

    private void initVeiw() {
        mTitle.setText("Fresco");
        mComment.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mAdapter = new MainAdapter(mData);
        mComment.setAdapter(mAdapter);
        mAdapter.setOnClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void ItemClickListener(View view, int position) {
                switch (position) {
                    case 0:
                        BeginActivity.startBeginActivity(MainActivity.this);
                        break;
                    case 1:
                        BeginActivity.startBeginActivity(MainActivity.this);
                        break;
                }
            }
        });
    }

    private void initData() {
        mModels = new ArrayList<>();
        for (int i = 0; i < mData.length; i++) {
            MainModel model = new MainModel();
            model.setName(mData[i]);
            mModels.add(model);
        }
    }
}
