package com.itheima.mobieplayersh10.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.itheima.mobieplayersh10.R;
import com.itheima.mobieplayersh10.base.BaseActivity;
import com.itheima.mobieplayersh10.bean.VideoBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wschun on 2016/8/20.
 */
public class VideoActivity extends BaseActivity {
    private static final String TAG = "VideoActivity";
    @Bind(R.id.vv_video)
    VideoView vvVideo;

    @Override
    public int getLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void setData() {
        int position = getIntent().getIntExtra("position", -1);
        List<VideoBean> videolist = (List<VideoBean>) getIntent().getSerializableExtra("videolist");
        VideoBean videoBean=videolist.get(position);
        Log.i(TAG, "position=" + position + "--" + videolist.size());
        playVideo(videoBean);

        
    }

    private void playVideo(VideoBean videoBean) {
        vvVideo.setVideoPath(videoBean.path);
        vvVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                vvVideo.start();
            }
        });

    }


}
