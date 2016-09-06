package com.itheima.mobieplayersh10.adapter;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.mobieplayersh10.R;
import com.itheima.mobieplayersh10.bean.VideoBean;
import com.itheima.mobieplayersh10.util.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wschun on 2016/8/20.
 */
public class MyCursorAdapter extends CursorAdapter {

    public MyCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = View.inflate(context, R.layout.video_item_list, null);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(view);
        VideoBean videoBean = VideoBean.fromCursor(cursor);
        viewHolder.tvTitle.setText(videoBean.title);
        viewHolder.tvSize.setText(Formatter.formatFileSize(context,videoBean.size));
        viewHolder.tvDuration.setText(Utils.formatLongDuration(videoBean.duration));

    }

    static class ViewHolder {
        @Bind(R.id.iv_icon)
        ImageView ivIcon;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_duration)
        TextView tvDuration;
        @Bind(R.id.tv_size)
        TextView tvSize;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public  static  ViewHolder getViewHolder(View view){
            ViewHolder tag = (ViewHolder) view.getTag();
            if (tag==null){
                tag=new ViewHolder(view);
                view.setTag(tag);
            }
            return tag;
        }
    }
}
