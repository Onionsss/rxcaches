package onionsss.it.netrequest.global;

import android.graphics.drawable.Drawable;


/**
 * 常用工具方法,如获取各种资源的方法(字符串，颜色，dimens资源)
 * Created by heima_sy on 2016/5/23.
 */
public class Utils {
    /**
     * 在主线程执行任务
     */
    public static void runOnUIThread(Runnable runnable){
        GoogleApp.mainHandler.post(runnable);
    }

    /**
     * 得到字符串
     * @param resId
     * @return
     */
    public static String getString(int resId){
        return GoogleApp.sContext.getResources().getString(resId);
    }

    /**
     * 得到字符串数组
     * @param resId
     * @return
     */
    public static String[] getStringArray(int resId){
        return GoogleApp.sContext.getResources().getStringArray(resId);
    }

    public static int getColor(int resId){
        return GoogleApp.sContext.getResources().getColor(resId);
    }

    public static Drawable getDrawable(int resId){
        return GoogleApp.sContext.getResources().getDrawable(resId);
    }

    /**
     * 获取定义的dp资源,并且会自动将dp值转为像素
     * @param resId
     * @return
     *
     */
    public static int getDimens(int resId){
        return GoogleApp.sContext.getResources().getDimensionPixelSize(resId);
    }
}
