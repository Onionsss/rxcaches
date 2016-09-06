package com.itheima.mobieplayersh10.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by wschun on 2016/8/20.
 */
public abstract class BaseActivity extends AppCompatActivity implements UIOperation {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        //设置监听
        setListener();
        //设置数据
        setData();
    }


}
