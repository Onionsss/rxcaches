package com.itheima.mobieplayersh10.adapter;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.widget.CursorAdapter;

import com.itheima.mobieplayersh10.util.Utils;

/**
 * Created by wschun on 2016/8/20.
 */
public class MyQueryHandler extends AsyncQueryHandler {

    public MyQueryHandler(ContentResolver cr) {
        super(cr);
    }


    @Override
    protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
        super.onQueryComplete(token, cookie, cursor);
       if (cookie!=null && cookie instanceof CursorAdapter){
          MyCursorAdapter myCursorAdapter= (MyCursorAdapter) cookie;
           myCursorAdapter.changeCursor(cursor);
       }

        Utils.printCursor(cursor);

    }
}
