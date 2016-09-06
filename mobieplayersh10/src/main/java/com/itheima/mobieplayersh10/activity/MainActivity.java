package com.itheima.mobieplayersh10.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.mobieplayersh10.R;
import com.itheima.mobieplayersh10.adapter.MyViewPageAdapter;
import com.itheima.mobieplayersh10.base.BaseActivity;
import com.itheima.mobieplayersh10.fragment.MusicFragment;
import com.itheima.mobieplayersh10.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    private static final String TAG ="MainActivity" ;
    @Bind(R.id.tv_video)
    TextView tvVideo;
    @Bind(R.id.tv_music)
    TextView tvMusic;
    @Bind(R.id.indicator_line)
    View indicatorLine;
    @Bind(R.id.viewPage)
    ViewPager viewPage;
    private int screenWidth;
    private List<Fragment> fragmentList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setListener() {
          viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
              /**
               * 当ViewPage滚动的时候会回调此方法
               * @param position 当前位置
               * @param positionOffset 手指在屏幕上移动的一个百分比
               * @param positionOffsetPixels  手指在屏幕上移动的距离
               */
              @Override
              public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                  Log.i(TAG, "onPageScrolled: "+position+"---"+positionOffset+"---"+positionOffsetPixels);

//                  moveOffect=indicatorWidth* position+
//                          positionOffsetPixels/list.size()

                  int moveOffect=indicatorLine.getWidth()*position+positionOffsetPixels/fragmentList.size();

                  ViewCompat.setTranslationX(indicatorLine,moveOffect);

              }

              @Override
              public void onPageSelected(int position) {
                  updateTitle();
              }

              @Override
              public void onPageScrollStateChanged(int state) {

              }
          });
    }

    /**
     * 修改标题的颜色及动画
     */
    private void updateTitle() {

        int position=viewPage.getCurrentItem();

        tvVideo.setSelected(position==0);
        tvMusic.setSelected(position==1);


        ViewCompat.animate(tvVideo).scaleX(position==0?1.0f:0.8f)
                .scaleY(position==0?1.0f:0.8f)
                .setDuration(500)
                .start();

        ViewCompat.animate(tvMusic).scaleX(position==1?1.0f:0.8f)
                .scaleY(position==1?1.0f:0.8f)
                .setDuration(500)
                .start();
//        if (position==0){
//            tvVideo.setSelected(true);
//            tvMusic.setSelected(false);
//        }else {
//            tvVideo.setSelected(false);
//            tvMusic.setSelected(true);
//        }

    }

    @Override
    public void setData() {
        screenWidth = getWindowManager().getDefaultDisplay().getWidth();

        fragmentList = new ArrayList<>();
        fragmentList.add(new VideoFragment());
        fragmentList.add(new MusicFragment());

        MyViewPageAdapter myViewPageAdapter=new MyViewPageAdapter(getSupportFragmentManager(), fragmentList);
        viewPage.setAdapter(myViewPageAdapter);

        //初始化指示线的宽度
        initIndicatorLine();
        //修改标题的颜色，及动画
        updateTitle();



    }

    private void initIndicatorLine() {
        int width=screenWidth/fragmentList.size();
        ViewGroup.LayoutParams layoutParams = indicatorLine.getLayoutParams();
        layoutParams.width=width;
        indicatorLine.setLayoutParams(layoutParams);


    }


    @OnClick({R.id.tv_video, R.id.tv_music})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_video:
             viewPage.setCurrentItem(0);

                break;
            case R.id.tv_music:
                viewPage.setCurrentItem(1);
                break;
        }
    }
}
