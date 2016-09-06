package com.itheima.mobieplayersh10.bean;

import android.database.Cursor;
import android.provider.MediaStore;

import java.io.Serializable;

/**
 * Created by wschun on 2016/8/20.
 */
public class VideoBean implements Serializable {
    public String title;
    public String path;
    public long duration;
    public int size;

    public static VideoBean fromCursor(Cursor cursor){
        VideoBean videoBean=new VideoBean();

        videoBean.title=cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.TITLE));
        videoBean.path=cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
        videoBean.duration=cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.DURATION));
        videoBean.size=cursor.getInt(cursor.getColumnIndex(MediaStore.Video.Media.SIZE));
        return  videoBean;
    }



}
