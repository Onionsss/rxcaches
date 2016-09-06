package com.itheima.mobieplayersh10.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;

import com.itheima.mobieplayersh10.R;
import com.itheima.mobieplayersh10.base.BaseActivity;

import butterknife.Bind;

public class SplishActivity extends BaseActivity {


    @Bind(R.id.ll_content)
    LinearLayout llContent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splish;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void setData() {

        int height = getWindowManager().getDefaultDisplay().getHeight();
        //移出屏幕隐藏
        ViewCompat.setTranslationY(llContent,height);
        //显示移动效果
        ViewCompat.animate(llContent).
                setDuration(800).
                translationY(0f).
                setStartDelay(500).
                setInterpolator(new OvershootInterpolator()).
                start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent mIntent=new Intent(SplishActivity.this,MainActivity.class);
                startActivity(mIntent);
                finish();
            }
        },1500);







    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        do nothing
    }
}
