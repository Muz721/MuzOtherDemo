package com.muz.muzotherdemo.activity.impl;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.AppCompatDrawableManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.muz.muzotherdemo.R;
import com.muz.muzotherdemo.activity.BaseActivity;
import com.muz.muzotherdemo.customerview.CompositionAvatarView;
import com.muz.muzotherdemo.util.BindingUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Muz
 * @description Discussion group icon
 * @date 2018/4/7 13:18
 */

public class DiscussionGroupIconActivity extends BaseActivity {


    @BindView(R.id.dynamicDrawables)
    CompositionAvatarView dynamicDrawables;
    @BindView(R.id.title_back_img)
    ImageView titleBackImg;
    @BindView(R.id.title_back)
    RelativeLayout titleBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.title_more_img)
    ImageView titleMoreImg;
    @BindView(R.id.title_more)
    RelativeLayout titleMore;
    @BindView(R.id.gif)
    CompositionAvatarView gif;
    @BindView(R.id.vector_diagram)
    CompositionAvatarView vectorDiagram;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_discussion_group_icon);
        titleBackImg.setImageResource(R.drawable.ic_chevron_left_black_24dp);
        titleName.setText("DISCUSSION_GROUP_ICON");
        dynamicDrawables(dynamicDrawables);
        gif(gif);
        vector(vectorDiagram);
    }

    private void dynamicDrawables(CompositionAvatarView view) {
        Resources resources = getResources();
        Drawable[] drawables = {
                resources.getDrawable(R.drawable.image_1),
                resources.getDrawable(R.drawable.image_2),
                resources.getDrawable(R.drawable.image_3),
                resources.getDrawable(R.drawable.image_4),
                resources.getDrawable(R.drawable.image_5)
        };

        view.addDrawable(drawables[0]);
        view.addDrawable(drawables[1]);
        view.addDrawable(drawables[2]);
        view.addDrawable(drawables[3]);
        view.addDrawable(drawables[4]);
    }

    private void gif(CompositionAvatarView view) {
        BindingUtil.asyncLoadDrawable(view, R.drawable.ambilight, R.drawable.nebula, R.drawable.galaxy);
    }
    private void vector(CompositionAvatarView view) {
        view.addDrawable(getResources().getDrawable(R.drawable.cloud_circle));
        view.addDrawable(getResources().getDrawable(R.drawable.album));
        view.addDrawable(getResources().getDrawable(R.drawable.group_work));
    }
    @OnClick({R.id.title_back, R.id.title_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_more:
                break;
        }
    }
}
