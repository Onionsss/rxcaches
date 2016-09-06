package com.itheima.mobieplayersh10.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Video;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;

import com.itheima.mobieplayersh10.R;
import com.itheima.mobieplayersh10.activity.VideoActivity;
import com.itheima.mobieplayersh10.adapter.MyCursorAdapter;
import com.itheima.mobieplayersh10.adapter.MyQueryHandler;
import com.itheima.mobieplayersh10.base.BaseFragment;
import com.itheima.mobieplayersh10.bean.VideoBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wschun on 2016/8/20.
 */
public class VideoFragment extends BaseFragment {
    @Bind(R.id.lv_video)
    ListView lvVideo;
    private MyCursorAdapter myCursorAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    public void setListener() {
        lvVideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Cursor cursor = (Cursor) myCursorAdapter.getItem(position);

                Intent mIntent=new Intent(getActivity(),VideoActivity.class);
                mIntent.putExtra("position",position);
                mIntent.putExtra("videolist", (Serializable) getVideoListFromCursor(cursor));
                startActivity(mIntent);
            }
        });
    }

    private List<VideoBean> getVideoListFromCursor(Cursor cursor) {
        List<VideoBean> videoList=new ArrayList<>();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()){
            videoList.add(VideoBean.fromCursor(cursor));
        }

        return videoList;
    }

    @Override
    public void setData() {

        myCursorAdapter = new MyCursorAdapter(getActivity(), null);
        lvVideo.setAdapter(myCursorAdapter);


        Uri uri = Video.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {Video.Media._ID,Video.Media.TITLE, Video.Media.DURATION, Video.Media.SIZE, Video.Media.DATA};
        //Android系统只能识别mp3,3gp

//        Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
//        Utils.printCursor(cursor);

        MyQueryHandler myQueryHandler = new MyQueryHandler(getActivity().getContentResolver());
        myQueryHandler.startQuery(1, myCursorAdapter, uri, projection, null, null, null);


    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
