package com.itheima.mobieplayersh10.util;

import android.database.Cursor;
import android.util.Log;

/**
 * Created by wschun on 2016/8/20.
 */
public class Utils {
    private static final String TAG = "Utils";

    /**
     * 通过Cursor打印查询到的数据
     * @param cursor
     */
    public  static  void printCursor(Cursor cursor){

        if (cursor==null)
            return;

        Log.i(TAG, "printCursor: 当前查询到的数据个数"+cursor.getCount());

        while (cursor.moveToNext()){
           int columnCount=cursor.getColumnCount();
            Log.i(TAG, "--------------------------------------");
            for (int i=0;i<columnCount;i++){
                String columnName=cursor.getColumnName(i);
                String columnVolue= cursor.getString(i);

                Log.i(TAG, "printCursor:columnName="+columnName+"---->columnVolue="+columnVolue);

            }


        }


    }

    /**
     * 00:00:00
     * @param duration
     * @return
     */
    public static String formatLongDuration(long duration){
        int HOUR=60*60*1000;
        int MINUTE=60*1000;
        int SECOND=1000;
        //计算小时
        int hour= (int) (duration/HOUR);
        //获取剩余时间
        long remain=duration%HOUR;
        //计算分钟
        int minute= (int) (remain/MINUTE);
        remain=remain%MINUTE;
        //计算秒
        int second= (int) (remain/SECOND);

        if (hour==0){
            return  String.format("%02d:%02d",minute,second);
        }else
            return  String.format("%02d:%02d:%02d",hour,minute,second);

    }


}
