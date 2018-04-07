package com.muz.muzotherdemo.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;


import com.muz.muzotherdemo.R;
import com.muz.muzotherdemo.activity.impl.DiscussionGroupIconActivity;
import com.muz.muzotherdemo.adapter.AdapterRecyclerViewMain;
import com.muz.muzotherdemo.entity.ModelMainItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.demo_classify)
    RecyclerView demoClassify;
    @BindView(R.id.title_name)
    TextView titleName;
    private List<ModelMainItem> demoClassifyData;
    private int mColumnCount = 3;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);
        titleName.setText("DEMO CLASSIFY");
        initData();
        initView();
        int yu=1&2;
        int huo=1|3;
        int fei=~4;
        int yihuo=1^4;
        int zuoyi=1<<3;
        int youyi=4>>>2;
        int youyi1=4>>2;
        int youyi2=-4>>>1;
        int ss=1*2^4;
        int ff=4/2^2;
    }

    private void initData() {
        demoClassifyData = new ArrayList<>();
        demoClassifyData.add(new ModelMainItem("DiscussionGroupIcon", R.drawable.muz, DiscussionGroupIconActivity.class));
    }

    private void initView() {
        if (mColumnCount <= 1) {
            demoClassify.setLayoutManager(new LinearLayoutManager(this));
        } else {
            demoClassify.setLayoutManager(new GridLayoutManager(this, mColumnCount));
        }

//        demoClassify.addItemDecoration(new MuzRecyclerViewDividerTool(RxImageTool.dp2px(5f)));
        AdapterRecyclerViewMain recyclerViewMain = new AdapterRecyclerViewMain(demoClassifyData);

        demoClassify.setAdapter(recyclerViewMain);
    }
}
